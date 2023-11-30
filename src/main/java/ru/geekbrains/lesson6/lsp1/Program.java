package ru.geekbrains.lesson6.lsp1;

import java.util.ArrayList;
import java.util.List;

public class Program {

    // Тип S будет подтипом Т тогда и только тогда,
    // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
    // что для всех программ P,
    // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.
    public static void main(String[] args) {

        Bird oT1 = new Bird(true);
        Bird oT2 = new Bird(true);
        Bird oT3 = new Bird(true);

        Duck oS1 = new Duck();
        Duck oS2 = new Duck();

        Penguin penguin1 = new Penguin();

        List<Bird> birds = new ArrayList<>();
        birds.add(oT1);
        birds.add(oT2);
        birds.add(oT3);
        birds.add(penguin1);
        birds.add(oS1);
        birds.add(oS2);

        processFly(birds);
    }

    /**
     * P
     * @param birds
     */
    public static void processFly(List<Bird> birds){
        for (Bird bird: birds) {
            if (bird.isCanFly())
                bird.fly();
        }
    }

}

/**
 * T
 */
class Bird{

    private boolean canFly;

    public boolean isCanFly() {
        return canFly;
    }

    private int flySpeed = 10;

    public Bird(boolean canFly) {
        this.canFly = canFly;
    }

    public int getFlySpeed() {
        return flySpeed;
    }

    public void fly() {
        System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed);
    }
}

/**
 * S
 */
class Duck extends Bird{


    public Duck() {
        super(true);
    }

    @Override
    public void fly() {
        System.out.printf("Утка летит со скоростью %d км/ч\n", 8);
    }
}

class Penguin extends Bird{

    public Penguin() {
        super(false);
    }

    @Override
    public void fly() {
        throw new RuntimeException("Пингвин не умеет летать!");
    }
}