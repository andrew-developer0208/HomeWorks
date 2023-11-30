package ru.geekbrains.lesson6.isp;

public class TerminalPaymentService extends PaymentService implements CreditCardPayable, WebMoneyPayable {
    @Override
    public void payWebMoney(int amount) {
        System.out.printf("Terminal pay by web money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount) {
        System.out.printf("Terminal pay by credit card %d\n", amount);
    }

}
