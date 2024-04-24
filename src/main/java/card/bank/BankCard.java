package card.bank;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Сущность "Банковская карта"
 */
public abstract class BankCard implements BankCardInterface {

    /**
     * Баланс
     */
    private AtomicLong balance = new AtomicLong(0);

    /**
     * Пополнить карту
     * @param amount сумма пополнения должна быть неотрицательной.
     * В случае, если в метод будет передано отрицательное значение суммы пополнения,
     * выбрасывается исключение
     */
    @Override
    public void topUp(long amount) {
        if (amount <= 0) {
            throw new RuntimeException("Отрицательная или нулевая сумма пополнения карты");
        }
        balance.getAndAdd(amount);
    }

    /**
     * Оплатить
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return всегда true, сумма платежа списывается с карты, даже если баланс отрицательный
     */
    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            throw new RuntimeException("Отрицательная или нулевая сумма платежа");
        }
        balance.addAndGet(-amount);
        return true;
    }

    /**
     * Получить информацию о балансе
     */
    @Override
    public BalanceInfo balanceInfo() {
        return CardAppInstanceFactory.getBalanceInfo(balance.get());
    }

}
