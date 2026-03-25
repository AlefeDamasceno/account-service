package com.example.account_service.entity;

import com.example.account_service.Enum.AccountStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Account {

    @Id
    private UUID id;

    private String numeroConta;

    private long saldo;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;


    @PrePersist
    public void onCreate(){
        this.id = UUID.randomUUID();
        this.saldo = 0L;
        this.createdAt = LocalDateTime.now();
        this.status = AccountStatus.ATIVO;
    }

    public void sacar(){}

    public void depositar(){}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public long getSaldo() {
        return saldo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
