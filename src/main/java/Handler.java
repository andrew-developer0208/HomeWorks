import java.util.Scanner;

public class Handler {

    /**
     * Gets String from console
     * @param msg message
     * @return String
     */
    private static String getFromConsole(String msg) {
        System.out.print(msg + "--> ");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

}
