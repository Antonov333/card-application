package card.bank.info;

/**
 * Информация о проценте накопления с пополнений
 */
public class SavingRateInfo extends CardPropertyInfo<Float> {

    private final float savingRate;

    private SavingRateInfo(float savingRate) {
        this.savingRate = savingRate;
    }

    /**
     * Получаем экземпляр информации о проценте накопления с пополнений
     *
     * @param savingRate процент накопления с пополнений
     * @return экземпляр информации о проценте накопления с пополнений
     */
    public static SavingRateInfo savingRateInfo(float savingRate) {
        return new SavingRateInfo(savingRate);
    }

    /**
     * @return имя свойства: "Процент накопления с пополнений"
     */
    @Override
    public String name() {
        return "Процент накопления с пополнений";
    }

    /**
     * @return Процент накопления с пополнений
     */
    @Override
    public Float amount() {
        return savingRate;
    }
}
