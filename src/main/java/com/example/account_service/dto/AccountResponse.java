package com.example.account_service.dto;

import com.example.account_service.Enum.AccountStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AccountResponse(
        UUID id,
        String numeroConta,
        long saldo,
        LocalDateTime createdAt,
        AccountStatus status
) {}
