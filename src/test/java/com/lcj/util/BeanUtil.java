package com.lcj.util;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * 将类中的属性，存放到map中
 * @author Administrator
 *
 */
public class BeanUtil {	
	
	private static final String CLASS = "class";	
	
    @SuppressWarnings("all")
    public static Map<String, String> warp(Object bean) {
        Map<String, String> propertyMap = new HashMap<String, String>();
        try {
            PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass())
                    .getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : ps) {
                String propertyName = propertyDescriptor.getName();
                if (propertyName != null && !propertyName.equals(CLASS)) {
                    Method getter = propertyDescriptor.getReadMethod();
                    if (getter != null) {
                        propertyMap.put(propertyName,
                                String.valueOf(getter.invoke(bean, null)));
                    }
                }
            }
        } catch (Exception e) {
        	System.out.println(e);
        }
        return propertyMap;
    }
    
    public static void main(String[] args)
    {
    	GamePlayer player = new GamePlayer();
    	player.setId(1001);
    	player.setName("ksfzhaohui");
    	player.setFood(100);
    	player.setDiamond(100);    	 
    	Map<String, String> beanMap = BeanUtil.warp(player);// ������ת����map    	
    	for (String key : beanMap.keySet()) {
    		   System.out.println("key= "+ key + " and value= " + beanMap.get(key));
    	}    	
    }
}
