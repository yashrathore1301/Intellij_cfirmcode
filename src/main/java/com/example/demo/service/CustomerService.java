package com.example.demo.service;
import com.cfirm.jooq.demo1.model.Tables;
import com.cfirm.jooq.demo1.model.tables.pojos.Customer;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private DSLContext dslContext;
    public void insertCustomer(Customer customer){
        dslContext.insertInto(Tables.CUSTOMER_, Tables.CUSTOMER_.CUSTOMER_PK, Tables.CUSTOMER_.CUSTOMER_ID, Tables.CUSTOMER_.CUSTOMER_FNAME,
                Tables.CUSTOMER_.CUSTOMER_LNAME, Tables.CUSTOMER_.CUSTOMER_EMAIL).values(customer.getCustomerPk(), customer.getCustomerId(),  customer.getCustomerFname(), customer.getCustomerLname(), customer.getCustomerEmail()).execute();

    }

    public List<Customer> getCustomer(){
            return dslContext.selectFrom(Tables.CUSTOMER_).fetchInto(Customer.class);
        }

}
