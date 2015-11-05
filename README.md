## 说明
Jfinal框架jsp、beetl模版，js、css在线合并压缩插件！

结合CDN使用效果更佳哦

## 依赖
1. JFinal

2. yuicompressor

3. commons-io

## 使用
```
<dependency>
    <groupId>net.dreamlu</groupId>
    <artifactId>JFinal-assets</artifactId>
    <version>0.0.1</version>
</dependency>
```

###Beetl中使用
###自定义标签
```
##自定义标签
TAG.assets = net.dreamlu.ui.beetl.AssetsTag
```
###js
```
<#assets file="/assets/assets.jjs"; src>
    <script src="${ctxPath}${src}"></script>
</#assets>
```
###css
```
<#assets file="/assets/assets.jcss"; href>
    <link rel="stylesheet" href="${ctxPath}${href}">
</#assets>
```

file: 需要压缩的js、css列表

assets.jjs示例：
```
#开头表注释
/js/jquery.min.js
/js/jquery-ui.min.js
/js/modernizr.min.js
/js/superfish.min.js
/js/application.js
```

###JSP中使用

首先、导入标签库
```
<%@ taglib prefix="assets" uri="http://www.dreamlu.net/tags/assets.tld" %>
```

同理如beetl
```
<assets:assets var="x" file="/assets/assets.jjs">
	<script src="${x}" type="text/javascript" ></script>
</assets:assets>
```
###freemarker中使用

首先、配置（可在JFinal的config中完成）
``` 
FreeMarkerRender.getConfiguration().setSharedVariable("assets", new AssetsDirective());
```

同理如beetl
```
<@assets var="x" file="/assets/assets.jjs">
	<script src="${x}" type="text/javascript" ></script>
</@assets>
```

## 文章
[对css，js压缩之combo以及七牛cdn的思考:http://blog.dreamlu.net/blog/47](http://blog.dreamlu.net/blog/47)

## 交流群
如梦技术：[`237587118`](http://shang.qq.com/wpa/qunwpa?idkey=f78fcb750b4f72c92ff4d375d2884dd69b552301a1f2681af956bd32700eb2c0)

## License

( The MIT License )