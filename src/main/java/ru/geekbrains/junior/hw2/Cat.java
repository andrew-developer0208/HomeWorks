package ru.geekbrains.junior.hw2;

@Description("This class represents the cat model")
public class Cat extends Animal{

    private static int countCat;

    public Cat(String name, int age) {
        super(name, age);
        countCat++;
    }

    public Cat() {
        super("nonameCat", 0);
    }
    /**
     * Имитирует звуки, издаваемые животным
     */
    @Override
    public void makeSound() {
        System.out.println(name + " says \"Muurrrrr\"");
    }

    /**
     * Возвращает общее количество созданных котов
     * @return int
     */
    public static int getCountCat() {
        return countCat;
    }
}
