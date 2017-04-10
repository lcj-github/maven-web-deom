package com.lcj.socket.model;

public interface MyResponseHandler<T> {
	
	T handle(MyResponse response);  

}
