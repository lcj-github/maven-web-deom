package com.lcj.util.gat;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;



public class ClassReflector {
	
	/**
	 * 
	 * @param classFullName
	 * @param constructorParams
	 * @return
	 */
	public static Object createInstance(String classFullName,Object[] constructorParams)
	{
		return createInstance(null, classFullName, constructorParams);		
	}

	/**
	 * 
	 * @param classFullName
	 * @return
	 */
	public static Object createInstance(String classFullName)
	{
		return createInstance(null,classFullName, null);
	}
	
	/**
	 * 
	 * @param jarFilePath
	 * @param classFullName
	 * @return
	 */
	public static Object createInstance(String jarFilePath,String classFullName)
	{
		return createInstance(jarFilePath,classFullName, null);
	}

	/**
	 * 
	 * @param jarFilePath
	 * @param classFullName
	 * @param constructorParams
	 * @return
	 */
	public static Object createInstance(String jarFilePath,String classFullName,Object[] constructorParams)
	{
		Object instance=null;
		Constructor<?> targetConstructor=null;
		try 
		{
			targetConstructor=getConstructor(jarFilePath,classFullName,constructorParams);	
			if(constructorParams==null || constructorParams.length==0)
			{
				instance=targetConstructor.newInstance();
			}
			else
			{
				instance= targetConstructor.newInstance(constructorParams);
			}
		}
		catch (Exception e)
		{
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @param instance
	 * @param methodName
	 * @param methodParams
	 * @return
	 */
	public static Method getMethod(Object instance,String methodName,Object[] methodParams)
	{
		Method targetMethod=null;
		try 
		{
			if(instance==null){throw new Exception("instance should not be null!");}
			if(methodParams==null || methodParams.length==0)
			{
				targetMethod=instance.getClass().getMethod(methodName);
			}
			else
			{
				targetMethod=instance.getClass().getMethod(methodName,getClassList(methodParams));
			}
		}
		catch (Exception e)
		{
		}
		return targetMethod;
	}
	
	/**
	 * 
	 * @param instance
	 * @param methodName
	 * @return
	 */
	public static Method getMethod(Object instance,String methodName) 
	{
       return getMethod(instance,methodName,null);
	}

	/**
	 * 
	 * @param classObject
	 * @param instance
	 * @param filedName
	 * @param filedValue
	 * @throws Exception
	 */
	public static void setFiled(Class<?> classObject,Object instance,String filedName,Object filedValue) throws Exception
	{
		Field field=classObject.getDeclaredField(filedName);
		field.setAccessible(true);
		field.set(instance,filedValue);
	}

	/**
	 * 
	 * @param jarFilePath
	 * @param classFullName
	 * @param constructorParams
	 * @return
	 */
    private static Constructor<?> getConstructor(String jarFilePath,String classFullName,Object[] constructorParams )
    {
    	Constructor<?> targetConstructor=null;
    	Class<?> targetClass=null;
    	try
    	{
    		targetClass=getClass(jarFilePath, classFullName);
    		if(constructorParams==null || constructorParams.length==0)
    		{
    			targetConstructor=targetClass.getConstructor();
    		}
    		else
    		{
    			targetConstructor=targetClass.getConstructor(getClassList(constructorParams));
    		}
		}
    	catch (Exception e) 
    	{
		}
        return targetConstructor;
    }
    
    /**
     * 
     * @param jarFilePath
     * @param classFullName
     * @return
     */
    private static Class<?> getClass(String jarFilePath,String classFullName)
    {
    	Class<?> targetClass=null;
    	try
    	{
    		if(jarFilePath==null || jarFilePath=="")
    		{
    		  targetClass=Class.forName(classFullName);
    		}
    		else
    		{
    			File f=new File(jarFilePath);
    			URL targetJarUrl=f.toURI().toURL();
    	        URLClassLoader myClassLoader=new URLClassLoader(new URL[]{targetJarUrl},Thread.currentThread().getContextClassLoader());
    	        targetClass = myClassLoader.loadClass(classFullName);
			}		
		}
    	catch (Exception e) 
    	{
    		
		}
    	return targetClass;
	}
    
    /**
     * 
     * @param instanceArray
     * @return
     */
    private static Class<?>[]  getClassList(Object[] instanceArray) 
    {
    	List<Class<?>> classList=new ArrayList<Class<?>>();
    	try 
    	{
    		System.out.print(instanceArray.length);
    		for(Object instance : instanceArray)
        	{
                if(instance==null) throw new Exception("parameters instance is null!");
                classList.add(instance.getClass());
        	}
    		
		}
    	catch (Exception e)
    	{
		}
    	Class<?>[] result=new Class<?>[classList.size()];
    	classList.toArray(result);
		return result;
	}

}
