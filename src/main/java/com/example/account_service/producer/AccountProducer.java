package com.example.account_service.producer;

import com.example.account_service.dto.AccountResponse;
import com.example.account_service.dto.event.AccountEvent;
import com.example.account_service.mapper.AccountMapper;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class AccountProducer {

    private final StreamBridge streamBridge;
    private final AccountMapper accountMapper;

    public AccountProducer(StreamBridge streamBridge, AccountMapper accountMapper) {
        this.streamBridge = streamBridge;
        this.accountMapper = accountMapper;
    }

    public void send(AccountResponse response){
        AccountEvent event = accountMapper.toEvent(response);

        streamBridge.send("account-created", event);
    }
}
