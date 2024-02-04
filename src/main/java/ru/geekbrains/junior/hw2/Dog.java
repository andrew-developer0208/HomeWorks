package ru.geekbrains.junior.hw2;

@Description("This class represents the dog model")
public class Dog extends Animal{

    private static int countDog;

    public Dog(String name, int age) {
        super(name, age);
        countDog++;
    }

    /**
     * Имитирует звуки, издаваемые животным
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says \"Gav..gav..avavavavav\"");
    }

    /**
     * Возвращает общее количество созданных собак
     * @return int
     */
    public static int getCountDog() {
        return countDog;
    }
}
