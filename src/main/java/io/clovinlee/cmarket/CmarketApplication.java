package io.clovinlee.cmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CmarketApplication {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CmarketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CmarketApplication.class, args);
	}
}
