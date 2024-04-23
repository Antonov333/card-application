package card.bank;

/**
 * Фабрика экземпляров объектов, используемых в приложении
 */
public class CardAppInstanceFactory {
    public static BalanceInfo getBalanceInfo(Long balanceValue) {
        return new BalanceInfo(balanceValue);
    }
}
