package jmp.cloud.bank.impl;

import jmp.cloud.bank.BankCard;
import jmp.cloud.dto.BankCardType;
import jmp.cloud.dto.User;

public class CreditBankCard extends BankCard {
    public CreditBankCard(User user) {
        super(user);
    }

    @Override
    public BankCardType getCardType() {
        return BankCardType.CREDIT;
    }
}
