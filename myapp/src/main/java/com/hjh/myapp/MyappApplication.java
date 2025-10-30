package com.hjh.myapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hjh")
public class MyappApplication {

    public static void main(String[] args) {
        // .env 파일 로드 (커스텀 Dotenv API 사용)
    	Dotenv dotenv = Dotenv.load(); // dotenv-java 라이브러리 필요

        // 환경변수 설정 (Spring에서 참조 가능하도록)
        System.setProperty("DB_DRIVER", dotenv.get("DB_DRIVER"));
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        
        SpringApplication.run(MyappApplication.class, args);
    }

}