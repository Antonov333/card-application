import card.bank.cards.ExtendedCreditCard;
import card.bank.cards.ExtendedCreditCardBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtendedCreditCardTest {

    ExtendedCreditCardBuilder extendedCreditCardBuilder = new ExtendedCreditCardBuilder();
    ExtendedCreditCard testCard = extendedCreditCardBuilder.
            creditLimit(20000).
            bonusRate(1f).
            cashBackRate(5f).minPmtAmountForCashBack(5000).
            savingRate(0.005f).
            build();

    @Test
    public void topUpThrowsTest() {
        assertThrows(RuntimeException.class, () -> testCard.topUp(-1000));
    }

    @Test
    public void topUpTest() {
        long balance = testCard.balanceInfo().amount();
        long delta = 1000;
        testCard.topUp(delta);
        assertEquals(balance + delta, testCard.balanceInfo().amount());
    }

    @Test
    public void payThrows() {
        assertThrows(RuntimeException.class, () -> testCard.pay(-1));
    }

    @Test
    public void payTest() {
        long balance = testCard.balanceInfo().amount();
        long amount = 100;
        testCard.topUp(amount);
        assertTrue(testCard.pay(amount));
        assertEquals(balance, testCard.balanceInfo().amount());
    }

}
