package card.bank.cards;

import card.bank.info.*;

import java.util.List;

import static card.bank.cards.CardAppInstanceFactory.*;

/**
 * Кредитная карта с бонусом на сумму покупок, кэшбэком и накоплением с пополнений
 */
public class ExtendedCreditCard extends CreditCard {

    ExtendedCreditCard(long creditLimit) {
        super(creditLimit);
    }

    /**
     * размер бонуса в процентах
     */
    private float bonusRate;

    /**
     * бонусные баллы
     */
    private float bonusAmount;

    /**
     * размер кэшбэка процентах
     */
    private float cashBackRate;

    /**
     * минимальная сумма, на которую начисляется кэшбэк
     */
    private long minPmtAmountForCashBack;

    /**
     * накопленный кэшбэк
     */
    private float cashBackAmount;

    /**
     * Процент накопления в процентах
     */
    private float savingRate;

    /**
     * Общая сумма накоплений
     */
    private float savingAmount;

    ExtendedCreditCard(ExtendedCreditCardBuilder builder) {

        super(builder.getCreditLimit());

        bonusRate = builder.getBonusRate();
        bonusAmount = 0;

        cashBackRate = builder.getCashBackRate();
        minPmtAmountForCashBack = builder.getMinPmtAmountForCashBack();
        cashBackAmount = 0;

        savingRate = builder.getSavingRate();
        savingAmount = 0;

    }

    /**
     * Получаем свойства карты:<br> баланс,<br>
     * кредитный лимит,<br>
     * размер бонуса и накопленные бонусные баллы,<br>
     * процент кэшбэка и накопленную сумму кэшбэка,<br>
     * процент от суммы пополнений и накопленную сумму накоплений
     *
     * @return список с перечисленными выше свойствами
     */
    @Override
    public List<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo() {

        BalanceInfo balanceInfo = getBalanceInfo(balanceInfo().amount());

        CreditLimitInfo creditLimitInfo = getCreditLimitInfo(getCreditLimit());
        CreditFundsInfo creditFundsInfo = getCreditFundsInfo(getCreditFunds());

        BonusRateInfo bonusRateInfo = getBonusRateInfo(bonusRate);
        BonusAmountInfo bonusAmountInfo = CardAppInstanceFactory.getBonusAmountInfo(bonusAmount);

        CashBackRateInfo cashBackRateInfo = getCashBackRateInfo(cashBackRate);
        MinPmtAmountForCashBackInfo minPmtAmountForCashBackInfo = getMinPmtAmountForCashBackInfo(minPmtAmountForCashBack);
        CashBackAmountInfo cashBackAmountInfo = CashBackAmountInfo.getInstance(cashBackAmount);

        SavingRateInfo savingRateInfo = SavingRateInfo.savingRateInfo(savingRate);
        SavingAmountInfo savingAmountInfo = SavingAmountInfo.savingAmountInfo(savingAmount);

        return List.of(
                balanceInfo,

                creditFundsInfo,
                creditLimitInfo,

                bonusRateInfo, bonusAmountInfo,
                cashBackRateInfo, minPmtAmountForCashBackInfo, cashBackAmountInfo,
                savingRateInfo, savingAmountInfo
        );
    }

    /**
     * <b>Пополнение карты</b><br>
     * В соответствии с заданным процентом начисляются накопления
     *
     * @param amount сумма пополнения должна быть неотрицательной.
     *               В случае, если в метод будет передано отрицательное значение суммы пополнения,
     *               выбрасывается исключение
     */
    @Override
    public void topUp(long amount) {
        super.topUp(amount);
        savingAmount += amount * savingRate * oneHundredth;
    }

    /**
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return
     */
    @Override
    public boolean pay(long amount) {
        boolean result = super.pay(amount);
        if (result) {
            /* Рассчитываем бонус      */
            bonusAmount += amount * bonusRate * oneHundredth;

            /* Если сумма покупки достаточна, пополняем cashback */
            if (amount > minPmtAmountForCashBack) {
                cashBackAmount += amount * cashBackRate * oneHundredth;
            }
        }
        return result;
    }
}
