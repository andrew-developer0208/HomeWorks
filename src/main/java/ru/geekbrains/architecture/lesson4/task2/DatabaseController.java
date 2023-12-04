package ru.geekbrains.architecture.lesson4.task2;

import java.util.Collection;

public interface DatabaseController {

    /**
     * Получить актуальную стоимость билета
     * @return double
     */
    double getTicketAmount();

    /**
     * Получить идентификатор заявки на покупку билета
     * @return int
     */
    int createTicketOrder(int clientId);

    /**
     * Возвращает ссылку на базу данных билетов
     * @return Collection<Ticket>
     */
    Collection<Ticket> getTickets();

    /**
     * Возвращает ссылку на базу данных покупателей
     * @return Collection<Customer>
     */
    Collection<Customer> getCustomers();

    }
