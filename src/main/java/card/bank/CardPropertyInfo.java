package card.bank;

/**
 * Информация о свойстве банковской карты
 */
public abstract class CardPropertyInfo<N extends Number> implements CardPropertyInfoInterface<N> {

    /**
     * @return имя свойства
     */
    @Override
    public abstract String name();

    /**
     * @return количество свойства
     */
    @Override
    public abstract N amount();

    @Override
    public String toString() {
        return name() + ": " + amount();
    }
}
