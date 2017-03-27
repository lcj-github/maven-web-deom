package com.lcj.designModel.Factory.AbstractFactory;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
