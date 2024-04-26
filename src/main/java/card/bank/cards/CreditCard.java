package card.bank.cards;

import card.bank.info.BalanceInfo;
import card.bank.info.CardPropertyInfoInterface;
import card.bank.info.CreditFundsInfo;
import card.bank.info.OwnFundsInfo;

import java.util.List;

import static card.bank.cards.CardAppInstanceFactory.*;

/**
 * <b>Сущность "Кредитная карта"</b><br>
 * <b>Собственные средства</b> = MAX(баланс, 0)<br>
 * <b>Кредитная часть средств</b> = MIN(кредитный лимит + баланс, кредитный лимит)
 */
public class CreditCard extends BankCard implements BankCardInterface {

    private long creditLimit;

    CreditCard(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    CreditCard() {
    }

    public static CreditCard creditCard(long creditLimit) {
        return new CreditCard(creditLimit);
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
        OwnFundsInfo ownFundsInfo = getOwnFundsInfo(getOwnFunds());
        CreditFundsInfo creditFundsInfo = getCreditFundsInfo(getCreditFunds());

        return List.of(balanceInfo(),
                getOwnFundsInfo(getOwnFunds()),
                getCreditFundsInfo(getCreditFunds()),
                getCreditLimitInfo(creditLimit));
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public long getCreditFunds() {
        return Math.min(creditLimit, creditLimit + balanceInfo().amount());
    }

    public long getOwnFunds() {
        return Math.max(0, balanceInfo().amount());
    }

}
