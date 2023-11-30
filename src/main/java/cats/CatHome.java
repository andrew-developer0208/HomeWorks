package cats;

import java.util.*;

/**
 * This class encapsulates list of cats and methods for feed them
 */
public class CatHome {
    private LinkedList<Cat> cats;

    /**
     * Constructor without parameters
     */
    public CatHome() {
        this.cats = new LinkedList<>();
    }

    /**
     * Constructor with one parameter
     * @param cats list of cats
     */
    public CatHome(LinkedList<Cat> cats) {
        this.cats = cats;
    }

    /**
     * Gets new random list of cats
     * @param size number of cats in the list
     * @param minAppetite minimum appetite
     * @param maxAppetite maximum appetite
     * @return LinkedList<Cat>
     */
    public static LinkedList<Cat> getDemoCats(int size, int minAppetite, int maxAppetite) {
        Random random = new Random();
        List<String> names = new ArrayList<>(Arrays.asList("Барсик",
                "Мурзик",
                "Пушок",
                "Маркиза",
                "Васька",
                "Дымок",
                "Тайсон",
                "Багира"));
        LinkedList<Cat> cats= new LinkedList<>();
        for (int i = 0; i < size; i++) {
            cats.add(new Cat(names.get(random.nextInt(names.size())),
                    minAppetite + random.nextInt(maxAppetite - minAppetite + 1)));
        }
        return cats;
    }

    /**
     * Feeds all the cats from this.cats
     * Cats with a bigger appetite are the first to eat
     * @param plate plate with food
     */
    public void feedAllCats(Plate plate) {
        cats.sort((o1, o2) -> o2.getAppetite() - o1.getAppetite());
        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat);
        }
    }
}
