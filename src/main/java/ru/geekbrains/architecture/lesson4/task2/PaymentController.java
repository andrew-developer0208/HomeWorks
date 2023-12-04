package ru.geekbrains.architecture.lesson4.task2;

public interface PaymentController {

    /**
     * Посылает запрос на формирование заявки на проведение платежа в процессинговую компанию
     * @param orderId id ордера
     * @param cardNo номер карты
     * @param amount сумма
     * @return результат
     */
    boolean buyTicket(int orderId, String cardNo, double amount);
}
