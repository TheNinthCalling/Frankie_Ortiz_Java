package com.company.customerdataservice.repositories;

import com.company.customerdataservice.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepo;


    @BeforeEach
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void addCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setPostalCode("78744");
        customer.setCustomerId(1);

        //Act...
        customer = customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getAllCustomers() {
        //Arrange...

        //Act...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setCustomerId(1);


        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer.setFirstName("Bob");
        customer.setLastName("Marley");
        customer.setPhone("222-333-4567");
        customer.setCompany("Independent");

        customerRepo.save(customer2);

        List<Customer> customerList = customerRepo.findAll();

        //Assert...
        assertEquals(2, customerList.size());
    }

    @Test
    public void updateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
       // customer.setCustomerId(1);


        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void deleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        //customer.setCustomerId(1);


        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getCustomerId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }
    @Test
    public void getCustomerById(){
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
       // customer.setCustomerId(10);

        customerRepo.save(customer);

        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getCustomersByState(){
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setState("Texas");
        customer.setCustomerId(1);


        customerRepo.save(customer);

        List<Customer> customerList = customerRepo.findByState("Texas");

        assertEquals(1, customerList.size());
        //assertEquals(customer1.size(), 1);


    }
}