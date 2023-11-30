package cats;

/**
 * This class encapsulates plate with food
 */
public class Plate {
    private  int food;

    /**
     * Constructor with one parameter
     * @param food food portion
     */
    public Plate(int food) {
        this.food = food;
    }

    /**
     * Adds portion to food
     * @param portion int portion of food
     */
    public void addFood(int portion) {
        this.food += portion;
    }

    /**
     * Sets this.food
     * @param food int food
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     *Gets this.food
     * @return int food
     */
    public int getFood() {
        return food;
    }
}
