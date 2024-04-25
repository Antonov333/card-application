package card.bank;

import static card.bank.CardAppInstanceFactory.printCardProperties;

public class Main {
    public static void main(String[] args) {
        System.out.println("BANK CARD APPLICATION\n");

        DebitCard debitCard = new DebitCard();

        System.out.println(debitCard.balanceInfo() + "\n");

        debitCard.topUp(10000);
        printCardProperties(debitCard);

        CreditCard creditCard = new CreditCard(10000);
        printCardProperties(creditCard);

        creditCard.topUp(55000);
        printCardProperties(creditCard);

        creditCard.pay(60000);
        printCardProperties(creditCard);


        ExtendedDebitCardBuilder builder = new ExtendedDebitCardBuilder();
        ExtendedDebitCard extendedDebitCard = builder.bonusRate(0.01F).
                cashBackRate(0.005F).
                savingRate(0.0005F).build();
        printCardProperties(extendedDebitCard);
    }
}