package com.lcj.designModel.Observer.push;

/**
 在运行时，这个客户端首先创建了具体主题类的实例，以及一个观察者对象。
 然后，它调用主题对象的attach()方法，将这个观察者对象向主题对象登记，也就是将它加入到主题对象的聚集中去。
这时，客户端调用主题的change()方法，改变了主题对象的内部状态。主题对象在状态发生变化时，调用超类的notifyObservers()方法，通知所有登记过的观察者对象。
 *
 */

//推模型是假定主题对象知道观察者需要的数据；而拉模型是主题对象不知道观察者具体需要什么数据，没有办法的情况下，干脆把自身传递给观察者，让观察者自己去按需要取值
public class Client {
	
	public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        //改变主题对象的状态
        subject.change("new state");
    }

}
