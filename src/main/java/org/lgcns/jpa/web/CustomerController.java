package org.lgcns.jpa.web;

import org.lgcns.jpa.model.Customer;
import org.lgcns.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Customer getCustomer() {
        return customerService.getCustomer(1L);
    }

//    @GetMapping("/{id}")
//    public Optional<Customer> getCustomerById(@PathVariable Long id) {
//        return customerService.findCustomerById(id);
//    }
//
    @PostMapping(value = "/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Long id) {
//        customerService.deleteCustomer(id);
//    }
}
