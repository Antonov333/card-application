package card.bank;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Сущность "Банковская карта"
 */
public abstract class BankCard {

    /**
     * Баланс
     */
    private AtomicLong balance;

    /**
     * Геттер баланса карты
     *
     * @return баланс карты
     */
    public final AtomicLong getBalance() {
        return balance;
    }

    /**
     * Пополнить карту
     * @param amount сумма пополнения должна быть неотрицательной.
     * В случае, если в метод будет передано отрицательное значение суммы пополнения,
     * выбрасывается исключение
     */
    public void topUp(long amount) {
        if (amount < 0) {
            throw new RuntimeException("Отрицательная сумма пополнения карты");
        }
        final long l = balance.getAndAdd(amount);
    }

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
    public abstract <T extends AvailableFundsInfoInterface> Set<T> availableFundsInfo();
}
