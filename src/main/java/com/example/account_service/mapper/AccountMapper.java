package com.example.account_service.mapper;

import com.example.account_service.dto.AccountResponse;
import com.example.account_service.dto.event.AccountEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AccountMapper {

    public AccountEvent toEvent(AccountResponse response){
        return new AccountEvent(
                response.numeroConta(),
                response.saldo()
        );
    }
}
