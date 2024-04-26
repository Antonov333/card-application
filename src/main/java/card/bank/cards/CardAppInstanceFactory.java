package card.bank.cards;

import card.bank.info.*;

/**
 * Фабрика экземпляров объектов, используемых в приложении
 */
public class CardAppInstanceFactory {

    public static final float oneHundredth = 0.01f;

    public static BalanceInfo getBalanceInfo(Long balanceValue) {
        return new BalanceInfo(balanceValue);
    }

    /**
     * @param ownFundsAmount количество собственных средств
     * @return экземпляр информации о собственных средствах в соответствии с полученным значением количества собственных
     */
    public static OwnFundsInfo getOwnFundsInfo(long ownFundsAmount) {
        return new OwnFundsInfo(ownFundsAmount);

    }

    public static CreditLimitInfo getCreditLimitInfo(long creditLimit) {
        return new CreditLimitInfo(creditLimit);
    }

    public static CreditFundsInfo getCreditFundsInfo(long creditFunds) {
        return new CreditFundsInfo(creditFunds);
    }

    public static <B extends BankCardInterface> void printCardProperties(B bankCard) {
        System.out.println(getCardCategory(bankCard));
        bankCard.availableFundsInfo().forEach(System.out::println);
        System.out.println();
    }

    /**
     * Получаем название банковской карты в зависимости от класса
     *
     * @param bankCard сущность банковской карты
     * @param <B>      тип, реализующий интерфейс {@link BankCardInterface}
     * @return название банковской карты
     */
    public static <B extends BankCardInterface> String getCardCategory(B bankCard) {

        Class<? extends BankCardInterface> cardClass = bankCard.getClass();
        if (DebitCard.class.equals(bankCard.getClass())) return "Дебетовая банковская карта";
        if (CreditCard.class.equals(bankCard.getClass())) return "Кредитная банковская карта";
        if (ExtendedDebitCard.class.equals(bankCard.getClass()))
            return "Дебетовая банковская карта с бонусом, кэшбеком и накоплением";
        if (ExtendedCreditCard.class.equals(cardClass)) {
            return "Кредитная банковская карта с бонусом, кэшбеком и накоплением";
        }
        return "Неизвестная банковская карта";
    }

    public static BonusRateInfo getBonusRateInfo(float bonusRate) {
        return new BonusRateInfo(bonusRate);
    }

    public static BonusAmountInfo getBonusAmountInfo(float bonusAmount) {
        return new BonusAmountInfo(bonusAmount);
    }

    /**
     * @param cashBackRate сумма накопленного кэшбэка
     * @return экземпляр сущности информации о размере кэшбэка
     */
    public static CashBackRateInfo getCashBackRateInfo(float cashBackRate) {
        return new CashBackRateInfo(cashBackRate);
    }

    /**
     * @param minPmtAmountForCashBack минимальная сумма платежа для начисления кэшбэка
     * @return экземпляр сущности информации о минимальной сумме платежа для начисления кэшбэка
     */
    public static MinPmtAmountForCashBackInfo getMinPmtAmountForCashBackInfo(long minPmtAmountForCashBack) {
        return MinPmtAmountForCashBackInfo.getInstance(minPmtAmountForCashBack);
    }

}

