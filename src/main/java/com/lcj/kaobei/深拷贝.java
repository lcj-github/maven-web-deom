package com.lcj.kaobei;
/**
深拷贝，就是说创建一个新对象，然后将当前对象的非静态字段复制到该新对象，
无论该字段是值类型的还是引用类型，都乖乖的进行复制

浅拷贝的死穴就在于原始对象及其副本引用同一个对象，那我们让他们不指向同一个对象不就完了嘛！
 */

class Experience3 {  
    
    private String educationBackground;  
    private String skills;  
      
    public void setExperience(String educationBackground, String skills) {  
        // TODO Auto-generated constructor stub  
        this.educationBackground = educationBackground;  
        this.skills = skills;  
    }  
    public String toString() {  
        return educationBackground + skills;  
    }  
}  
  
/* 建立类，实现Clone方法  */  
class Resume3  implements Cloneable{  
    private String name;  //姓名  
    private String sex;   //性别  
    private int age;      //年龄  
    private Experience3 experience; //工作经历  
      
    public Resume3(String name, String sex, int age) {  
        this.name = name;  
        this.sex = sex;  
        this.age = age;  
        this.experience = new Experience3();  
    }  
      
    public void setAge(int age) {  
        this.age = age;  
    }  
    public int getAge() {  
        return age;  
    }  
      
    public Experience3 getExperience() {  
        return experience;  
    }  
      
    public void setExperience(String educationBackground, String skills) {  
        experience = new Experience3();  //重新new对象
        experience.setExperience(educationBackground, skills);  
    }  
      
    public void displayResume() {  
        System.out.println("姓名："+name+" 性别："+sex+" 年龄:"+age);  
        System.out.println("工作经历："+experience.toString());  
    }  
      
    public Object clone() {  
        try {  
            return (Resume3)super.clone();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}

public class 深拷贝 {
	
	public static void main(String[] args) {  
        Resume3 zhangsan = new Resume3("zhangsan","男",24);  
        zhangsan.setExperience("2009-2013就读于家里蹲大学","精通JAVA,C,C++,C#等代码拷贝和粘贴");  
        zhangsan.displayResume();  
  
        Resume3 zhangsan2 = (Resume3)zhangsan.clone();  
        zhangsan2.setExperience("2009-2013就读于家里蹲大学","精通JAVA,C,C++,C#等");  
        zhangsan2.displayResume();  
        zhangsan.displayResume();  
        zhangsan2.displayResume();  
    } 

}
