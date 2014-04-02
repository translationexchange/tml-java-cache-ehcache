/*
 *  Copyright (c) 2014 Michael Berkovich, http://tr8nhub.com All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.tr8n.cache;

import java.util.Map;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.tr8n.core.Cache;
import com.tr8n.core.Tr8n;

public class EHCache extends Cache {
	public static final String CACHE_NAME = "tr8n";
	
	CacheManager singletonManager;
	Integer version;
	
	public EHCache(Map<String, Object> config) {
		super(config);
	}

	private net.sf.ehcache.Cache getCache() throws Exception {
		if (singletonManager == null) {
			singletonManager = CacheManager.create();
			singletonManager.addCache(new net.sf.ehcache.Cache(CACHE_NAME, 5000, false, false, getTimeout(), 2));
		}
		
		return singletonManager.getCache(CACHE_NAME);
	}

	public Integer getVersion() {
		try {
			Element element = getCache().get("version");
			version = (Integer) element.getObjectValue();
			if (version == null) {
				version = (Integer) getConfig().get("version");
				setVersion(version);
			}
		} catch (Exception ex) {
			version = (Integer) getConfig().get("version");
		}
		
		return version;
	}
	
	public void setVersion(Integer version) {
		try {
			getCache().put(new Element("version", version));
			this.version = version;
		} catch (Exception ex) {
		}
	}

	public void incrementVersion() {
		setVersion(getVersion() + 1);
	}
	
	protected String getVersionedKey(String key) {
		return getVersion() + "_" + key;
	}

	private int getTimeout() {
		if (getConfig().get("timeout") == null) 
			return 0;
		return (Integer) getConfig().get("timeout");
	}
	
	@Override
	public Object fetch(String key, Map<String, Object> options) {
		if (isInlineMode(options)) return null;
		
		try {
			Element element = getCache().get(getVersionedKey(key));
			return element.getObjectValue();
		} catch (Exception ex) {
			Tr8n.getLogger().logException("Failed to get a value from EHCache", ex);
			return null;
		}
	}

	@Override
	public void store(String key, Object data, Map<String, Object> options) {
		if (isInlineMode(options)) return;

		try {
			getCache().put(new Element(getVersionedKey(key), data));
		} catch (Exception ex) {
			Tr8n.getLogger().logException("Failed to store a value in EHCache", ex);
		}
	}

	@Override
	public void delete(String key, Map<String, Object> options) {
		try {
			getCache().remove(getVersionedKey(key));
		} catch (Exception ex) {
			Tr8n.getLogger().logException("Failed to delete a value from EHCache", ex);
		}
	}

}
