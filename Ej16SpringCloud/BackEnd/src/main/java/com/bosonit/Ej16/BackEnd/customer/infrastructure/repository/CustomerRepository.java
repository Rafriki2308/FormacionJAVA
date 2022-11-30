package com.bosonit.Ej16.BackEnd.customer.infrastructure.repository;

import com.bosonit.Ej16.BackEnd.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
