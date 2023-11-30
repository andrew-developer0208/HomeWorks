import java.util.LinkedList;
import java.util.List;

/**
 * This class emulates the behavior of a queue
 */
public class MyQueue {
    private final LinkedList<String> data = new LinkedList<>();

    /**
     * Added value to the end of data
     * @param value String
     */
    public void enQueue(String value) {
        data.add(value);
    }

    /**
     * Gets first element of data and remove it
     * @return String
     */
    public String deQueue() {
        if (!data.isEmpty()) {
            return data.remove();
        }
        System.out.println("Очередь пуста");
        return "";
    }

    /**
     * Gets first element of data
     * @return String
     */
    public String first() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        System.out.println("Очередь пуста");
        return "";
    }

    /**
     * Gets data as List
     * @return List<String>
     */
    public List<String> getList() {
        return data;
    }
}
