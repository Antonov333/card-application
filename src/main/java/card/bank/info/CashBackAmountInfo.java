package card.bank.info;

/**
 * Информация о накопленном кэшбэке
 */
public final class CashBackAmountInfo extends CardPropertyInfo<Float>
//        implements CardPropertyInfoInterface<Float>
{


    final float cashBackAmount;

    private CashBackAmountInfo(float cashBackAmount) {
        this.cashBackAmount = cashBackAmount;
    }

    /**
     * @param cashBackAmount сумма накопленного кэшбэка
     * @return экземпляр сущности информации о сумме накопленного кэшбэка
     */
    public static CashBackAmountInfo getInstance(float cashBackAmount) {
        return new CashBackAmountInfo(cashBackAmount);
    }

    /**
     * @return название свойства: "Накопленная сумма кэшбэка"
     */
    @Override
    public String name() {
        return "Накопленная сумма кэшбэка";
    }

    /**
     * @return Накопленная сумма кэшбэка
     */
    @Override
    public Float amount() {
        return cashBackAmount;
    }
}
