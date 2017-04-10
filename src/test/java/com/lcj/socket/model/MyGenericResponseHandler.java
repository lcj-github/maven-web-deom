package com.lcj.socket.model;

public class MyGenericResponseHandler<T> implements MyResponseHandler<T> {
	@SuppressWarnings("unchecked")
	@Override
	public T handle(MyResponse response) {
		return (T) response.getResult();
	}

}
