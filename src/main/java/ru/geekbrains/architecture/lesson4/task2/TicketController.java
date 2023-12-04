package ru.geekbrains.architecture.lesson4.task2;

import java.util.Collection;
import java.util.Date;

public interface TicketController {

    /**
     * Ищет в базе данных билет, соответствующий переданным параметрам
     * @param clientId id клиента
     * @param date дата выдачи билета
     * @return Список билетов, удовлетворяющих переданным параметрам
     */
    Collection<Ticket> searchTicket(int clientId, Date date);

    /**
     * Оплачивает покупку билета с карты клиента
     * @param clientId id клиента
     * @param cardNo номер карты клиента
     * @return результат операции
     */
    boolean buyTicket(int clientId, String cardNo);

    /**
     * Проверяет наличие в базе данных билета с указанным qr-кодом
     * @param qrcode qr-код билета
     * @return результат операции
     */
    boolean checkTicket(String qrcode);

    }
