package me.seokju.dddstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DddStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DddStudyApplication.class, args);
    }

}
