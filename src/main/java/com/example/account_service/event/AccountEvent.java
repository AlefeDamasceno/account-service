package com.example.account_service.event;

import java.util.Map;

public record AccountEvent(
        Map<String, Long> contaSaldo
) {}
