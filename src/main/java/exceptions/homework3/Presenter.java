package exceptions.homework3;

public class Presenter {
    private final FileWriteble output;
    private final ConsoleReader reader;
    private final LineParser parser;


    /**
     * Constructor
     * @param writer writer
     * @param reader reader
     * @param parser parser
     */
    public Presenter(FileWriteble writer, ConsoleReader reader, LineParser parser) {
        this.output = writer;
        this.reader = reader;
        this.parser = parser;
    }

    /**
     * Starts program
     */
    public void run() {
        int choice = menu();
        while (choice != 0) {
            if (choice == 1) {
                addUser();
            }
            choice = menu();
        }
        System.out.println("The End");
    }

    /**
     * Main menu
     * @return int user choice
     */
    private int menu() {
        return reader.getNumberFromConsole("[0] Выход  [1] Добавить пользователя\n");
    }

    /**
     * Reads user data from console and write to file
     */
    private void addUser() {
        String line = reader.getStringFromConsole("""
                Введите через пробел данные пользователя:
                ФИО, телефон(только цифры) дату рождения(dd.mm.yyyy) и пол("f" или "m")
                """);
        switch (parser.checkLine(line, 6)) {
            case 0 -> System.out.println("Ошибка! Слишком много аргументов.");
            case -1 -> System.out.println("Ошибка! Слишком мало аргументов.");
            default -> {
                try {
                    line = parser.parseLine(line);
                    output.writeToFile(line.split(">")[0].substring(1), line);
                } catch (IncorrectInputException e) {
                    System.out.println(e.getMessage());
                }

            }

        }
    }
}
