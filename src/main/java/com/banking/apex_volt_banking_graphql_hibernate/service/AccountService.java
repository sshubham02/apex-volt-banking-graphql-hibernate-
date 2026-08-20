package com.banking.apex_volt_banking_graphql_hibernate.service;

import com.banking.apex_volt_banking_graphql_hibernate.dto.AccountResponse;
import com.banking.apex_volt_banking_graphql_hibernate.entity.Account;
import com.banking.apex_volt_banking_graphql_hibernate.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse getAccount(Long id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Account not found: " + id));
        return toAccountResponse(account);
    }

    public List<AccountResponse> getAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(this::toAccountResponse).toList();
    }

    private AccountResponse toAccountResponse(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getAvailableBalance()
        );
    }

}
