package card.bank.info;

public final class BonusAmountInfo extends CardPropertyInfo<Float> {

    private final float bonusAmount;

    public BonusAmountInfo(float bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    /**
     * @return имя свойства
     */
    @Override
    public String name() {
        return "Бонусные баллы";
    }

    /**
     * @return бонусные баллы
     */
    @Override
    public Float amount() {
        return bonusAmount;
    }
}
