package com.lcj.designModel.Factory.AbstractFactory;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();  
	}

}
