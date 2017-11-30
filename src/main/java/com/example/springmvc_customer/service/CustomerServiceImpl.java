package com.example.springmvc_customer.service;

import com.example.springmvc_customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    //DELETE CUSTOMER
    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Map<Integer,Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    //INSERTorUPDATE CUSTOMER
    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null){
            if(customer.getId()==null)
            {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(),customer);

            return customer;
        }else{
            throw new RuntimeException("Customer Can't be nill");
        }
    }

    //READ CUSTOMER (İd ye göre Müşteri yi getirir. Customer tipinde değer döndürür.)
    @Override
    public Customer getCustomerById(Integer id) {

        return customers.get(id);
    }

    //customers arraylistinin(hashmap,arraylist gibi düşünülebilir) içini burada statik olarak kafamıza göre dolduracağız.
    public void loadCustomers(){
        customers=new HashMap<>();

        Customer customer1=new Customer();
        customer1.setId(1);
        customer1.setFirstName("Sezer");
        customer1.setLastName("Kartal");
        customer1.setEmail("asd@asd.com");
        customer1.setPhoneNumber("5555555858");
        customer1.setAddressLineOne("adress 1");
        customer1.setAddressLineTwo("adress 2");
        customer1.setCity("Sivas");
        customer1.setState("Turkish");
        customer1.setZipCode("34906");

        customers.put(1,customer1);

        Customer customer2=new Customer();
        customer2.setId(2);
        customer2.setFirstName("Ahmet");
        customer2.setLastName("Caliskan");
        customer2.setEmail("zxc@zxc.com");
        customer2.setPhoneNumber("5555554242");
        customer2.setAddressLineOne("adress 1");
        customer2.setAddressLineTwo("adress 2");
        customer2.setCity("Konya");
        customer2.setState("Turkish");
        customer2.setZipCode("34906");

        customers.put(2,customer2);

        Customer customer3=new Customer();
        customer3.setId(3);
        customer3.setFirstName("Nazim");
        customer3.setLastName("Emmi");
        customer3.setEmail("qwe@qwe.com");
        customer3.setPhoneNumber("5555552727");
        customer3.setAddressLineOne("adress 1");
        customer3.setAddressLineTwo("adress 2");
        customer3.setCity("Gaziantep");
        customer3.setState("Turkish");
        customer3.setZipCode("34906");

        customers.put(3,customer3);
    }

    @Override
    public List<Customer> listAllCustomers() {

        return new ArrayList<>(customers.values());
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

}
