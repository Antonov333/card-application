import card.bank.cards.CreditCard;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    private final static long creditLimit = 10000;
    CreditCard testCreditCard = CreditCard.creditCard(creditLimit);

    @Test
    public void topUpThrowsTest() {
        assertThrows(RuntimeException.class, () -> testCreditCard.topUp(-1000));
    }

    @Test
    public void topUpTest() {
        long balance = testCreditCard.balanceInfo().amount();
        long delta = 1000;
        testCreditCard.topUp(delta);
        assertEquals(balance + delta, testCreditCard.balanceInfo().amount());
    }

    @Test
    public void payThrows() {
        assertThrows(RuntimeException.class, () -> testCreditCard.pay(-1));
    }

    @Test
    public void payTest() {
        long balance = testCreditCard.balanceInfo().amount();
        assertFalse(testCreditCard.pay(balance + creditLimit + 1));
        long amount = 100;
        testCreditCard.topUp(amount);
        assertTrue(testCreditCard.pay(amount));
        assertEquals(balance, testCreditCard.balanceInfo().amount());
    }

}
