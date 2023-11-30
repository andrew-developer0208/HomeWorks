package ru.geekbrains.lesson3.Employees.tools;

import ru.geekbrains.lesson3.Employees.model.Employee;
import ru.geekbrains.lesson3.Employees.model.Freelancer;
import ru.geekbrains.lesson3.Employees.model.Worker;

import java.util.Random;

public class EmployeeGenerator {
    static Random random = new Random();

    public static Employee createRandomEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        switch (random.nextInt(2)) {
            case 0 -> {
                return new Worker(names[random.nextInt(2)],
                        surnames[random.nextInt(surnames.length)],
                        random.nextInt(20000, 80000),
                        random.nextInt(20, 55));
            }
            case 1 -> {
                return new Freelancer(names[random.nextInt(2)],
                        surnames[random.nextInt(surnames.length)],
                        random.nextInt(500, 1000),
                        random.nextInt(20, 55));
            }
        }

        int salary = random.nextInt(20000, 80000);
        return new Worker(names[random.nextInt(2)],
                surnames[random.nextInt(surnames.length)],
                salary,
                random.nextInt(20, 55));
    }

}
