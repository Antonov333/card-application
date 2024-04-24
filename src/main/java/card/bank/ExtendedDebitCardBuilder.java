package card.bank;

public class ExtendedDebitCardBuilder {
    private float bonusRate;
    private float cashBackRate;
    private float savingRate;

    public float getBonusRate() {
        return bonusRate;
    }

    public ExtendedDebitCardBuilder bonusRate(float bonusRate) {
        this.bonusRate = bonusRate;
        return this;
    }

    public ExtendedDebitCardBuilder cashBackRate(float cashBackRate) {
        this.cashBackRate = cashBackRate;
        return this;
    }

    public float getSavingRate() {
        return savingRate;
    }

    public ExtendedDebitCardBuilder savingRate(float savingRate) {
        this.savingRate = savingRate;
        return this;
    }

    public ExtendedDebitCard build() {
        return new ExtendedDebitCard(this);
    }
}
