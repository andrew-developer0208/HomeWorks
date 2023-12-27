package ru.geekbrains.jdk.employeeHandbook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeHandbook {
    private final List<Employee> employees;

    /**
     * Конструктор
     */
    public EmployeeHandbook() {
        employees = new ArrayList<>();
    }

    /**
     * Добавляет сотрудника в коллекцию
     * @param employee экземпляр employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Возвращает список всех сотрудников
     * @return List
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * Возвращает список сотрудников, чей опыт больше или равен требуемому
     * @param level требуемый опыт
     * @return List
     */
    public List<Employee> getByExperience(int level) {

        return employees.stream().filter(x -> x.getExperience() >= level).collect(Collectors.toList());
    }

    /**
     * Возвращает список номеров сотрудников с указанным именем
     * @param name имя
     * @return List
     */
    public List<String> getPhoneNumbers(String name) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Employee employee: employees) {
            if (employee.getName().equals(name)) {
                phoneNumbers.add(employee.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }

    /**
     * Возвращает сотрудник с указанным id
     * @param id id
     * @return Employee
     */
    public Employee getByID(int id) {
        for (Employee employee: employees) {
            if (employee.getId() == id) return employee;
        }
        return null;
    }

}
