package ru.geekbrains.core.lesson4.models;

public class InsufficientFundsException extends Exception{

    private double debet;
    private double credit;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public InsufficientFundsException(String message, double debet, double credit) {
        super(message);
        this.debet = debet;
        this.credit = credit;
    }

    //region getters

    /**
     * gets account amount
     * @return current account balance
     */
    public double getDebet() {
        return debet;
    }

    /**
     * Gets credit amount
     * @return amount
     */
    public double getCredit() {
        return credit;
    }

    //endregion
}
