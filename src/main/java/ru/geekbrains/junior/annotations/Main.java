package ru.geekbrains.junior.annotations;

/**
 * Эта программа демонстрирует использование рефлексии и аннотаций
 *
 */
public class Main {
    public static void main(String[] args) {
        MessageListener messageListener = new MessageListener();
        messageListener.onMessageReceived("бот help");
    }
}
