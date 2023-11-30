package cats;

/**
 * This class encapsulates cat state and behavior
 */
public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    /**
     * Constructor with two parameters
     * @param name cat name
     * @param appetite cat appetite
     */
    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    /**
     * Satisfies the cat's appetite
     * @param plate plate with food
     */
    public void eat(Plate plate) {
        if (plate.getFood() >= appetite && !satiety) {
            plate.setFood(plate.getFood() - appetite);
            satiety = true;
        }
    }

    /**
     * Gets this.appetite
     * @return int
     */
    public int getAppetite() {
        return appetite;
    }

    @Override
    public String toString() {
        return String.format("Кличка: %s Аппетит: %d Сытость: %b", name, appetite, satiety);
    }
}
