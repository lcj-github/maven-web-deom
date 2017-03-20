package com.lcj.maven;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestMockito {
	
	@Test  //验证行为
	public void verify_behaviour(){  
	    //模拟创建一个List对象  
	    List mock = mock(List.class);  
	    //使用mock的对象  
	    mock.add(1);  
	    mock.clear();    //清空mock对象 
	    //验证add(1)和clear()行为是否发生  
	    verify(mock).add(1);  
	    verify(mock).clear();  
	} 
	
	@Test  //模拟我们期望的结果
	public void when_thenReturn(){  
	    //mock一个Iterator类  
	    Iterator iterator = mock(Iterator.class);  
	    //预设当iterator调用next()时第一次返回hello，第n次都返回world  
	    when(iterator.next()).thenReturn("hello").thenReturn("world");  
	    //使用mock的对象  
	    String result = iterator.next() + " " + iterator.next() + " " + iterator.next();  
	    //验证结果  
	    assertEquals("hello world world",result);  
	}  
	
	
	

}
