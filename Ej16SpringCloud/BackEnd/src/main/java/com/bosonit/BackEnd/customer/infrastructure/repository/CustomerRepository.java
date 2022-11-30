package com.bosonit.BackEnd.customer.infrastructure.repository;

import com.bosonit.BackEnd.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
