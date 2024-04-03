package com.finn.blog.id;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class IdGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdGenerationApplication.class,args);
        log.info("Article Application start success.................");

    }


}
