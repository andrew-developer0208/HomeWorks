package ru.geekbrains.jdk.parallel;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}

/**
 * общий ресурс
 */
class Shared {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;

    public AtomThread(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("Запуск потока " + name);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Поток" + name + "получено: " + Shared.ai.getAndSet(i));
        }
    }
}