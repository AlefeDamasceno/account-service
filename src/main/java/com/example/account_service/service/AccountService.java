package com.example.account_service.service;

import com.example.account_service.dto.AccountRequest;
import com.example.account_service.dto.AccountResponse;
import com.example.account_service.entity.Account;
import com.example.account_service.exception.AccountAlreadyExistsException;
import com.example.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(AccountRequest request){
        accountRepository.findByNumeroConta(request.numeroConta())
                .ifPresent(account -> {
                    throw new AccountAlreadyExistsException();
                });

        Account account = new Account();

        account.onCreate();
        account.setNumeroConta(request.numeroConta());

        accountRepository.save(account);

        return new AccountResponse(
                account.getId(),
                account.getNumeroConta(),
                account.getSaldo(),
                account.getCreatedAt(),
                account.getStatus()
        );
    }
}
