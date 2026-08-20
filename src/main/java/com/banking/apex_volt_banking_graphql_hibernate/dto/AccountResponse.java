package com.banking.apex_volt_banking_graphql_hibernate.dto;

import java.math.BigDecimal;

public record AccountResponse(
    Long id, String accountNumber, BigDecimal balance, BigDecimal availableBalance) {}
