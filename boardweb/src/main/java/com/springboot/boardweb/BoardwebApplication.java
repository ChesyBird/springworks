package com.springboot.boardweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing	// 날짜 자동생성 시 필수
@SpringBootApplication
public class BoardwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardwebApplication.class, args);
	}

}
