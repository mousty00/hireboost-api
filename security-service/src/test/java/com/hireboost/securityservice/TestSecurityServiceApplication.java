package com.hireboost.securityservice;

import org.springframework.boot.SpringApplication;

public class TestSecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(SecurityServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
