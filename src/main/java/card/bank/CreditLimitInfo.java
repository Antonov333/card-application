package card.bank;

/**
 * Информация о кредитном лимите банковской карты
 */
public class CreditLimitInfo extends CardPropertyInfo<Long> {

    private final long creditLimit;

    CreditLimitInfo(long creditLimit) {
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
