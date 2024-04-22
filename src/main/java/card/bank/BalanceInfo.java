package card.bank;

/**
 * Информация о балансе
 */
public class BalanceInfo implements CardPropertyInfo {

    private long amount;

    BalanceInfo(long amount) {
        this.amount = amount;
    }

    @Override
    public String name() {
        return "Balance";
    }

    @Override
    public long amount() {
        return amount;
    }
}
