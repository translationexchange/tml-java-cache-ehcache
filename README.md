<p align="center">
  <img src="https://raw.github.com/tr8n/tr8n/master/doc/screenshots/tr8nlogo.png">
</p>

Tr8n EHCache Adapter
==================

This cache adapter allows you to cache Tr8n data in EHCache. 


Installation
==================

Add the following dependency to your pom.xml:

```xml
<dependency>
  <groupId>com.tr8nhub</groupId>
  <artifactId>cache-ehcache</artifactId>
  <version>0.1.0</version>
</dependency>
```


Configuration
==================

To initialize and use this cache adapter use the following settings:

```java

Tr8n.getConfig().setCache(Utils.buildMap(
  "class",  "com.tr8n.cache.EHCache",
  "version",  1,
  "timeout",  3600
));

```

Links
==================

* Register on TranslationExchange.com: https://translationexchange.com

* Read TranslationExchange's documentation: http://wiki.translationexchange.com

* Visit TranslationExchange's blog: http://blog.translationexchange.com

* Follow TranslationExchange on Twitter: https://twitter.com/translationx

* Connect with TranslationExchange on Facebook: https://www.facebook.com/translationexchange

* If you have any questions or suggestions, contact us: info@translationexchange.com


Copyright and license
==================

Copyright (c) 2014 Michael Berkovich, TranslationExchange.com

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

