package com.practo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class PractoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractoApplication.class, args);
	}

}
