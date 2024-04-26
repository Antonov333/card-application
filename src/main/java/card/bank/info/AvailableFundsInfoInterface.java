package card.bank.info;

import card.bank.cards.BankCard;

import java.util.Set;

/**
 * Интерфейс для создания сущности информации о доступных средствах банковской карты
 */
public interface AvailableFundsInfoInterface {
    Set<? extends CardPropertyInfoInterface<? extends Number>> availableFundsInfo(BankCard card);
}
