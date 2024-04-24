package card.bank;

import java.util.List;

public interface BankCardInterface {
    void topUp(long amount);

    boolean pay(long amount);

    BalanceInfo balanceInfo();

    /**
     * Получить информацию о доступных средствах
     */
    List<? extends CardPropertyInfoInterface> availableFundsInfo();
}
