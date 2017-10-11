## 2017.9.19:
搭建SpringBoot环境：  
- 1.dependencies与dependencyManagement的区别：  
dependencies会引入jar包，dependencyManagement不会如果父工程使用dependencyManagement，
那么子功能需要手动进行引入，版本不写默认和父工程一样，如果一个工程对应多个子工程，可以更好的进行jar包的统一版本管理。
- 2.导入了spring-boot-starter-web却没有@Controller注解：
换成1.5.2的版本就好了
- 3.启动报org.yaml.snakeyaml.parser.ParserException异常
yml文件中冒号后面必须跟空格
## 2017.9.22
开发thymleaf页面：
- 1.th:fragment定义导入页，th:include导入导入页，
th:replace同样是导入导入页，区别是th:replace会将当前标签替换
- 2.jquery load方法报错，1.8之后不支持load方法，可以用bind方法绑定
## 2017.9.26
主页设计：
- 1.banner特效设计完成，技术点：使用bind('mozAnimationEnd MSAnimationEnd oanimationend webkitAnimationEnd',function(){...})来设置CSS动画结束后的操作
- 2.背景使用canvas-nest.js来设计特效
- 3.多种外部执行JS脚本的方式：  
（1）如果async="async"：脚本相对于页面的其余部分异步地执行（当页面继续进行解析时，脚本将被执行）。
（2）如果不使用async且defer="defer"：脚本将在页面完成解析时执行。
（3）如果既不使用async也不使用defer：在浏览器继续解析页面之前，立即读取并执行脚本。
## 2017.9.27
集成mybatis：
- 1.使用mybatis.generator生成映射文件，javabean，以及dao接口
- 2.编写BASE64加密工具类
## 2017.9.28
生成二维码
- 1.编写spring boot测试，测试类上写  
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
- 2.集成log4j2
- 3.完成二维码的显示（注意事项：不要在thymeleaf模板中引入的html带上jquery插件，
否则会引起冲突导致qrcode方法无法执行）
- 4.使用jquery validate用户校验完成用户登录页面
- 5.配置热部署
- 6.配置druid连接池
- 7.完成用户登录功能
## 2017.9.30
- 1.完成用户注册功能
- 2.为service层添加事务控制
## 2017.10.4
- 1.使用jquery.imgareaselect.pack.js完成头像剪裁功能
- 2.设计guava缓存工具类
## 2017.10.6
- 1.完成后台头像裁剪功能
- 2.完成按比例缩小图片功能
- 3.使用jquery插件prettify完成代码高亮
- 4.ajax上传数组注意后台的参数名要带方括号