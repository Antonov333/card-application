package card.bank;

/**
 * Информация о балансе
 */
public class BalanceInfo extends CardPropertyInfo implements CardPropertyInfoInterface {

    private final long amount;

    BalanceInfo(long amount) {
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
    public long amount() {
        return amount;
    }
}
