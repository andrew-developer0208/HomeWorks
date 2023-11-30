import java.util.*;

/**
 * Provides users terminal for choosing of notebooks
 */
public class TerminalStoreLaptops {
    private StoreLaptops storeLaptops;
    private Laptop filter;
    private Scanner myScanner;

    /**
     * Constructor
     */
    public TerminalStoreLaptops() {
        myScanner = new Scanner(System.in);
        storeLaptops = new StoreLaptops();
        storeLaptops.loadDemo();
        filter = new Laptop();
    }

    /**
     * Starts user terminal
     */
    public void start() {
        List<String> list;
        printFiltered(filter);
        int value = -1;
        int choice = menuMain();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    value = getIntFromConsole("Введите минимальный объём 0ЗУ, ГБ");
                    if (value > 0) filter.setCapacityRAM(value);
                    choice = menuMain();
                }
                case 2 -> {
                    value = getIntFromConsole("Введите минимальный объём HD , ГБ");
                    if (value > 0) filter.setCapacityHD(value);
                    choice = menuMain();
                }
                case 3 -> {
                    list = storeLaptops.getTypesOS().stream().toList();
                    printParameters(list);
                    choice = getIntFromConsole("Введите цифру, соответвующую типу ОС");
                    if (choice < list.size() && choice >= 0) {
                        filter.setTypeOS(list.get(choice));
                    }
                    choice = menuMain();
                }
                case 4 -> {
                    list = storeLaptops.getColors().stream().toList();
                    printParameters(list);
                    choice = getIntFromConsole("Введите цифру, соответствующую выбранному цвету");
                    if (choice < list.size() && choice >= 0) {
                        filter.setColour(list.get(choice));
                    }
                    choice = menuMain();
                }
                case 5 -> {
                    printFiltered(filter);
                    choice = menuMain();
                }
                case 6 -> {
                    filter = new Laptop();
                    printFiltered(filter);
                    choice = menuMain();
                }
                default -> choice = menuMain();
            }
        }
        System.out.println("До новых встреч )");
    }

    /**
     * Writes to console filtered laptops
     * @param filter instance of Laptop
     */
    private void printFiltered(Laptop filter) {
        System.out.println("-".repeat(95));
        for (Laptop laptop: storeLaptops.getFiltered(filter)) {
            System.out.println(laptop);
        }
        System.out.println("-".repeat(95));
    }

    /**
     * Writes to console set of colors or types of laptops
     * @param list List<String>
     */
    private void printParameters(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("[" + i + "]\t" + list.get(i));
        }
    }

    /**
     * Gets user choice
     * @return int
     */
    private int menuMain() {
        int choice = -1;
        String condition;
        condition = filter.getCapacityRAM() == 0 ? "Не установлен": String.valueOf(filter.getCapacityRAM());
        System.out.println("[1]<Объём ОЗУ>\t" + condition);
        condition = filter.getCapacityHD() == 0 ? "Не установлен": String.valueOf(filter.getCapacityHD());
        System.out.println("[2]<Объём HD>\t" + condition);
        condition = filter.getTypeOS().equals("") ? "Не установлен": filter.getTypeOS();
        System.out.println("[3]<Тип ОС>\t    " + condition);
        condition = filter.getColour().equals("") ? "Не установлен": filter.getColour();
        System.out.println("[4]<Цвет>\t    " + condition);
        System.out.println("[0] Выход  [5] Применить фаильтр  [6] Очистить фильтр");
        choice = getIntFromConsole("");
        return choice;
    }

    /**
     * Gets user choice
     * @return int
     */
    private int getIntFromConsole(String msg) {
        int input = -1;
        System.out.print(msg + "--> ");
        try {
            input = Integer.parseInt(myScanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод " + e.getMessage());
        }
        return input;
    }
}
