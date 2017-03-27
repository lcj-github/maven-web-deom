package com.lcj.designModel.Factory.StaticFactory;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is mailsender!");  
	}

}
