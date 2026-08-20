package com.banking.apex_volt_banking_graphql_hibernate.service;

import com.banking.apex_volt_banking_graphql_hibernate.dto.AccountResponse;
import com.banking.apex_volt_banking_graphql_hibernate.dto.CustomerResponse;
import com.banking.apex_volt_banking_graphql_hibernate.entity.Account;
import com.banking.apex_volt_banking_graphql_hibernate.entity.Customer;
import com.banking.apex_volt_banking_graphql_hibernate.repository.CustomerRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerResponse getCustomer(Long id) {
    Customer customer =
        customerRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    return toResponse(customer);
  }

  private CustomerResponse toResponse(Customer customer) {
    List<AccountResponse> accounts =
        customer.getAccounts().stream().map(this::toAccountResponse).toList();

    return new CustomerResponse(
        customer.getId(),
        customer.getCustomerNumber(),
        customer.getFirstName() + " " + customer.getLastName(),
        customer.getEmail(),
        accounts);
  }

  private AccountResponse toAccountResponse(Account account) {
    return new AccountResponse(
        account.getId(),
        account.getAccountNumber(),
        account.getBalance(),
        account.getAvailableBalance());
  }

  public List<CustomerResponse> getCustomers() {
    List<Customer> customerList = customerRepository.findAll();
    return customerList.stream().map(this::toResponse).toList();
  }
}
