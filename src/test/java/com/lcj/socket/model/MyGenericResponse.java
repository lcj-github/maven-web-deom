package com.lcj.socket.model;

public class MyGenericResponse implements MyResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object obj = null;

	public MyGenericResponse(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object getResult() {
		return obj;
	}
}

