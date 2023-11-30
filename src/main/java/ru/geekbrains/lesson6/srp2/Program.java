package ru.geekbrains.lesson6.srp2;

import ru.geekbrains.lesson6.srp2.model.OrderModel;
import ru.geekbrains.lesson6.srp2.presenter.OrderPresenter;
import ru.geekbrains.lesson6.srp2.view.OrderView;

public class Program {

    /**
     * TODO: Задача 1. Домашняя работа. Оптимизировать работу класса Order в  рамках принципа SRP.
     * @param args
     */
    public static void main(String[] args) {
/*
        Order order = new Order();
        order.inputFromConsole();
        order.saveToJson();
*/
        OrderPresenter presenter = new OrderPresenter(new OrderModel(), new OrderView());
        presenter.inputOrder();
        presenter.saveToJson();
    }

}
