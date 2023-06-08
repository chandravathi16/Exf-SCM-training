package com.ck.scmproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ck.scmproject.config.Consumer;

@SpringBootApplication
public class ScmConsumerApplication {

	public static void main(String[] args) throws Exception {
		
		// create an object for consumer
		Consumer consumer = new Consumer();
		consumer.consumeData();
	}

}
