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

Where can I get more information?
==================

* Register on Tr8nHub.com: https://tr8nhub.com

* Read Tr8nHub's documentation: http://wiki.tr8nhub.com

* Visit Tr8nHub's blog: http://blog.tr8nhub.com

* Follow Tr8nHub on Twitter: https://twitter.com/Tr8nHub

* Connect with Tr8nHub on Facebook: https://www.facebook.com/pages/tr8nhubcom/138407706218622

* If you have any questions or suggestions, contact us: feedback@tr8nhub.com



