package com.eddy.rxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eddy.rxm.admin.mapper")
public class RxManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxManagerApplication.class, args);
	}

}
