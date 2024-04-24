package card.bank;

/**
 * Информация о кредитных средствах карты
 */
public class CreditFundsInfo extends CardPropertyInfo implements CardPropertyInfoInterface {

    private final long creditFunds;

    CreditFundsInfo(long creditFunds) {
        this.creditFunds = creditFunds;
    }

    /**
     * @return имя свойства
     */
    @Override
    public String name() {
        return "Кредитные средства";
    }

    /**
     * @return
     */
    @Override
    public long amount() {
        return creditFunds;
    }
}
