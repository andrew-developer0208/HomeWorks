package ru.geekbrains.lesson7.observer;

public class Vacancy implements VacancyModel{
    private final TypeVacancy typeVacancy;
    private final String companyName;
    private final double salary;

    public Vacancy(String companyName, double salary, TypeVacancy typeVacancy) {
        this.companyName = companyName;
        this.salary = salary;
        this.typeVacancy = typeVacancy;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public TypeVacancy getTypeVacancy() {
        return typeVacancy;
    }
}
