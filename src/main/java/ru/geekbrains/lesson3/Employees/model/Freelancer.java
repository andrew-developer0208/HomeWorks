package ru.geekbrains.lesson3.Employees.model;

/**
 * Employee with hourly pay
 */
public class Freelancer extends Employee {
    private double rate;

    /**
     *
     * @param name freelancer name
     * @param surname  freelancer surname
     * @param rate hourly rate
     */
    public Freelancer(String name, String surname, double rate, int age) {
        super(name, surname, rate, age);
        this.rate = rate;
        salary = calculateSalary();
    }

    /**
     * Расчет среднемесячной заработной платы
     *
     * @return Employee salary
     */
    @Override
    public double calculateSalary() {
        return rate * 20.8 * 8;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("%-10s %-10s Фрилэнсер    (часовая ставка * 20.8 * 8) : %10.2f (руб.) Возраст: %-2d",
                surname, name, calculateSalary(), age);
    }
}
