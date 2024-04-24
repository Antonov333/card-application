package card.bank;

/**
 * Иноформация о собственных средствах карты
 */
public class OwnFundsInfo extends CardPropertyInfo implements CardPropertyInfoInterface {

    private long amount;

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
     * @return
     */
    @Override
    public long amount() {
        return amount;
    }
}
