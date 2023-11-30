package ru.geekbrains.core.lesson4;

import ru.geekbrains.core.lesson4.models.Account;
import ru.geekbrains.core.lesson4.presenter.AccountManager;

public class Program {
    public static void main(String[] args) {

        System.out.println("\nСоздадим два аккаунта:");
        AccountManager manager = new AccountManager();
        Account firstAccount = manager.createAccount(1,1001, 3000);
        Account secondAccount = manager.createAccount(2,1002, 5000);
        System.out.println(firstAccount);
        System.out.println(secondAccount);

        System.out.println("\nПробуем создать аккаунт с отрицательным балансом:");
        Account thirdAccount = manager.createAccount(2,1002, -5000);
        System.out.println(thirdAccount);

        System.out.println("\nВносим валидный депозит:");
        manager.addDeposit(firstAccount, 500);
        System.out.println(firstAccount);
        System.out.println(secondAccount);

        System.out.println("\nПробуем внести отрицательный депозит:");
        manager.addDeposit(firstAccount, -500);
        System.out.println(firstAccount);
        System.out.println(secondAccount);

        System.out.println("\nСнимаем со счёта сумму, не превышающую текущий баланс:");
        double cash = manager.getAmount(secondAccount, 1000);
        System.out.printf("Снято со счёта %.2f\n", cash);
        System.out.println(firstAccount);
        System.out.println(secondAccount);

        System.out.println("\nПробуем Снять со счёта сумму, превышающую текущий баланс:");
        cash = manager.getAmount(secondAccount, 5000);
        System.out.printf("Снято со счёта %.2f\n", cash);
        System.out.println(firstAccount);
        System.out.println(secondAccount);
    }
}
