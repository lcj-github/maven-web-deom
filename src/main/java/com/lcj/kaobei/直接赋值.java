package com.lcj.kaobei;

/**  直接赋值
 * 在Java中，A a1 = a2，我们需要理解的是这实际上复制的是引用，也就是说a1和a2指向的是同一个对象。
 * 因此，当a1变化的时候，a2里面的成员变量也会跟着变化。
 */
class Resume {  
    private String name;  //姓名  
    private String sex;   //性别  
    private int age;      //年龄  
    private String experience; //工作经历  
      
    public Resume(String name, String sex, int age) {  
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
} 

/**
 * 在本程序中，生成了一份zhangsan的简历。之后又复制了一份简历zhangsan1，
 * 可见zhangsan1中工作经历发生变化时，zhangsan的工作经历也发生了变化。
  */
public class 直接赋值 {  
    public static void main(String[] args) {  
        Resume zhangsan = new Resume("zhangsan","男",24);  
        zhangsan.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码复制");  
        zhangsan.displayResume();  
        Resume zhangsan1 = zhangsan;  
        zhangsan1.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等");  
        zhangsan.displayResume();  
        zhangsan1.displayResume();  
    }  
}  