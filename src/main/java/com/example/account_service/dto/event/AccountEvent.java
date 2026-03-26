package com.example.account_service.dto.event;

public record AccountEvent(
        String numeroConta,
        long saldo
) {}
