package jmp.cloud.dto;

import java.time.LocalDate;

public record Subscription(
    String id,
    String bankCardNumber,
    String subscriptionType,
    LocalDate startDate,
    LocalDate endDate
) { }
