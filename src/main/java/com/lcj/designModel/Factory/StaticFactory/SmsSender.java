package com.lcj.designModel.Factory.StaticFactory;

public class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is sms sender!");

	}

}
