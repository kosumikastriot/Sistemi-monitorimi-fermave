package com.ubt.sistemimonitorimitfermave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SistemiMonitorimitFermaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemiMonitorimitFermaveApplication.class, args);
    }

}
