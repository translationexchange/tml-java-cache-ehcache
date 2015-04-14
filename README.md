<p align="center">
  <img src="https://avatars0.githubusercontent.com/u/1316274?v=3&s=200">
</p>

TML EHCache Adapter
==================

This cache adapter allows you to cache Tr8n data in EHCache. 


Installation
==================

Add the following dependency to your pom.xml:

```xml
<dependency>
  <groupId>com.translationexchange</groupId>
  <artifactId>cache-ehcache</artifactId>
  <version>0.2.1</version>
</dependency>
```


Configuration
==================

To initialize and use this cache adapter use the following settings:

```java

Tml.getConfig().setCache(Utils.buildMap(
  "class",  "com.translationexchange.cache.EHCache",
  "version",  1,
  "timeout",  3600
));

```

Links
==================

* Register on TranslationExchange.com: https://translationexchange.com

* Follow TranslationExchange on Twitter: https://twitter.com/translationx

* Connect with TranslationExchange on Facebook: https://www.facebook.com/translationexchange

* If you have any questions or suggestions, contact us: support@translationexchange.com


Copyright and license
==================

Copyright (c) 2015 Translation Exchange, Inc.

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


