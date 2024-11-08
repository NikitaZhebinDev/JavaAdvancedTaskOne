package jmp.cloud.bank.impl;

import jmp.cloud.bank.BankCard;
import jmp.cloud.dto.BankCardType;
import jmp.cloud.dto.User;

public class DebitBankCard extends BankCard {
    public DebitBankCard(User user) {
        super(user);
    }

    @Override
    public BankCardType getCardType() {
        return BankCardType.DEBIT;
    }
}
