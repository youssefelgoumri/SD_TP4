package com.example.bankaccountservice;


import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.enums.AccountType;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;



@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Hassan","Imane","Mohamed").forEach(c->{
                Customer customer=Customer.builder()
                        .name(c)
                        .build();
                customerRepository.save(customer);

            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 1; i <10 ; i++) {
                    BankAccount bankaccount= BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(10000+Math.random()*9000000)
                            .createAt(new Date())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankaccount);
                }

            });

        };
    }

}
