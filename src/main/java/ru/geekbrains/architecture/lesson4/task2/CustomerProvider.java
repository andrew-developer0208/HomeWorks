package ru.geekbrains.architecture.lesson4.task2;

public class CustomerProvider {

    private DatabaseController database;

    public CustomerProvider(DatabaseController database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password){
        //TODO: Процесс аутентификации
        return new Customer();
    }


}
