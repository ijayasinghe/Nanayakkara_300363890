package org.example.practice_1.repositories;

import org.example.practice_1.entities.Customer;
import org.example.practice_1.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerById(long kw);
}
