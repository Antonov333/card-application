package card.bank.info;

public class SavingAmountInfo extends CardPropertyInfo<Float> {

    /**
     * Сумма накоплений с пополнений
     */
    private final float savingAmount;

    private SavingAmountInfo(float savingAmount) {
        this.savingAmount = savingAmount;
    }

    /**
     * Получение экземпляра информации о сумме накоплений с пополнений
     *
     * @param savingAmount Cумма накоплений с пополнений
     * @return Информация о сумме накоплений с пополнений
     */
    public static SavingAmountInfo savingAmountInfo(float savingAmount) {
        return new SavingAmountInfo(savingAmount);
    }

    /**
     * @return имя свойства: "Сумма накоплений с пополнений"
     */
    @Override
    public String name() {
        return "Сумма накоплений с пополнений";
    }

    /**
     * @return Cумма накоплений с пополнений
     */
    @Override
    public Float amount() {
        return savingAmount;
    }
}
