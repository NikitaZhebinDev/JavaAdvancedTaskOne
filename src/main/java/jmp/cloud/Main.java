package jmp.cloud;

import jmp.cloud.bank.BankCard;
import jmp.cloud.bank.BankCardFactory;
import jmp.cloud.dto.BankCardType;
import jmp.cloud.service.Service;
import jmp.cloud.dto.User;
import jmp.cloud.dto.Subscription;
import jmp.cloud.service.SubscriptionService;
import jmp.cloud.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // getAverageUsersAge example
        Service service = new ServiceImpl();
        System.out.println("Average age of users: " + service.getAverageUsersAge());


        // isPayableUser example
        User user1 = new User("Alice", LocalDate.of(2000, 5, 15));
        User user2 = new User("Bob", LocalDate.of(2010, 3, 22));
        System.out.println("Is Alice a payable user? " + Service.isPayableUser(user1)); // Expected: true
        System.out.println("Is Bob a payable user? " + Service.isPayableUser(user2)); // Expected: false


        // Subscription test
        Subscription subscription = new Subscription(
            "sub123",
            "1234-5678-9876-5432",
            "premium",
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2024, 1, 1)
        );
        System.out.println(subscription);


        // getAllSubscriptionsByCondition example
        Subscription sub1 = new Subscription("sub1", "1234-5678-9876-5432", "premium", LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1));
        Subscription sub2 = new Subscription("sub2", "2345-6789-8765-4321", "basic", LocalDate.of(2022, 5, 1), LocalDate.of(2023, 5, 1));
        Subscription sub3 = new Subscription("sub3", "3456-7890-7654-3210", "premium", LocalDate.of(2021, 6, 15), LocalDate.of(2022, 6, 15));

        // Create a list of subscriptions
        List<Subscription> subscriptions = List.of(sub1, sub2, sub3);

        // Create an instance of SubscriptionService
        SubscriptionService subscriptionService = new SubscriptionService(subscriptions);

        // Example 1: Get all subscriptions with 'premium' type
        Predicate<Subscription> isPremium = sub -> "premium".equals(sub.subscriptionType());
        List<Subscription> premiumSubscriptions = subscriptionService.getAllSubscriptionsByCondition(isPremium);
        System.out.println("Premium Subscriptions: " + premiumSubscriptions);

        // Example 2: Get all subscriptions where the endDate is after a specific date
        Predicate<Subscription> isActive = sub -> sub.endDate().isAfter(LocalDate.of(2023, 1, 1));
        List<Subscription> activeSubscriptions = subscriptionService.getAllSubscriptionsByCondition(isActive);
        System.out.println("Active Subscriptions: " + activeSubscriptions);

        // createBankCard example
        User user = new User("John Doe", LocalDate.of(1990, 5, 15));

        BankCardFactory factory = new BankCardFactory();

        BankCard creditCard = factory.createBankCard(user, BankCardType.CREDIT);
        System.out.println("Created a CreditBankCard for " + user);

        BankCard debitCard = factory.createBankCard(user, BankCardType.DEBIT);
        System.out.println("Created a DebitBankCard for " + user);
    }
}