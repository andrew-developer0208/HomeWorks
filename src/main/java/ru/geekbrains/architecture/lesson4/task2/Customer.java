package ru.geekbrains.architecture.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    //region Fields

    private static int counter = 100;
    private int id;
    private Collection<Ticket> tickets = new ArrayList<>();

    //endregion

    //region Constructors

    public Customer(){
        id = ++counter;
    }

    //endregion

    //region Getters

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public int getId() {
        return id;
    }

    //endregion

    //region Setters

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    //endregion


    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("id: %d name: %s", id, this.getClass().getSimpleName());
    }
}
