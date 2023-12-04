package ru.geekbrains.architecture.lesson4.task2;

public class PaymentProvider implements PaymentController{


    /**
     * Посылает запрос на формирование заявки на проведение платежа в процессинговую компанию
     *
     * @param orderId id ордера
     * @param cardNo  номер карты
     * @param amount  сумма
     * @return результат
     */
    @Override
    public boolean buyTicket(int orderId, String cardNo, double amount) {
        System.out.printf("Сформирована заявка на проведение платежа:\norderId: %d  cardNo: %s amaount: %.2f ",
                orderId, cardNo, amount);
        return true;
    }

}
