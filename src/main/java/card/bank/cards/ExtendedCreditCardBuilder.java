package card.bank.cards;

/**
 * Билдер кредитной карты с бонусом, кэшбэком и накоплением
 */
public class ExtendedCreditCardBuilder {

    private long creditLimit;

    private ExtendedDebitCardBuilder debitCardBuilder = new ExtendedDebitCardBuilder();

    public ExtendedCreditCardBuilder creditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
        return this;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public ExtendedCreditCardBuilder bonusRate(float bonusRate) {
        debitCardBuilder.bonusRate(bonusRate);
        return this;
    }

    public float getBonusRate() {
        return debitCardBuilder.getBonusRate();
    }

    public ExtendedCreditCardBuilder cashBackRate(float cashBackRate) {
        debitCardBuilder.cashBackRate(cashBackRate);
        return this;
    }

    public ExtendedCreditCardBuilder minPmtAmountForCashBack(long minPmtAmountForCashBack) {
        debitCardBuilder.minPmtAmountForCashBack(minPmtAmountForCashBack);
        return this;
    }

    public long getMinPmtAmountForCashBack() {
        return debitCardBuilder.getMinPmtAmountForCashBack();
    }

    public ExtendedCreditCard build() {
        return new ExtendedCreditCard(this);
    }


    public float getCashBackRate() {
        return debitCardBuilder.getCashBackRate();
    }

    public float getSavingRate() {
        return debitCardBuilder.getSavingRate();
    }

    public ExtendedCreditCardBuilder savingRate(float savingRate) {
        debitCardBuilder.savingRate(savingRate);
        return this;
    }
}
