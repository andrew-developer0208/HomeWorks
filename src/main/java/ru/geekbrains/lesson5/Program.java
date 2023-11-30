package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: Домашняя работа: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {
        Model tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);

        System.out.println("\n---Текущее состояние брони---");
        bookingPresenter.showTables();

        System.out.println("\n---Бронируем столики---");
        bookingView.reservationTable(new Date(), 103, "Станислав");
        bookingView.reservationTable(new Date(), 103, "Владислав");
        bookingView.reservationTable(new Date(), 101, "Владимир");
        bookingView.reservationTable(new Date(), 101, "Елена");

        System.out.println("\n---Текущее состояние брони---");
        bookingPresenter.showTables();

        System.out.println("\n---Меняем бронь---");
        bookingView.changeReservationTable(9002, new Date(), 103, "Марина");

        System.out.println("\n---Текущее состояние брони---");
        bookingPresenter.showTables();

    }

}
