package card.bank;

/**
 * Премиальная дебетовая карта с бонусом, кэшбеком и накоплением
 */
public class ExtendedDebitCard extends DebitCard {
    private float bonusRate;
    private float bonusAmount;

    private float cashBackRate;
    private long minAmountForCashBack;
    private float cashBackAmount;

    private float savingRate;
    private float savingAmount;

    ExtendedDebitCard(ExtendedDebitCardBuilder builder) {

    }

    @Override
    public void topUp(long amount) {
        super.topUp(amount);
        savingAmount += amount * savingRate;
    }

    /**
     * При совершении покупки увеличиваются бонусные баллы и начисляется кэшбек, если сумма платежа превышает
     * установленный порог
     *
     * @param amount сумма платежа, должна быть положительная, иначе выбрасывается исключение
     * @return true при наличии достаточных средств
     */
    @Override
    public boolean pay(long amount) {
        boolean result = super.pay(amount);
        if (result) {
            bonusAmount += amount * bonusRate;
            if (amount > minAmountForCashBack) {
                cashBackAmount += amount * cashBackRate;
            }
        }
        return result;
    }

}
