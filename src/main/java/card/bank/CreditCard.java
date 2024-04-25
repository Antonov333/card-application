package card.bank;

import java.util.List;

import static card.bank.CardAppInstanceFactory.*;

/**
 * <b>Сущность "Кредитная карта"</b><br>
 * <b>Собственные средства</b> = MAX(баланс, 0)<br>
 * <b>Кредитная часть средств</b> = MIN(кредитный лимит + баланс, кредитный лимит)
 */
public class CreditCard extends BankCard implements BankCardInterface {

    private long creditLimit;

    // Кредитная часть = MIN(кредитный лимит + баланс, кредитный лимит)
    //
    CreditCard(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * Оплатить
     *
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return true, если достаточно средств для осуществления платежа
     * <br>false, если не хватает средств для выполнения платежа
     */
    @Override
    public boolean pay(long amount) {
        throwIfLesserOrEqualZero(amount, "Отрицательная или нулевая сумма платежа");
        if (amount > balanceInfo().amount() + creditLimit) {
            return false;
        }
        return super.pay(amount);
    }

    private void throwIfLesserOrEqualZero(long amount, String message) {
        if (amount <= 0) {
            throw new RuntimeException(message);
        }
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
        long balance = balanceInfo().amount();
        long ownFunds = Math.max(0, balance);
        long creditFunds = Math.min(creditLimit, creditLimit + balance);

        OwnFundsInfo ownFundsInfo = getOwnFundsInfo(ownFunds);
        CreditFundsInfo creditFundsInfo = getCreditFundsInfo(creditFunds);

        return List.of(balanceInfo(), ownFundsInfo, creditFundsInfo, getCreditLimitInfo(creditLimit));
    }
}
