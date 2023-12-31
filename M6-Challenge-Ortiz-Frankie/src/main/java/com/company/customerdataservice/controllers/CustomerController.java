package com.company.customerdataservice.controllers;

import com.company.customerdataservice.models.Customer;
import com.company.customerdataservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController {

    @Autowired
    CustomerRepository repo;
    //Return all customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {return repo.findAll();}

    //Find a customer record by id.
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnVal = repo.findById(id);
        return returnVal.orElse(null);
    }

    // Find customer records by state.
    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state) {
        return repo.findByState(state);
    }

    // Create a new customer record.
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){
        return repo.save(customer);
    }

    // Update an existing customer record.
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }

    // Delete an existing customer record.
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id){
        repo.deleteById(id);
    }

}
