package ru.geekbrains.architecture.lesson4.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider implements TicketController{


    /**
     * Ищет в базе данных билет, соответствующий переданным параметрам
     * @param clientId id клиента
     * @param date дата выдачи билета
     * @return Список билетов, удовлетворяющих переданным параметрам
     */
    public Collection<Ticket> searchTicket(int clientId, Date date){

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;
    }

    /**
     * Оплачивает покупку билета с карты клиента
     * @param clientId id клиента
     * @param cardNo номер карты клиента
     * @return результат операции
     */
    public boolean buyTicket(int clientId, String cardNo){

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        return paymentProvider.buyTicket(orderId,  cardNo, amount);

    }

    /**
     * Проверяет наличие в базе данных билета с указанным qr-кодом
     * @param qrcode qr-код билета
     * @return результат операции
     */
    public boolean checkTicket(String qrcode){
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

    //region FIelds

    private final DatabaseController database;
    private final PaymentController paymentProvider;

    //endregion

    //region Constructors

    public TicketProvider(
            DatabaseController database,
            PaymentController paymentProvider
    ){
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    //endregion

}
