package com.banking.apex_volt_banking_graphql_hibernate.dto;

import java.util.List;

public record CustomerResponse(
        Long id,
        String customerNumber,
        String name,
        String email,
        List<AccountResponse> accounts
) {

}
