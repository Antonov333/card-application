package card.bank;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import static card.bank.CardAppInstanceFactory.getBalanceInfo;

public class DebitCard extends BankCard {

    private AtomicLong ownFunds;

    /**
     * Пополнить карту
     *
     * @param amount сумма пополнения должна быть неотрицательной.
     */
    @Override
    public void topUp(long amount) {
        super.topUp(amount);
    }

    /**
     * Оплатить
     *
     * @param amount Сумма платежа
     */
    @Override
    public boolean pay(long amount) {
        return false;
    }

    /**
     * Получить информацию о балансе
     */
    @Override
    public BalanceInfo balanceInfo() {
        return getBalanceInfo(getBalance().get());
    }

    /**
     * Получить информацию о доступных средствах
     */
    @Override
    public Set<? extends CardPropertyInfoInterface> availableFundsInfo() {
        DebitCardAvailableFundsInfo debitCardAvailableFundsInfo = new DebitCardAvailableFundsInfo();
        Set<BalanceInfo> set = Set.of(getBalanceInfo(balanceInfo().amount()));
        return set;
    }


}
