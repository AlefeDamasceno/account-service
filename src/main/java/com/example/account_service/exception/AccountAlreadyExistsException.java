package com.example.account_service.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    public AccountAlreadyExistsException() {
        super("Conta já existente.");
    }
}
