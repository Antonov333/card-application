package card.bank.info;

/**
 * Интерфейс для создания сущности информации о свойстве банковской карты
 */
public interface CardPropertyInfoInterface<N extends Number> {
    String name();

    N amount();

}
