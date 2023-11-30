package ru.geekbrains.lesson3.Employees.model;

import ru.geekbrains.lesson3.Employees.model.Employee;

public class Worker extends Employee {

    public Worker(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s Рабочий   (фиксированная месячная оплата): %10.2f (руб.) Возраст: %2d",
                surname, name, calculateSalary(), age);
    }
}
