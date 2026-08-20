package com.banking.apex_volt_banking_graphql_hibernate.controller;

import com.banking.apex_volt_banking_graphql_hibernate.dto.CustomerResponse;
import com.banking.apex_volt_banking_graphql_hibernate.service.CustomerService;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerGraphQLController {

  private final CustomerService customerService;

  public CustomerGraphQLController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @QueryMapping
  public CustomerResponse customer(@Argument Long id) {
    return customerService.getCustomer(id);
  }

  @QueryMapping
  public List<CustomerResponse> getCustomers() {
    return customerService.getCustomers();
  }
}
