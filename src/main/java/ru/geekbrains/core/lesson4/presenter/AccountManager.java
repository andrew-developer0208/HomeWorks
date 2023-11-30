package ru.geekbrains.core.lesson4.presenter;

import ru.geekbrains.core.lesson4.models.Account;
import ru.geekbrains.core.lesson4.models.AccountFactory;
import ru.geekbrains.core.lesson4.models.InsufficientFundsException;
import ru.geekbrains.core.lesson4.tools.DefaultValidator;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {


    private Validator validator;

    //region constructors

    /**
     * Constructor
     */
    public AccountManager() {
        validator = new DefaultValidator();
    }

    //endregion

    /**
     * Creates new account
     * @param typeAccount account type:
     *                    0 - Default
     *                    1 - Debit
     *                    2 - Credit
     * @param id id account
     * @param amount Initial account balance
     */
    public Account createAccount(int typeAccount, int id, double amount) {
        Account account = null;
        try {
            if (validator.checkAmount(amount)) {
                account = AccountFactory.createAccaunt(typeAccount, id, amount);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    /**
     * Makes a deposit
     * @param account account to deposit
     * @param amount deposit amount
     */
    public void addDeposit(Account account, double amount) {
        try {
            if (validator.checkAmount(amount)) {
                account.setAmount(account.getAmount() + amount);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reduces the amount on the account
     * @param account account to debit
     * @param amount amount
     * @return amount
     */
    public double getAmount(Account account, double amount) {
        double result = 0;
        try {
            if (validator.checkAmount(amount)) {
                if (validator.checkBalance(account.getAmount(), amount)) {
                    account.setAmount(account.getAmount() - amount);
                    result = amount;
                }
            }
        } catch (InsufficientFundsException e) {
            System.out.printf("%s, текущий баланс: %.2f\n", e.getMessage(), e.getDebet());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
