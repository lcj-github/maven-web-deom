package com.lcj.annotation.exercise4;

import java.lang.reflect.Field;  
import java.lang.reflect.Method;  

//本例子旨在使用自定义注解为实体打上标记，为自动生成 sql 提供依据，模拟 hibernate 的注解，
public class Test {

	public static void main(String[] args) {  
        TestDto testDto = new TestDto("123", "34");  
        TestDto testDto1 = new TestDto("123", "test1");  
        TestDto testDto2 = new TestDto("", "test1,test2,test3,test4");  
        String sql = assembleSqlFromObj(testDto);  
        String sql1 = assembleSqlFromObj(testDto1);  
        String sql2 = assembleSqlFromObj(testDto2);  
        System.out.println(sql);  //select * from tb_test where 1=1  and _id=123  and username=34
        System.out.println(sql1); //select * from tb_test where 1=1  and _id=123  and username like '%test1%' 
        System.out.println(sql2); //select * from tb_test where 1=1  and username in (test1,test2,test3,test4) 
        		 
    }  
  
    /** 
     * 通过注解来组装查询条件，生成查询语句 
     *  
     * @param obj 
     * @return 
     */  
    public static String assembleSqlFromObj(Object obj) {  
        Table table = obj.getClass().getAnnotation(Table.class);  
        StringBuffer sbSql = new StringBuffer();  
        String tableName = table.value();  
        sbSql.append("select * from " + tableName + " where 1=1 ");  
        Field[] fileds = obj.getClass().getDeclaredFields();  
        for (Field f : fileds) {  
            String fieldName = f.getName();  
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase()  
                    + fieldName.substring(1);  
            try {  
                Column column = f.getAnnotation(Column.class);  
                if (column != null) {  
                    Method method = obj.getClass().getMethod(methodName);  
                    String value = (String) method.invoke(obj);
                    System.out.println("==value=="+value);
                    if (value != null && !value.equals("")) { 
                    	//不是id且值不为数字型
                        if (!isNum(column.value()) && !isNum(value)) {  
                            // 判断参数是不是 in 类型参数 1,2,3  
                            if (value.contains(",")) {  
                                sbSql.append(" and " + column.value() + " in (" + value + ") ");  
                            } else {  
                                sbSql.append(" and " + column.value() + " like '%" + value + "%' ");  
                            }  
                        } else {  
                            sbSql.append(" and " + column.value() + "=" + value + " ");  
                        }  
                    }  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return sbSql.toString();  
    }  
  
    /** 
     * 检查给定的值是不是 id 类型 1.检查字段名称 2.检查字段值 
     *  
     * @param target 
     * @return 
     */  
    public static boolean isNum(String target) {  
        boolean isNum = false;  
        if (target.toLowerCase().contains("id")) {  
            isNum = true;  
        }  
        if (target.matches("\\d+")) {  
            isNum = true;  
        }  
        return isNum;  
    }
}
