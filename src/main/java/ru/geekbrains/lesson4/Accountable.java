package ru.geekbrains.lesson4;

public interface Accountable<T> {

    T getId();

    double getAmount();

    void setAmount(double amount);

}
