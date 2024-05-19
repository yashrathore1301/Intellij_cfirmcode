package com.example.demo;

import com.cfirm.jooq.demo1.model.tables.pojos.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ComponentScan(basePackages = "com.example.demo.*")
@SpringBootApplication
@RestController
@RequestMapping("/customer")

public class Demo1Application {

    @Autowired
    private CustomerService service;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        service.insertCustomer(customer);
        return "customer added";

    }

    @GetMapping
    public List<Customer> getCustomer(){
        return service.getCustomer();

    }


    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}
