package card.bank.info;

/**
 * Информация о кредитном лимите банковской карты
 */
public final class CreditLimitInfo extends CardPropertyInfo<Long> {

    private final long creditLimit;

    public CreditLimitInfo(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return имя свойства ("Кредитный лимит")
     */
    @Override
    public String name() {
        return "Кредитный лимит";
    }

    /**
     * @return значение кредитного лимита
     */
    @Override
    public Long amount() {
        return creditLimit;
    }
}
