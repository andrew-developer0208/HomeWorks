package ru.geekbrains.lesson4.homework;

public class Program {

    /**
     Домашняя работа, задача:
     ========================

     a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     Можно сравнивать коробки с яблоками и апельсинами;
     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
     g. Не забываем про метод добавления фрукта в коробку.
     */
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>("Яблоки_1");
        for (int i = 0; i <  15; i++) {
            appleBox1.addFruit(new Apple());
        }
        System.out.println("\nКоробка с яблоками:\n" + appleBox1);

        Box<Orange> orangeBox1 = new Box<>("Апельсины_1");
        for (int i = 0; i <  10; i++) {
            orangeBox1.addFruit(new Orange());
        }
        System.out.println("\nКоробка с апельсинами:\n" + orangeBox1);

        System.out.println("\nСравним коробку апельсинов с коробкой яблок по весу\n" + appleBox1.compare(orangeBox1));

        appleBox1.addFruit(new Apple());
        System.out.println("\nДобавили яблоко в коробку\n" + appleBox1 + "\n" + orangeBox1);

        System.out.println("\nПовторим сравнение после добавления яблока в коробку\n" + appleBox1.compare(orangeBox1));

        Box<Apple> appleBox2 = new Box<>("Яблоки_2");
        System.out.println("\nНовая пустая коробка для яблок\n" + appleBox2);

        appleBox1.transfer(appleBox2);
        System.out.println("\nПересыпем яблоки из первой коробки в пустую:\n" + appleBox1 + "\n" + appleBox2);

    }
}
