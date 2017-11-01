package com.lcj.callback.first;

//回调模式-测试类
//客户端发送msg给服务端，服务端处理后（5秒），回调给客户端，告知处理成功。
/**
 * http://ifeve.com/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BA%EF%BC%9A-java%E5%9B%9E%E8%B0%83%E6%9C%BA%E5%88%B6%E5%BC%82%E6%AD%A5/
 *  1、接口作为方法参数，其实际传入引用指向的是实现类

    2、Client的sendMsg方法中，参数为final，因为要被内部类一个新的线程可以使用。这里就体现了异步。

    3、调用server的getClientMsg()，参数传入了Client本身（对应第一点）。
 *
 */
public class CallBackTest {

	public static void main(String[] args) {
		Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("Server,Hello~");

	}

}
