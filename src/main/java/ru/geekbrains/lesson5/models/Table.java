package ru.geekbrains.lesson5.models;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class encapsulates reservation list with unique no
 */
public class Table {

    private static int counter = 100;
    private final int no;

    {
        no = ++counter;
    }

    private final Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Gets reservations list
     * @return
     */
    public Collection<Reservation> getReservations() {
        return reservations;
    }


    public int getNo() {
        return no;
    }

    @Override
    public String toString() {
        return String.format("Столик #%d", no);
    }
}
