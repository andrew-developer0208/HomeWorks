package ru.geekbrains.architecture.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private static int counter = 100;
    private int id;
    private Collection<Ticket> tickets = new ArrayList<>();

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


}
