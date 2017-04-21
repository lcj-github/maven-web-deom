package com.lcj.util.gat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;



public class ClassReflectorTest {
	
	
	  @Test
	  public void invokeMethodTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	  {
		  /*Object targetClassInstanceObject= ClassReflector.createInstance(methodInfo.jarFilePath,methodInfo.classFullName); //create target instance
			Method targetMethod= ClassReflector.getMethod(targetClassInstanceObject,methodInfo.methodName,methodInfo.parameters.toArray());
			SimpleLogger.logInfo(this.getClass(),targetMethod.getName());
			return targetMethod.invoke(targetClassInstanceObject,methodInfo.parameters.toArray());*/
		  
		  Object targetClassInstanceObject= ClassReflector.createInstance("com.lcj.util.gat.Student");
		  Method targetMethod= ClassReflector.getMethod(targetClassInstanceObject,"printz");
		  System.out.println(targetMethod.getName());  //printz	
		  String methodReturn  = (String)targetMethod.invoke(targetClassInstanceObject);		  	  
		  System.out.println(methodReturn);			   //helloworld
		  
	  }
	
	  @Test
	  public void setFiledTest()
	  {
		  Person jackPerson=new Person();
		  try 
		  {
			ClassReflector.setFiled(jackPerson.getClass(),jackPerson,"age", 18);
			System.out.println(jackPerson.getAge());
			ClassReflector.setFiled(jackPerson.getClass(),jackPerson,"name","baidu");
			System.out.println(jackPerson.getAge());
			System.out.println(jackPerson.getName());
		  } 
		  catch (Exception e)
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	  }
	
	  @Test
	  public void createInstanceTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	  {
		  String jarFilePathString="D:\\logs\\Code\\EclipseWorkSpace\\TestProject\\lib\\targetProject.jar";
		  Object targetInstanceObject= ClassReflector.createInstance(jarFilePathString,"com.baidu.targetProject.TargetClass");
	      ClassReflector.getMethod(targetInstanceObject,"targetMethod").invoke(targetInstanceObject);
	  }
	  
	  class Person
	  {
		  private Integer age=0;
		  private String name="";

		/**
		 * @return the age
		 */
		public Integer getAge()
		{
			return age;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(Integer age)
		{
			this.age = age;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	  }

}
