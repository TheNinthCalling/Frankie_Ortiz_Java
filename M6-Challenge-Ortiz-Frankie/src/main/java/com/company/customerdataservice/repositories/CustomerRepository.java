package com.company.customerdataservice.repositories;

import com.company.customerdataservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // filter customers by state.
    List<Customer> findByState(String state);

    // find a specific customer by id.

    // delete customers.

    // edit customers.

    // add new customers.
}
