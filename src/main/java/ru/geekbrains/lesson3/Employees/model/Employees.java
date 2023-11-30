package ru.geekbrains.lesson3.Employees.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees implements Iterable<Employee>{

    private List<Employee> employees = new ArrayList<>();

    /**
     * Adds employee to employees
     * @param employee
     */
    public void addEmploee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }
}
