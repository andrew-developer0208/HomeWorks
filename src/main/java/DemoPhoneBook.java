import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * This class demonstrates the functionality of the phone book
 */
public class DemoPhoneBook {
    private PhoneBook myPhoneBook = new PhoneBook();
    private Scanner myScanner = new Scanner(System.in);

    /**
     * Show demo
     */
    public void start() {
        int choice = menu();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    myPhoneBook.addContact(getFromConsole("Введите Фамилию Имя Телефоны через пробел"));
                    choice = menu();
                }
                case 2 -> {
                    printMap(myPhoneBook.findLastName(getFromConsole("Введите фамилию")));
                    choice = menu();
                }
                case 3 -> {
                    printMap(myPhoneBook.getContacts());
                    choice = menu();
                }
                default -> choice = menu();
            }
        }
        System.out.println("The End");
    }

    /**
     * Print to console map
     * @param map HashMap<Integer, LinkedList<String>>
     */
    private void printMap(HashMap<Integer, LinkedList<String>> map) {
        for (Map.Entry<Integer, LinkedList<String>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    /**
     * Gets user choice
     * @return int
     */
    private int menu() {
        int choice = -1;
        try {
            choice = Integer.parseInt(getFromConsole("[0]Выход  [1]Добавить  [2]Найти  [3]ПоказатьВесь\n"));
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
