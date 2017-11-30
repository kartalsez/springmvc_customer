package com.example.springmvc_customer.controller;

import com.example.springmvc_customer.model.Customer;
import com.example.springmvc_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
       this.customerService=customerService;
   }

   //Müşterileri Listeleme
   @RequestMapping({"/customers","/"})
   public String listCustomers(Model model){

        model.addAttribute("customerList",customerService.listAllCustomers());

        return "customers";
   }

   //Yeni müşteri ekleme(oluşturulan customer objesini customerform.html page ye gönderilir)
    @RequestMapping("/customer/new")
    public String newCustomer (Model model){
       model.addAttribute("customer",new Customer());
       return "customerform";
    }
    //Yeni müşteri ekleme(customerform.html de içi doldurulan customer objesi buraya gelir ve saveOrUpdateCustomer metoduna parametre olarak atanır.)
    @RequestMapping(value="/customers",method= RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customers";
    }

    //Müşteri Güncelleme(Edit linkine tıklanıldığında o kayıta ait id buraya gönderilir. @PathVariable ile yakalanır)
    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id,Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customerform";
    }

    //Müşteri Silme
    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

}
