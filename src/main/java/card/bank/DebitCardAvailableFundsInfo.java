package card.bank;

import java.util.Set;

public class DebitCardAvailableFundsInfo implements AvailableFundsInfoInterface {

    /**
     * Метод возвращает информацию о
     *
     * @param card {@NotNull} банковская карта
     * @return
     */
    @Override
    public Set<CardPropertyInfoInterface> availableFundsInfo(BankCard card) {
        return Set.of(card.balanceInfo());
    }
}
