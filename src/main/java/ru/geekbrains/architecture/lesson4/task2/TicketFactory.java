package ru.geekbrains.architecture.lesson4.task2;

import java.util.Date;
import java.util.Random;

public class TicketFactory {

    public static Ticket createTicket(int customerID) {
        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setCustomerId(customerID);
        ticket.setQrcode(getQRcode());
        return ticket;

    }

    /**
     * Возвращает произвольную стрку из 10 латинских символов
     * @return String
     */
    private static String getQRcode() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append((char) random.nextInt(65, 90));
        }

        return stringBuilder.toString();
    }
}
