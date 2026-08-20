package com.banking.apex_volt_banking_graphql_hibernate.repository;

import com.banking.apex_volt_banking_graphql_hibernate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
