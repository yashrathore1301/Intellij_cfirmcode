package com.example.demo;

import com.example.demo.controlller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.demo.*")
@SpringBootApplication

public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerController.class, args);
    }

}
