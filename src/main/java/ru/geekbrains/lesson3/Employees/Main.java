package ru.geekbrains.lesson3.Employees;

import ru.geekbrains.lesson3.Employees.model.Employee;
import ru.geekbrains.lesson3.Employees.model.Employees;
import ru.geekbrains.lesson3.Employees.model.Freelancer;
import ru.geekbrains.lesson3.Employees.tools.AgeComparator;
import ru.geekbrains.lesson3.Employees.tools.EmployeeGenerator;
import ru.geekbrains.lesson3.Employees.tools.SalaryComparator;

import java.util.Arrays;

public class Main {

    /**
     * Entry point
     * @param args
     */
    public static void main(String[] args) {

        // Работаем с массивом

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
        {
            employees[i] = EmployeeGenerator.createRandomEmployee();
        }

        System.out.println("\nСортировка по фамилии и имени(при совпадении фамилий):\n" + "-".repeat(126));
        Arrays.sort(employees);
        Arrays.stream(employees).forEach(System.out::println);

        System.out.println("\nСортировка по убыванию уровня заработной платы:\n" + "-".repeat(126));
        Arrays.stream(employees).sorted(new SalaryComparator()).forEach(System.out::println);

        System.out.println("\nСортировка по возрасту от меньшего к большему:\n" + "-".repeat(126));
        Arrays.stream(employees).sorted(new AgeComparator()).forEach(System.out::println);

        System.out.println("\nСортировка по убыванию уровня заработной платы. Только фрилансеры:\n" + "-".repeat(126));
        Arrays.stream(employees).
                filter(a -> a instanceof Freelancer).
                sorted(new SalaryComparator()).
                forEach(System.out::println);

        // Работаем с классом

        Employees employees1 = new Employees();
        for (int i = 0; i < 10; i++) {
            employees1.addEmploee(EmployeeGenerator.createRandomEmployee());
        }

        System.out.println("\nПеребираем содержимое класса employees1:\n" + "-".repeat(126));
        for (Employee employee: employees1) {
            System.out.println(employee);
        }

    }

}
