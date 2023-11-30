package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company {

    private static  Random random = new Random();
    private String companyName;
    private  double maxSalary;

    private Publisher jobAgency;


    public Company(String companyName, double maxSalary, Publisher jobAgency) {
        this.companyName = companyName;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee(){
        double salary;
        TypeVacancy typeVacancy;
        switch (random.nextInt(3)) {
            case 0 -> {
                typeVacancy = TypeVacancy.STUDENT;
                salary = random.nextDouble(3000, maxSalary);
            }
            case 1 -> {
                typeVacancy = TypeVacancy.MASTER;
                salary = random.nextDouble(30000, maxSalary);
            }
            default -> {
                typeVacancy = TypeVacancy.MANAGER;
                salary = random.nextDouble(50000, maxSalary);
            }
        }

        jobAgency.sendOffer(new Vacancy(companyName, salary, typeVacancy));
    }

}
