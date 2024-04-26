package card.bank.info;

/**
 * Иноформация о собственных средствах кредитной карты
 */
public final class OwnFundsInfo extends CardPropertyInfo<Long> {

    private final long amount;

    /**
     * @return строка "Собственные средства"
     */
    @Override
    public String name() {
        return "Собственные средства";
    }

    public OwnFundsInfo(long amount) {
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
