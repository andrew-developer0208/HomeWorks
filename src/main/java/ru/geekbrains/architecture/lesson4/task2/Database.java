package ru.geekbrains.architecture.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;

public class Database implements DatabaseController{


    /**
     * Возвращает ссылку на базу данных билетов
     * @return Collection<Ticket>
     */
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Возвращает ссылку на базу данных покупателей
     * @return Collection<Customer>
     */
    public Collection<Customer> getCustomers() {
        return customers;
    }


    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return ++counter;
    }

    //region Fields

    private static int counter = 100;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    //endregion

    //region Constructors

    public Database(){

        Customer customer1 = new Customer();
        Ticket ticket1 = TicketFactory.createTicket(customer1.getId());
        Ticket ticket2 = TicketFactory.createTicket(customer1.getId());
        Ticket ticket3 = TicketFactory.createTicket(customer1.getId());
        customer1.getTickets().add(ticket1);
        customer1.getTickets().add(ticket2);
        customer1.getTickets().add(ticket3);
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        customers.add(customer1);

    }

    //endregion

}
