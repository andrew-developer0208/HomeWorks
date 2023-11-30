package ru.geekbrains.core.lesson4.models;

public class AccountFactory {

    public static Account createAccaunt(int type, int id, double amount) {
        switch (type) {
            case 1 -> {
                return new DebitAccount(id, amount);
            }
            case 2 -> {
                return new CreditAccount(id, amount);
            }
            default -> {
                return new DefaultAccount(id, amount);
            }
        }

    }
}
