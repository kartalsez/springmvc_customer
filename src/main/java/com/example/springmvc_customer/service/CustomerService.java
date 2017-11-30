package com.example.springmvc_customer.service;



import com.example.springmvc_customer.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer saveOrUpdateCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    void deleteCustomer(Integer id);
}
