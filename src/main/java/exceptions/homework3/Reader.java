package exceptions.homework3;

import java.util.Scanner;

public class Reader implements ConsoleReader{
    /**
     * Reads from console
     * @return String line
     */
    @Override
    public String getStringFromConsole(String msg) {
        System.out.print(msg + "-> ");
        Scanner myScanner = new Scanner(System.in);
        String str;
        try {
            str = myScanner.nextLine();
            if (str.equals("")) throw new RuntimeException("Пустые строки вводить нельзя");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            str = getStringFromConsole(msg);
        }
        return str;
    }

    /**
     * Reads from console
     *
     * @param msg message
     * @return int number
     */
    @Override
    public int getNumberFromConsole(String msg) {
        String input = getStringFromConsole(msg);
        while (!input.matches("[0-9]")) {
            System.out.println("Введите натуральное число");
            input = getStringFromConsole(msg);
        }
        return Integer.parseInt(input);
    }
}
