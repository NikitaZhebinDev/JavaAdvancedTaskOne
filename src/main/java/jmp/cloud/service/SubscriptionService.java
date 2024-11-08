package jmp.cloud.service;

import jmp.cloud.dto.Subscription;
import jmp.cloud.exception.SubscriptionNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubscriptionService {

    private List<Subscription> subscriptions;

    public SubscriptionService(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Subscription getSubscriptionByBankCardNumber(String bankCardNumber) {
        Optional<Subscription> subscription = findSubscriptionByBankCardNumber(bankCardNumber);

        // orElseThrow usage - throw SubscriptionNotFoundException if the subscription is not present
        return subscription.orElseThrow(() ->
            new SubscriptionNotFoundException("Subscription not found for bank card number: " + bankCardNumber)
        );
    }

    private Optional<Subscription> findSubscriptionByBankCardNumber(String bankCardNumber) {
        // (for example purposes - returns empty)
        return Optional.empty();
    }

    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return subscriptions.stream()
            .filter(condition)
            .collect(Collectors.toList());
    }
}
