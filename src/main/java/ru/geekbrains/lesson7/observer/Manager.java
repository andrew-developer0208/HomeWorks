package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Manager implements Observer{
    private static Random random = new Random();

    private String name;

    private double minSalary;

    public Manager(String name) {
        this.name = name;
        minSalary = random.nextDouble(60000, 100000);
    }

    @Override
    public void receiveOffer(VacancyModel vacancy) {
        if (vacancy.getTypeVacancy() == TypeVacancy.MANAGER) {
            if (minSalary <= vacancy.getSalary()) {
                System.out.printf("Менеджер %s (%f) >>> Мне нужна эта работа! [%s - %f] [%s]\n",
                        name, minSalary,
                        vacancy.getCompanyName(),
                        vacancy.getSalary(),
                        vacancy.getTypeVacancy());
                minSalary = vacancy.getSalary();
            } else {
                System.out.printf("Менеджер %s >>> Я найду работу получше (%f)! [%s - %f] [%s]\n",
                        name, minSalary,
                        vacancy.getCompanyName(),
                        vacancy.getSalary(),
                        vacancy.getTypeVacancy());
            }
        }
    }
}
