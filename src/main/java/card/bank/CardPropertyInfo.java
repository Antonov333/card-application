package card.bank;

public abstract class CardPropertyInfo implements CardPropertyInfoInterface {

    /**
     * @return
     */
    @Override
    public String name() {
        return "";
    }

    /**
     * @return
     */
    @Override
    public long amount() {
        return 0;
    }

    @Override
    public String toString() {
        return name() + ": " + amount();
    }
}
