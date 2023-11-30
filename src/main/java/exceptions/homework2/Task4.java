package exceptions.homework2;

/*
Разработайте программу, которая выбросит Exception, когда пользователь
вводит пустую строку. Пользователю должно показаться сообщение,
что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Task4 {

    /**
     * Gets String from console
     * @param msg message
     * @return String
     */
    private static String getFromConsole(String msg) {
        System.out.print(msg + "--> ");
        Scanner myScanner = new Scanner(System.in);
        String str;
        try {
            str = myScanner.nextLine();
            if (str.equals("")) throw new RuntimeException("Пустые строки вводить нельзя");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            str = getFromConsole(msg);
        }
        return str;
    }

    /**
     * Main
     * @param args arguments is empty
     */
    public static void main(String[] args) {
        System.out.println("Вы ввели:\n" + getFromConsole("Введите строку"));
    }

}
