package cats;

import java.util.LinkedList;

/*
Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
        Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
        Если коту удалось покушать (хватило еды), сытость = true. Считаем, что если коту мало еды в тарелке,
        то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
        Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом
        вывести информацию о сытости котов в консоль.
        Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/
public class MainClass {

    public static void main(String[] args) {

        LinkedList<Cat> cats = CatHome.getDemoCats(10, 10, 20);
        cats.forEach(System.out::println);

        Plate plate = new Plate(100);
        System.out.println("В тарелке " + plate.getFood() + " еды");
        System.out.println("-".repeat(85) + "\nПокормим котиков )");

        CatHome catHome = new CatHome(cats);
        catHome.feedAllCats(plate);

        System.out.println("В тарелке осталось " + plate.getFood() + " еды");

    }
}
