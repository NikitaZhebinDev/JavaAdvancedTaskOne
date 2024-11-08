package jmp.cloud.service.impl;

import jmp.cloud.dto.User;
import jmp.cloud.bank.BankCard;
import jmp.cloud.bank.BankCardFactory;
import jmp.cloud.dto.BankCardType;
import jmp.cloud.service.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceImpl implements Service {

    public Optional<BankCard> createUserBankCard(User user, BankCardType cardType) {
        var bankCard = Optional.ofNullable(BankCardFactory.createBankCard(user, cardType));
        return bankCard;
    }

    public void printBankCardDetails(BankCard card) {
        var user = card.getUser();
        System.out.println("Card Type: " + card.getCardType());
        System.out.println("User: " + user.name() + ", birth date: " + user.birthDate());
    }

    @Override
    public List<User> getUsers() {
        // Example users list
        return List.of(
            new User("Alice", LocalDate.of(1990, 5, 15)),
            new User("Bob", LocalDate.of(1985, 3, 22)),
            new User("Charlie", LocalDate.of(2000, 12, 10))
        );
    }

    /**
     * Method to get all users who are over 18 years old
     * */
    public List<User> getUsersOver18() {
        return getAllUsers().stream()
            .filter(Service::isPayableUser)
            .collect(Collectors.toUnmodifiableList()); // Collect into an unmodifiable list
    }
}
