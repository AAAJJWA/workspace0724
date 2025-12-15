package com.kh.yugioh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kh.yugioh.mapper")
public class YugiohApplication {

	public static void main(String[] args) {
		SpringApplication.run(YugiohApplication.class, args);
	}

}
