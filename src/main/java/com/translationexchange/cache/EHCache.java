/**
 * Copyright (c) 2016 Translation Exchange, Inc. All rights reserved.
 *
 *  _______                  _       _   _             ______          _
 * |__   __|                | |     | | (_)           |  ____|        | |
 *    | |_ __ __ _ _ __  ___| | __ _| |_ _  ___  _ __ | |__  __  _____| |__   __ _ _ __   __ _  ___
 *    | | '__/ _` | '_ \/ __| |/ _` | __| |/ _ \| '_ \|  __| \ \/ / __| '_ \ / _` | '_ \ / _` |/ _ \
 *    | | | | (_| | | | \__ \ | (_| | |_| | (_) | | | | |____ >  < (__| | | | (_| | | | | (_| |  __/
 *    |_|_|  \__,_|_| |_|___/_|\__,_|\__|_|\___/|_| |_|______/_/\_\___|_| |_|\__,_|_| |_|\__, |\___|
 *                                                                                        __/ |
 *                                                                                       |___/
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.translationexchange.cache;

import java.util.Map;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.translationexchange.core.Tml;
import com.translationexchange.core.cache.CacheAdapter;

public class EHCache extends CacheAdapter {
	public static final String CACHE_NAME = "cache";
	
	CacheManager singletonManager;

	/**
	 * EHCache constructor
	 * 
	 * @param config
	 */
	public EHCache(Map<String, Object> config) {
		super(config);
	}

	/**
	 * Returns EHCache
	 * 
	 * @return
	 * @throws Exception
	 */
	private net.sf.ehcache.Cache getCache() throws Exception {
		if (singletonManager == null) {
			singletonManager = CacheManager.create();
			singletonManager.addCache(CACHE_NAME);
		}
		
		return singletonManager.getCache(CACHE_NAME);
	}

	/**
	 * Fetch from EHCache
	 */
	public Object fetch(String key, Map<String, Object> options) {
		try {
			Element element = getCache().get(getVersionedKey(key, options));
			if (element == null || element.getObjectValue() == null) {
				debug("cache miss " + key);
				return null;
			} 
			debug("cache hit " + key);
			return element.getObjectValue();
		} catch (Exception ex) {
			Tml.getLogger().logException("Failed to get a value from EHCache", ex);
			return null;
		}
	}

	/**
	 * Stores in EHCache
	 */
	public void store(String key, Object data, Map<String, Object> options) {
		try {
			debug("cache store " + key);
			getCache().put(new Element(getVersionedKey(key, options), data));
		} catch (Exception ex) {
			Tml.getLogger().logException("Failed to store a value in EHCache", ex);
		}
	}

	/**
	 * Deletes from EHCache
	 */
	public void delete(String key, Map<String, Object> options) {
		try {
			debug("cache delete " + key);
			getCache().remove(getVersionedKey(key, options));
		} catch (Exception ex) {
			Tml.getLogger().logException("Failed to delete a value from EHCache", ex);
		}
	}
	
}
