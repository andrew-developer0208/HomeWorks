package ru.geekbrains.core.lesson4.tools;

import ru.geekbrains.core.lesson4.models.InsufficientFundsException;
import ru.geekbrains.core.lesson4.presenter.Validator;

public class DefaultValidator implements Validator {
    /**
     * Checks the validity of the amount
     *
     * @param amount amount
     * @return Verification result
     */
    @Override
    public boolean checkAmount(double amount) throws IllegalArgumentException{
        if (amount < 0) {
            throw new IllegalArgumentException("Вносимая сумма не может быть отрицательным значением");
        }
        return true;
    }

    /**
     * Checks availability of funds in the debet
     *
     * @param debet account balance
     * @param credit credit amount
     * @return Verification result
     */
    @Override
    public boolean checkBalance(double debet, double credit) throws InsufficientFundsException{
        if (debet - credit < 0) {
            throw new InsufficientFundsException("Средств на счёте недостаточно", debet, credit);
        }
        return true;
    }
}
