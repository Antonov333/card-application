package card.bank;

/**
 * Информация о балансе
 */
public class BalanceInfo implements CardPropertyInfoInterface {

    private final long amount;

    BalanceInfo(long amount) {
        this.amount = amount;
    }

    /**
     * Имя свойства карты: баланс
     *
     * @return
     */
    @Override
    public String name() {
        return "Баланс карты";
    }

    /**
     *
     * @return баланс карты
     */
    @Override
    public long amount() {
        return amount;
    }
}
