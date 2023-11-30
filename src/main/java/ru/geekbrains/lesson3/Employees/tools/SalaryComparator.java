package ru.geekbrains.lesson3.Employees.tools;

import ru.geekbrains.lesson3.Employees.model.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o2.calculateSalary(), o1.calculateSalary());
    }
}
