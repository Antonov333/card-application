import card.bank.cards.ExtendedDebitCard;
import card.bank.cards.ExtendedDebitCardBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtendedDebitCardTest {

    ExtendedDebitCardBuilder builder = new ExtendedDebitCardBuilder();
    ExtendedDebitCard testCard = builder.bonusRate(1.0F).
            cashBackRate(5.0F).
            minPmtAmountForCashBack(5000).
            savingRate(0.005F).build();

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
        assertFalse(testCard.pay(balance + 1));
        long amount = 100;
        testCard.topUp(amount);
        assertTrue(testCard.pay(amount));
        assertEquals(balance, testCard.balanceInfo().amount());
    }

}
