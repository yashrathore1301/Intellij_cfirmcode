package com.example.demo.service;
import com.cfirm.jooq.demo1.model.Tables;
import com.cfirm.jooq.demo1.model.tables.pojos.Customer;
import com.example.demo.repository.CustomerRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.List;
//@ComponentScan(basePackages = "com.example.demo.*")
//@SpringBootApplication
@RestController
@RequestMapping("/customer")
@Service
public class CustomerService {

    @Autowired
    private DSLContext dslContext;
    private CustomerRepository customerRepository= new CustomerRepository();
    public void insertCustomer(Customer customer){
        customerRepository.createCustomer(customer, dslContext);
    }

    public List<Customer> getCustomer(){
        return customerRepository.getCustomer(dslContext);
    }
/*/
    @Autowired
    private DSLContext dslContext;
    public void insertCustomer(Customer customer){
        dslContext.insertInto(Tables.CUSTOMER_, Tables.CUSTOMER_.CUSTOMER_PK, Tables.CUSTOMER_.CUSTOMER_ID, Tables.CUSTOMER_.CUSTOMER_FNAME,
                Tables.CUSTOMER_.CUSTOMER_LNAME, Tables.CUSTOMER_.CUSTOMER_EMAIL).values(customer.getCustomerPk(), customer.getCustomerId(),  customer.getCustomerFname(), customer.getCustomerLname(), customer.getCustomerEmail()).execute();

    }

    public List<Customer> getCustomer(){
            return dslContext.selectFrom(Tables.CUSTOMER_).fetchInto(Customer.class);
        }
*/
}
