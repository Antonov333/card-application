package card.bank;

import card.bank.info.BonusAmountInfo;
import card.bank.info.BonusRateInfo;
import card.bank.info.CashBackRateInfo;

import java.util.List;

import static card.bank.CardAppInstanceFactory.getBonusRateInfo;

/**
 * Премиальная дебетовая карта с бонусом, кэшбеком и накоплением
 */
public class ExtendedDebitCard extends DebitCard {
    /**
     * размер бонуса
     */
    private float bonusRate;

    /**
     * бонусные баллы
     */
    private float bonusAmount;

    /**
     * размер кэшбэка
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
     * Процент накопления
     */
    private float savingRate;

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
        savingAmount += amount * savingRate;
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
            bonusAmount += amount * bonusRate;

            /* Если сумма покупки достаточна, пополняем cashback */
            if (amount > minPmtAmountForCashBack) {
                cashBackAmount += amount * cashBackRate;
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
     * @return список с перечисленными свойствами
     */
    @Override
    public List<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo() {

        BonusRateInfo bonusRateInfo = getBonusRateInfo(bonusRate);
        BonusAmountInfo bonusAmountInfo = CardAppInstanceFactory.getBonusAmount(bonusAmount);

        CashBackRateInfo cashBackRateInfo = CardAppInstanceFactory.getCashBackRateInfo(cashBackRate);

        return List.of(balanceInfo(),
                bonusRateInfo, bonusAmountInfo,
                cashBackRateInfo
                //TODO: доделать остальные свойства карты
        );
    }
}
