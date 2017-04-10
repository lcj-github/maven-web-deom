package com.lcj.socket.model;

public interface MyClient {

	public <T> T execute(MyRequest request, MyResponseHandler<T> handler);

	public MyResponse execute(MyRequest request);
}
