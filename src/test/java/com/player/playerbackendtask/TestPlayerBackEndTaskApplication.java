package com.player.playerbackendtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

//@TestConfiguration(proxyBeanMethods = false)
public class TestPlayerBackEndTaskApplication {

    public static void main(String[] args) {
        SpringApplication.from(PlayerBackEndTaskApplication::main).with(TestPlayerBackEndTaskApplication.class).run(args);
    }

}
