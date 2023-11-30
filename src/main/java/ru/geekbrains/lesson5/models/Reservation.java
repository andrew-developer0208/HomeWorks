package ru.geekbrains.lesson5.models;

import java.util.Date;

public class Reservation {

    private static int counter = 9000;

    private final int id;
    private Date date;
    private String name;


    {
        id = ++counter;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("[%d] дата: %s Имя: %s", id, date.toString(), name);
    }
}
