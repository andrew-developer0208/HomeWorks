package ru.geekbrains.architecture.lesson4.task2;

import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * @param args
     */
    public static void main(String[] args) {

        //Создаём демо-базу данных
        DatabaseController demobase = new Database();

        for (Customer customer: demobase.getCustomers()) {
            System.out.println(customer);
            for (Ticket ticket: customer.getTickets()) {
                System.out.println(ticket);
            }
        }
        System.out.println();

        PaymentController paymentProvider = new PaymentProvider();
        TicketController ticketProvider = new TicketProvider(demobase, paymentProvider);
        ticketProvider.buyTicket(101, "1111 2222 3333 4444");


    }

}
