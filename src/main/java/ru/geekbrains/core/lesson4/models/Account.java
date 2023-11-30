package ru.geekbrains.core.lesson4.models;

public abstract class Account {

    private int id;
    private double amount;

    /**
     * Constructor
     * @param amount Initial account balance
     */
    public Account(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    //region getters

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    //endregion

    //region setters

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //endregion


    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("id: %d  |  amount: %.2f  |  type: %s", id, amount, this.getClass().getSimpleName());
    }
}
