package card.bank.info;

/**
 * Информация о балансе
 */
public class BalanceInfo extends CardPropertyInfo<Long> implements CardPropertyInfoInterface<Long> {

    private final long amount;

    public BalanceInfo(long amount) {
        this.amount = amount;
    }

    /**
     * Имя свойства карты: баланс
     *
     * @return строка "Баланс карты"
     */
    @Override
    public String name() {
        return "Баланс карты";
    }

    /**
     * Получить значение баланса карты
     * @return баланс карты
     */
    @Override
    public Long amount() {
        return amount;
    }
}
