package card.bank;

/**
 * Информация о кредитных средствах карты
 */
public class CreditFundsInfo extends CardPropertyInfo<Long> {

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
     * @return сумма доступных кредитных средств
     */
    @Override
    public Long amount() {
        return creditFunds;
    }
}
