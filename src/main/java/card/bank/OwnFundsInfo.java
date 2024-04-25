package card.bank;

/**
 * Иноформация о собственных средствах карты
 */
public class OwnFundsInfo extends CardPropertyInfo<Long> {

    private final long amount;

    /**
     * @return строка "Собственные средства"
     */
    @Override
    public String name() {
        return "Собственные средства";
    }

    OwnFundsInfo(long amount) {
        this.amount = amount;
    }

    /**
     * @return сумма собственных средств
     */
    @Override
    public Long amount() {
        return amount;
    }
}
