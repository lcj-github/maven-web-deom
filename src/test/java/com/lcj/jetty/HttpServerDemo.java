package com.lcj.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

//http://blog.csdn.net/russ44/article/details/52247455
public class HttpServerDemo {
	
	//private static Log4jUtil log = new Log4jUtil(HttpServerDemo.class.getName());
	
		/**
		 * main方法入口
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
			try {
				Server server = new Server(19993);
				// 指定服务的端口号

				ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
				// 一个context就是一个WEB-Application

				context.setContextPath("/test");
				// 访问项目名（路径）

				server.setHandler(context);
				// servlet映射的路径，类似于web.xml的servlet url-pattern定义

				context.addServlet(new ServletHolder(new XmlResponseDemo()), "/ChannelFaqSearch");
				// 两个参数分别为拦截请求的servlet和想要拦截的路径
				context.addServlet(new ServletHolder(new JsonResponseDemo()), "/ExecuteCampaign");
				//log.info("server start.");
				System.out.println("server start.");

				// 启动服务
				server.start();
				server.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
