package com.ravilyahya.lombokandslf4j.repository;

import com.ravilyahya.lombokandslf4j.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
