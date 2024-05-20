package com.example.demo.controlller;

import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.cfirm.jooq.demo1.model.tables.pojos.Customer;

import java.util.List;
@ComponentScan(basePackages = "com.example.demo.*")
@SpringBootApplication
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        service.insertCustomer(customer);
        return "New customer added";

    }

    @GetMapping
    public List<Customer> getCustomer(){
        return service.getCustomer();

    }
}
