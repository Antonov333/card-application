package card.bank;

import java.util.Set;

/**
 * Интерфейс для создания сущности информации о доступных средствах банковской карты
 */
public interface AvailableFundsInfo {
    Set<CardPropertyInfo> availableFunds();
}
