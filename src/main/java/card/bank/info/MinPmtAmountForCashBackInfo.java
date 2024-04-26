package card.bank.info;

/**
 * Сущность информации о минимальной сумме платежа для начисления кэшбэка
 */
public class MinPmtAmountForCashBackInfo extends CardPropertyInfo<Long> {

    private final long minPmtAmountForCashBack;

    private MinPmtAmountForCashBackInfo(long minPmtAmountForCashBack) {
        this.minPmtAmountForCashBack = minPmtAmountForCashBack;
    }

    public static MinPmtAmountForCashBackInfo getInstance(long minPmtAmountForCashBack) {
        return new MinPmtAmountForCashBackInfo(minPmtAmountForCashBack);
    }

    /**
     * @return имя свойства: "Минимальная сумма платежа для начисления кэшбэка"
     */
    @Override
    public String name() {
        return "Минимальная сумма платежа для начисления кэшбэка";
    }

    /**
     * @return минимальная сумма платежа для начисления кэшбэка
     */
    @Override
    public Long amount() {
        return minPmtAmountForCashBack;
    }
}
