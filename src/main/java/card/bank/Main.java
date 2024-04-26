package card.bank;

import card.bank.cards.*;

import static card.bank.cards.CardAppInstanceFactory.getCardCategory;
import static card.bank.cards.CardAppInstanceFactory.printCardProperties;

/**
 * Приложение реализует модели банковских карт и операций с ними
 */
public class Main {
    public static void main(String[] args) {

        printMessage("BANK CARD APPLICATION");


        DebitCard debitCard = new DebitCard();
        printMessage("Создана карта: " + getCardCategory(debitCard));
        printCardProperties(debitCard);

        toppingUp(debitCard, 10000);

        payment(debitCard, 3000);

        payment(debitCard, 8000);

        long l = 10000;
        CreditCard creditCard = CreditCard.creditCard(l);
        printMessage("Создана карта: " + getCardCategory(creditCard) + " c лимитом " + l);
        printCardProperties(creditCard);

        toppingUp(creditCard, 55000);

        payment(creditCard, 60000);

        ExtendedDebitCardBuilder builder = new ExtendedDebitCardBuilder();
        ExtendedDebitCard extendedDebitCard = builder.bonusRate(1.0F).
                cashBackRate(5.0F).
                minPmtAmountForCashBack(5000).
                savingRate(0.005F).build();
        printMessage("Создана карта: " + getCardCategory(extendedDebitCard));
        printCardProperties(extendedDebitCard);

        toppingUp(extendedDebitCard, 50000);

        payment(extendedDebitCard, 7000);

        payment(extendedDebitCard, 8000);

        ExtendedCreditCardBuilder extendedCreditCardBuilder = new ExtendedCreditCardBuilder();
        ExtendedCreditCard extendedCreditCard = extendedCreditCardBuilder.
                creditLimit(20000).
                bonusRate(1f).
                cashBackRate(5f).minPmtAmountForCashBack(5000).
                savingRate(0.005f).
                build();
        printMessage("Создана карта: " + getCardCategory(extendedCreditCard));
        printCardProperties(extendedCreditCard);


        toppingUp(extendedCreditCard, 7000);

        payment(extendedCreditCard, 3000);

        payment(extendedCreditCard, 10000);

        toppingUp(extendedCreditCard, 15000);


    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static <B extends BankCard> void payment(B bankCard, long amount) {
        printMessage("Карта: " + getCardCategory(bankCard));
        boolean result = bankCard.pay(amount);
        if (result) {
            printMessage("Оплата на " + amount);
        } else {
            printMessage("Недостаточно средств для оплаты на сумму " + amount);
            printCardProperties(bankCard);
        }
    }

    private static <B extends BankCard> void toppingUp(B bankCard, long amount) {
        printMessage("Карта: " + getCardCategory(bankCard));
        printMessage("Пополнение на " + amount);
        bankCard.topUp(amount);
        printCardProperties(bankCard);
    }

}