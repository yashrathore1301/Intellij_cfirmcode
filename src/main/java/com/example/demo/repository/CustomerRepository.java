package com.example.demo.repository;

import com.cfirm.jooq.demo1.model.Tables;
import com.cfirm.jooq.demo1.model.tables.pojos.Customer;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    public void createCustomer(Customer customer,DSLContext dslContext){
        dslContext.insertInto(Tables.CUSTOMER_, Tables.CUSTOMER_.CUSTOMER_PK, Tables.CUSTOMER_.CUSTOMER_ID, Tables.CUSTOMER_.CUSTOMER_FNAME,
               Tables.CUSTOMER_.CUSTOMER_LNAME, Tables.CUSTOMER_.CUSTOMER_EMAIL).values(customer.getCustomerPk(), customer.getCustomerId(),
                customer.getCustomerFname(), customer.getCustomerLname(), customer.getCustomerEmail()).execute();
    }

    public List<Customer> getCustomer(DSLContext dslContext){
        return dslContext.selectFrom(Tables.CUSTOMER_).fetchInto(Customer.class);
    }

}
