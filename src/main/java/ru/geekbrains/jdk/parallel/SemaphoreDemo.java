package ru.geekbrains.jdk.parallel;

import java.util.concurrent.Semaphore;

/**
 * Демонстрация класса Semaphore
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Consumer(q), "Consumer").start();
        new Thread(new Producer(q), "Producer").start();
    }
}

/**
 * общий ресурс
 */
class Q {
    int n;
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void  get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Получено:" + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

/**
 * Поставщик
 */
class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }

    }
}

/**
 * Потребитель
 */
class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }


    @Override
    public void run() {
    for (int i = 0; i < 20; i++) q.get();
    }
}