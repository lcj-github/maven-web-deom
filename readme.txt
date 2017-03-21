1：TestHello TestSquare 与  jenkins自动化回归测试
2：TestMockito  mock测试基本语法
3：mockitodemo 实例  http://blog.csdn.net/zhoudaxia/article/details/33056093
1) 在进行模拟测试时，要先设置模拟对象上方法的返回预期值，执行测试时会调用模拟对象上的方法，因此要验证这些方法是否被调用，并且传入的参数值是否符合预期。
PersonServiceTest  验证了 更新及不更新Person情况，