package com.ck.scmproject;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ck.scmproject.config.Producer;

@SpringBootApplication
public class ScmProducerApplication {

	public static void main(String[] args) throws Exception {

		Producer producer = new Producer();

		// setup environment variables for host and socket port
		String host = System.getenv("host");
		String port = System.getenv("port");

		// throw the exception if host and port values missed while setting up env variables
		if (host == null || port == null) {
			throw new IllegalArgumentException("Missing host or socket port environment variables");
		}

		int portNum;
		try {
			portNum = Integer.parseInt(port);
		} catch (NumberFormatException e) {
			// throw an exception that if socket port is empty
			throw new IllegalArgumentException("Invalid socket port value");
		}

		producer.produceData(host, portNum);
	

	}
}
