package ru.geekbrains.jdk.parallel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");

        es.execute(new MyNewThread("A", cd1));
        es.execute(new MyNewThread("B", cd2));
        es.execute(new MyNewThread("C", cd3));
        es.execute(new MyNewThread("D", cd4));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        es.shutdown();
        System.out.println("Завершение потоков");
    }
}

class MyNewThread implements Runnable {
    String name;
    CountDownLatch latch;

    public MyNewThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }

}