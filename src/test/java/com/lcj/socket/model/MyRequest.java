package com.lcj.socket.model;

import java.io.Serializable;

public interface MyRequest extends Serializable {

	Class<?> getRequestClass();

	String getRequestMethod();

	Class<?>[] getRequestParameterTypes();

	Object[] getRequestParameterValues();

}

