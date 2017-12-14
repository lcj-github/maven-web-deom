package com.lcj.jvm;

import java.lang.reflect.Method;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

/** 
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M 
 * @author  
 */ 
public class JavaMethodAreaOOM {
	public static void main(String[] args) {  
        while (true) {  
            Enhancer enhancer = new Enhancer();  
            enhancer.setSuperclass(OOMObject.class);  
            enhancer.setUseCache(false);  
            enhancer.setCallback(new MethodInterceptor() {  
              
                @Override  
                public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {  
                    // TODO Auto-generated method stub  
                    return proxy.invokeSuper(obj, arg);  
                }  
            });  
            enhancer.create();  
        }  
    }  
  
    static class OOMObject {  
  
    }  

}

/* 
* Exception in thread "main" net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null 
  at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237) 
  at net.sf.cglib.proxy.Enhancer.createHelper(Enhancer.java:377) 
  at net.sf.cglib.proxy.Enhancer.create(Enhancer.java:285) 
  at baby.oom.JavaMethodAreaOOM.main(JavaMethodAreaOOM.java:28) 
Caused by: java.lang.reflect.InvocationTargetException 
  at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source) 
  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25) 
  at java.lang.reflect.Method.invoke(Method.java:597) 
  at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:384) 
  at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:219) 
  ... 3 more 
Caused by: java.lang.OutOfMemoryError: PermGen space 
  at java.lang.ClassLoader.defineClass1(Native Method) 
  at java.lang.ClassLoader.defineClassCond(ClassLoader.java:631) 
  at java.lang.ClassLoader.defineClass(ClassLoader.java:615) 
  ... 8 more 
*/  
