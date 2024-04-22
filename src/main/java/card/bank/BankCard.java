package card.bank;

/**
 * Сущность "Банковская карта"
 */
public abstract class BankCard {

    /**
     * Баланс
     */
    private long balance;

    /**
     * Пополнить счет
     */
    public abstract void topUp(long amount);

    /**
     * Оплатить
     */
    public abstract boolean pay(long amount);

    /**
     * Получить информацию о балансе
     */
    public abstract BalanceInfo balanceInfo();

    /**
     * Получить информацию о доступных средствах
     */
    public abstract AvailableFundsInfo availableFundsInfo();


}
