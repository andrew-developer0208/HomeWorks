package ru.geekbrains.lesson3.Employees.tools;

import ru.geekbrains.lesson3.Employees.model.Employee;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     */
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
