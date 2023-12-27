package ru.geekbrains.jdk.employeeHandbook;

public class Employee {

    private static int counter = 1000;
    private int id;
    private String name;
    private String phoneNumber;
    private int experience;

    {
        id = ++counter;
    }

    public Employee(String name, String phoneNumber, int experience) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("id: %d name: %-10s  phoneNumber: %-10s experience: %d",
                id, name, phoneNumber,experience);
    }
}
