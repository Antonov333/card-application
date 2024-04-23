package card.bank;

import java.util.Set;

/**
 * Интерфейс для создания сущности информации о доступных средствах банковской карты
 */
public interface AvailableFundsInfoInterface {
    Set<? extends CardPropertyInfoInterface> availableFundsInfo(BankCard card);
}
