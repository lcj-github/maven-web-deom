package com.lcj.maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatcher;


public class TestMockito {
	
	/**       验证行为                      **/
	@Test
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
	
	
	/**       模拟我们期望的结果                     **/
	@Test
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
		

	@Test(expected = IOException.class)  
	public void when_thenThrow() throws IOException {  
	    OutputStream outputStream = mock(OutputStream.class);  
	    OutputStreamWriter writer = new OutputStreamWriter(outputStream);  
	    //预设当流关闭时抛出异常  
	    doThrow(new IOException()).when(outputStream).close();  
	    outputStream.close();  
	}  
	
	/**       参数匹配                     **/
	@Test
	public void with_arguments(){  
	    Comparable comparable = mock(Comparable.class);  
	    //预设根据不同的参数返回不同的结果  
	    when(comparable.compareTo("Test")).thenReturn(1);  
	    when(comparable.compareTo("Omg")).thenReturn(2);  
	    assertEquals(1, comparable.compareTo("Test"));  
	    assertEquals(2, comparable.compareTo("Omg"));  
	    //对于没有预设的情况会返回默认值  
	    assertEquals(0, comparable.compareTo("Not stub"));  
	}
	
	
	@Test   //除了匹配制定参数外，还可以匹配自己想要的任意参数
	public void with_unspecified_arguments(){  
	    List list = mock(List.class);  
	    //匹配任意参数  
	    when(list.get(anyInt())).thenReturn(1);  
	    when(list.contains(argThat(new IsValid()))).thenReturn(true);  
	    assertEquals(1, list.get(1));  
	    assertEquals(1, list.get(999));  
	    assertTrue(list.contains(1));  
	    assertTrue(!list.contains(3));  
	}
	
	private class IsValid extends ArgumentMatcher<List>{  
	    @Override  
	    public boolean matches(Object o) {  
	        return (int)o == 1 || (int)o == 2;  
	    }  
	}
	
	
	@Test   //需要注意的是如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配
	public void all_arguments_provided_by_matchers(){  
	    Comparator comparator = mock(Comparator.class);  
	    comparator.compare("nihao","hello");  
	    //如果你使用了参数匹配，那么所有的参数都必须通过matchers来匹配  
	    verify(comparator).compare(anyString(),eq("hello"));  
	    //下面的为无效的参数匹配使用  
	    //verify(comparator).compare(anyString(),"hello");  
	} 
	

}


