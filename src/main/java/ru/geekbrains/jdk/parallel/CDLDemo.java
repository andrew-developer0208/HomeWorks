package ru.geekbrains.jdk.parallel;

import java.util.concurrent.CountDownLatch;

/**
 * Демонстрация класса CountDownLatch
 */
public class CDLDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("Запуск потока исполнения");
        new Thread(new MyThread(countDownLatch)).start();
        countDownLatch.await();
        System.out.println("Завершение потока исполнения");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}