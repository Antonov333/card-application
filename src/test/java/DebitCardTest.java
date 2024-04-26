import card.bank.cards.DebitCard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class DebitCardTest {

    DebitCard testDebitCard = new DebitCard();

    @Test
    public void topUpThrowsTest() {
        assertThrows(RuntimeException.class, () -> testDebitCard.topUp(-1000));
    }

    @Test
    public void topUpTest() {
        long balance = testDebitCard.balanceInfo().amount();
        long delta = 1000;
        testDebitCard.topUp(delta);
        assertEquals(balance + delta, testDebitCard.balanceInfo().amount());
    }

    @Test
    public void payThrows() {
        assertThrows(RuntimeException.class, () -> testDebitCard.pay(-1));
    }

    @Test
    public void payTest() {
        long balance = testDebitCard.balanceInfo().amount();
        assertFalse(testDebitCard.pay(balance + 1));
        long amount = 100;
        testDebitCard.topUp(amount);
        assertTrue(testDebitCard.pay(amount));
        assertEquals(balance, testDebitCard.balanceInfo().amount());
    }
}
