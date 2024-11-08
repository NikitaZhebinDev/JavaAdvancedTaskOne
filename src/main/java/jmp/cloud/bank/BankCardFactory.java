package jmp.cloud.bank;

import jmp.cloud.bank.impl.CreditBankCard;
import jmp.cloud.bank.impl.DebitBankCard;
import jmp.cloud.dto.BankCardType;
import jmp.cloud.dto.User;

import java.util.Map;
import java.util.function.Function;

public class BankCardFactory {

    private static final Map<BankCardType, Function<User, BankCard>> cardCreators = Map.of(
        BankCardType.CREDIT, CreditBankCard::new,
        BankCardType.DEBIT, DebitBankCard::new
    );

    public static BankCard createBankCard(User user, BankCardType cardType) {
        // method references to return the correct card based on BankCardType
        Function<User, BankCard> cardConstructor = switch (cardType) {
            case CREDIT -> CreditBankCard::new;
            case DEBIT -> DebitBankCard::new;
            default -> throw new IllegalArgumentException("Unknown card type: " + cardType);
        };
        return cardConstructor.apply(user);
    }

}
