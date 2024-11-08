package jmp.cloud.bank;

import jmp.cloud.dto.BankCardType;
import jmp.cloud.dto.User;

public abstract class BankCard {
    private final User user;

    public BankCard(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public abstract BankCardType getCardType();
}
