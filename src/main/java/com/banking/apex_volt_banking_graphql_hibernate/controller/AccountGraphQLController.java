package com.banking.apex_volt_banking_graphql_hibernate.controller;

import com.banking.apex_volt_banking_graphql_hibernate.dto.AccountResponse;
import com.banking.apex_volt_banking_graphql_hibernate.service.AccountService;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AccountGraphQLController {
  private final AccountService accountService;

  public AccountGraphQLController(AccountService accountService) {
    this.accountService = accountService;
  }

  @QueryMapping
  public AccountResponse account(@Argument Long id) {
    return accountService.getAccount(id);
  }

  @QueryMapping
  public List<AccountResponse> accounts() {
    return accountService.getAccounts();
  }
}
