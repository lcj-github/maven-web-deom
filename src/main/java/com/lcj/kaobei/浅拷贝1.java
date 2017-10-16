package com.lcj.kaobei;

/**
 * 了解clone()主要做了些什么.
 * 创建一个新对象，然后将当前对象的非静态字段复制到该新对象，如果字段是值类型的，那么对该字段执行复制；
 * 如果该字段是引用类型的话，则复制引用但不复制引用的对象。
 * 因此，原始对象及其副本引用同一个对象。
 */

/* 建立类，实现Clone方法  */
class ResumeQ1  implements Cloneable{  
    private String name;  //姓名  
    private String sex;   //性别  
    private int age;      //年龄  
    private String experience; //工作经历  
      
    public ResumeQ1(String name, String sex, int age) {  
        this.name = name;  
        this.sex = sex;  
        this.age = age;  
    }  
      
    public void setAge(int age) {  
        this.age = age;  
    }  
    public int getAge() {  
        return age;  
    }  
      
    public void setExperience(String experience) {  
        this.experience = experience;  
    }  
    public String getExperience() {  
        return experience;  
    }  
      
    public void displayResume() {  
        System.out.println("姓名："+name+" 性别："+sex+" 年龄:"+age);  
        System.out.println("工作经历："+experience);  
    }  
      
    public Object clone() {  
        try {  
            return (ResumeQ1)super.clone();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}

public class 浅拷贝1 {
	public static void main(String[] args) {  
        ResumeQ1 zhangsan = new ResumeQ1("zhangsan","男",24);  
        zhangsan.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码拷贝和粘贴");  
        zhangsan.displayResume();  
        ResumeQ1 zhangsan1 = (ResumeQ1)zhangsan.clone();  
        zhangsan1.setAge(23);  
        zhangsan1.displayResume();  
        ResumeQ1 zhangsan2 = (ResumeQ1)zhangsan.clone();  
        zhangsan2.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码");  
        zhangsan2.displayResume();  
        zhangsan.displayResume();  
    }  

}
