package card.bank.info;

/**
 * Информация о размере бонуса, начисляемого на сумму покупки
 */
public final class BonusRateInfo extends CardPropertyInfo<Float> {

    private final float bonusRate;

    public BonusRateInfo(float bonusRate) {
        this.bonusRate = bonusRate;
    }


    /**
     * @return имя свойства: размер бонуса
     */
    @Override
    public String name() {
        return "Размер бонуса (%)";
    }

    /**
     * @return размер бонуса
     */
    @Override
    public Float amount() {
        return bonusRate;
    }

}
