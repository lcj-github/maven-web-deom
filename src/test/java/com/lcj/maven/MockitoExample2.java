package com.lcj.maven;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoExample2 {
	
	 	@Mock  
	    private List mockList;  
	  
	    public MockitoExample2(){  
	        MockitoAnnotations.initMocks(this);  
	    }  
	  
	    @Test  
	    public void shorthand(){  
	        mockList.add(1);  
	        verify(mockList).add(1);  
	    } 

}
