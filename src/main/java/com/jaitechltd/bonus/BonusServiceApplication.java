package com.jaitechltd.bonus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BonusServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonusServiceApplication.class, args);
        log.info("Bonus service started ...");
    }
}
