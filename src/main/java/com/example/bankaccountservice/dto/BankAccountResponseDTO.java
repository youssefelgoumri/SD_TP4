package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private Date createAt;
    private String currency;
    private AccountType type;

}
