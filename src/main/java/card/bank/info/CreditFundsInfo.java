package card.bank.info;

/**
 * Информация о кредитных средствах карты
 */
public final class CreditFundsInfo extends CardPropertyInfo<Long> {

    private final long creditFunds;

    public CreditFundsInfo(long creditFunds) {
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
