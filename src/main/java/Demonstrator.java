import java.util.Scanner;

/**
 * This class demonstrates methods of MyQueue
 */
public class Demonstrator {
    private MyQueue myQueue = new MyQueue();
    private Scanner myScanner = new Scanner(System.in);

    /**
     * Demonstrates methods of MyQueue
     */
    public void startDemo() {
        int choice = menu();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    myQueue.enQueue(getFromConsole("Новый элемент"));
                    choice = menu();
                }
                case 2 -> {
                    System.out.println(myQueue.deQueue());
                    choice = menu();
                }
                case 3 -> {
                    System.out.println(myQueue.first());
                    choice = menu();
                }
                case 4 -> {
                    System.out.println(myQueue.getList());
                    choice = menu();
                }
                default -> choice = menu();
            }
        }
        System.out.println("До новых встреч )");
    }

    /**
     * Gets user choice
     * @return int
     */
    private int menu() {
        int choice = -1;
        try {
            choice = Integer.parseInt(getFromConsole("[0]exit  [1]enQueue  [2]deQueue  [3]first  [4]printQueue\n"));
        } catch (NumberFormatException e) {
            System.out.println("Так не пойдёт " + e.getMessage());
        }
        return choice;
    }

    /**
     * Gets String from console
     * @param msg message
     * @return String
     */
    private String getFromConsole(String msg) {
        System.out.print(msg + "--> ");
        return myScanner.nextLine();
    }

}
