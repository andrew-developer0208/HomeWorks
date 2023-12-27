package ru.geekbrains.jdk.employeeHandbook;

public class Main {

    public static void main(String[] args) {

        // Создаём новый справочник
        EmployeeHandbook handbook = new EmployeeHandbook();

        // Наполняем справочник сотрудниками
        handbook.addEmployee(new Employee("Иван", "111-111", 2));
        handbook.addEmployee(new Employee("Владимир", "222-222", 7));
        handbook.addEmployee(new Employee("Андрей", "333-333", 5));
        handbook.addEmployee(new Employee("Ирина", "444-444", 4));
        handbook.addEmployee(new Employee("Мария", "555-555", 3));
        handbook.addEmployee(new Employee("Андрей", "777-777", 29));

        System.out.println("\nСписок сотрудников:");
        handbook.getAllEmployees().forEach(System.out::println);
//        System.out.println("-".repeat(55));

        System.out.println("\nСотрудники, чей стаж не менее 5 лет:");
        handbook.getByExperience(5).forEach(System.out::println);

        System.out.println("\nСписок телефонов сотрудников, с именем Андрей:");
        handbook.getPhoneNumbers("Андрей").forEach(System.out::println);

        System.out.println("\nСотрудник с табельным номером 1001:");
        System.out.println(handbook.getByID(1001));

    }
}
