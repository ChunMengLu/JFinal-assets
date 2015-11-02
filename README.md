## 依赖
1. JFinal

2. Beetl

3. yuicompressor

4. commons-io

## 使用
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

file: 需要压缩的js、css列表，#开头表注释

## 文章
[对css，js压缩之combo以及七牛cdn的思考:http://blog.dreamlu.net/blog/47](http://blog.dreamlu.net/blog/47)

## 说明
结合CDN使用效果更佳哦

## 交流群
如梦技术：[`237587118`](http://shang.qq.com/wpa/qunwpa?idkey=f78fcb750b4f72c92ff4d375d2884dd69b552301a1f2681af956bd32700eb2c0)

## License

( The MIT License )