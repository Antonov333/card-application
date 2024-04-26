package card.bank.cards;

import card.bank.info.*;

import java.util.List;

import static card.bank.cards.CardAppInstanceFactory.*;

/**
 * Премиальная дебетовая карта с бонусом, кэшбеком и накоплением
 */
public class ExtendedDebitCard extends DebitCard {
    /**
     * размер бонуса в процентах
     */
    private final float bonusRate;

    /**
     * бонусные баллы
     */
    private float bonusAmount;

    /**
     * размер кэшбэка процентах
     */
    private final float cashBackRate;

    /**
     * минимальная сумма, на которую начисляется кэшбэк
     */
    private final long minPmtAmountForCashBack;

    /**
     * накопленный кэшбэк
     */
    private float cashBackAmount;

    /**
     * Процент накопления в процентах
     */
    private final float savingRate;

    /**
     * Общая сумма накоплений
     */
    private float savingAmount;

    ExtendedDebitCard(ExtendedDebitCardBuilder builder) {
        bonusRate = builder.getBonusRate();
        bonusAmount = 0;
        cashBackRate = builder.getCashBackRate();
        minPmtAmountForCashBack = builder.getMinPmtAmountForCashBack();
        cashBackAmount = 0;
        savingRate = builder.getSavingRate();
        savingAmount = 0;

    }

    /**
     * При пополнении карты пополняются накопления в соответствии с установленным процентом
     *
     * @param amount сумма пополнения должна быть неотрицательной.
     */
    @Override
    public void topUp(long amount) {
        super.topUp(amount);
        savingAmount += amount * savingRate * oneHundredth;
    }

    /**
     * При совершении покупки увеличиваются бонусные баллы и начисляется кэшбек, если сумма платежа превышает
     * установленный порог
     *
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return true при наличии достаточных средств, при недостатке возвращается false
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

    /**
     * Получаем свойства карты:<br> баланс,<br>
     * размер бонуса и накопленные бонусные баллы,<br>
     * процент кэшбэка и накопленную сумму кэшбэка,<br>
     * процент от суммы пополнений и накопленную сумму накоплений
     *
     * @return список с перечисленными выше свойствами
     */
    @Override
    public List<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo() {

        BonusRateInfo bonusRateInfo = getBonusRateInfo(bonusRate);
        BonusAmountInfo bonusAmountInfo = getBonusAmountInfo(bonusAmount);

        CashBackRateInfo cashBackRateInfo = getCashBackRateInfo(cashBackRate);
        MinPmtAmountForCashBackInfo minPmtAmountForCashBackInfo = MinPmtAmountForCashBackInfo.getInstance(minPmtAmountForCashBack);
        CashBackAmountInfo cashBackAmountInfo = CashBackAmountInfo.getInstance(cashBackAmount);

        SavingRateInfo savingRateInfo = SavingRateInfo.savingRateInfo(savingRate);
        SavingAmountInfo savingAmountInfo = SavingAmountInfo.savingAmountInfo(savingAmount);

        return List.of(balanceInfo(),
                bonusRateInfo, bonusAmountInfo,
                cashBackRateInfo, cashBackAmountInfo, minPmtAmountForCashBackInfo,
                savingRateInfo, savingAmountInfo
        );
    }
}
