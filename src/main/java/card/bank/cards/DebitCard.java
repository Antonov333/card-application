package card.bank.cards;

import card.bank.info.BalanceInfo;
import card.bank.info.CardPropertyInfoInterface;

import java.util.List;

public class DebitCard extends BankCard {


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
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return true, если средств достаточно для платежа. При недостатке средств возвращается false
     */
    @Override
    public boolean pay(long amount) {
        if (amount > balanceInfo().amount()) {
            return false;
        }
        return super.pay(amount);
    }

    /**
     * Получить информацию о балансе
     */
    @Override
    public BalanceInfo balanceInfo() {
        return super.balanceInfo();
    }

    /**
     * Получить информацию о доступных средствах
     */
    @Override
    public List<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo() {
        return List.of(super.balanceInfo());
    }
}
