package card.bank.cards;

import card.bank.info.BalanceInfo;
import card.bank.info.CardPropertyInfoInterface;

import java.util.List;

public interface BankCardInterface {
    void topUp(long amount);

    boolean pay(long amount);

    BalanceInfo balanceInfo();

    /**
     * Получить информацию о доступных средствах
     */
    List<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo();
}
