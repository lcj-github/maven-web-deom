package com.lcj.socket.model;

import java.util.List;

public interface MyUserService {
	
	List<User> list(int size);

	User findByName(String name);

	void test();


}
