package ru.geekbrains.lesson4;

public class DebetAccount<T> implements Accountable<T> {

    @Override
    public T getId() {
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
