package ru.geekbrains.core.lesson4.presenter;

import ru.geekbrains.core.lesson4.models.InsufficientFundsException;

public interface Validator {

    /**
     * Checks the validity of the amount
     * @param amount amount
     * @return result validation
     * @throws IllegalArgumentException
     */
    boolean checkAmount(double amount)throws IllegalArgumentException;

    /**
     * Checks availability of funds in the account
     * @param debet account balance
     * @param credit
     * @return result validation
     * @throws InsufficientFundsException
     */
    boolean checkBalance(double debet, double credit) throws InsufficientFundsException;
}
