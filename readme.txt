1：maven中TestHello TestSquare 与  jenkins自动化回归测试
2：TestMockito  mock测试基本语法
3：mockitodemo 实例  http://blog.csdn.net/zhoudaxia/article/details/33056093
1) 在进行模拟测试时，要先设置模拟对象上方法的返回预期值，执行测试时会调用模拟对象上的方法，因此要验证这些方法是否被调用，并且传入的参数值是否符合预期。
PersonServiceTest  验证了 更新及不更新Person情况，（dao层未有的情况）
4:jetty包中的，jetty模拟服务端作为测试桩进行接口测试详细介绍 ，HttpServerDemo运行后，
http://localhost:19993/test/ChannelFaqSearch及 http://localhost:19993/test/ExecuteCampaign 访问后，分别返回：json 及  xml 内容。
参考：http://blog.csdn.net/russ44/article/details/52247455
5：httptest 包 及 util包     http的 get 及  post请求。
6：socket包： socket请求 及nio的方式
7：fastjson ：json 格式数据处理实例
8：nio：Selector Channel  非阻塞式交互实例
       byteBuffer 的应用（对传送数据的解析）
9：datamake：不同存储中数据处理
10:com.lcj.testng及testng.xml及pom中，在testng.xml上run as 后，会生成 test-output文件夹
http://howtodoinjava.com/java-testng-tutorials/
 dependent：接口依赖其它接口
 factory: login into a site and you want to run this test multiple times  (may be to test any memory leak issues).
 dataprovider: login into a site with different sets of username and password each time.
 factory 与 dataprovider的区别
 Parallel* ：并行（多线程）地执行测试方法，测试类以及测试组件及 配置需要在多线程环境下运行的测试方法。
 11:mavenBuild TODO