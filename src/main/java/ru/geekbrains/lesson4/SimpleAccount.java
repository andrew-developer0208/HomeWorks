package ru.geekbrains.lesson4;

public class SimpleAccount {

    private final int id;

    private double amount;

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public SimpleAccount(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Сумма средств на счете #%s : %.2f руб.\n", id, amount);
    }
}
