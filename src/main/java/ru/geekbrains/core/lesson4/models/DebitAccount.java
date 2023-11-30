package ru.geekbrains.core.lesson4.models;

public class DebitAccount extends Account{
    /**
     * Constructor
     *
     * @param amount Initial account balance
     */
    public DebitAccount(int id, double amount) {
        super(id, amount);
    }
}
