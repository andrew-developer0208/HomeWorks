package ru.geekbrains.lesson4;

public class CreditAccount implements Accountable<AccountIdentifier> {

    @Override
    public AccountIdentifier getId() {
        return null;
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public void setAmount(double amount) {

    }
}
