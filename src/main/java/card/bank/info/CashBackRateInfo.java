package card.bank.info;

public final class CashBackRateInfo extends CardPropertyInfo<Float> {

    private final float cashBackRate;

    public CashBackRateInfo(float cashBackRate) {
        this.cashBackRate = cashBackRate;
    }

    /**
     * @return имя свойства карты: процент кэшбэка
     */
    @Override
    public String name() {
        return "Процент кэшбэка";
    }

    /**
     * @return процент кэшбэка
     */
    @Override
    public Float amount() {
        return cashBackRate;
    }
}
