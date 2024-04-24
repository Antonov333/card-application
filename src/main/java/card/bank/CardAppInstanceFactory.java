package card.bank;

/**
 * Фабрика экземпляров объектов, используемых в приложении
 */
public class CardAppInstanceFactory {

    static final String debitClassName = DebitCard.class.toString();

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
        bankCard.availableFundsInfo().stream().forEach(c -> System.out.println(c));
        System.out.println();
    }

    public static <B extends BankCardInterface> String getCardCategory(B bankCard) {
        String s = bankCard.getClass().toString();
        if (DebitCard.class.equals(bankCard.getClass())) return "Дебетовая банковская карта";
        if (CreditCard.class.equals(bankCard.getClass())) return "Кредитная банковская карта";
        return "Неизвестная банковская карта";
    }

}

