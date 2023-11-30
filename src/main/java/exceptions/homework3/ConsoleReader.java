package exceptions.homework3;

public interface ConsoleReader {

    /**
     * Reads from console
     * @return String line
     */
    public String getStringFromConsole(String msg);

    /**
     * Reads from console
     * @param msg message
     * @return int number
     */
    public int getNumberFromConsole(String msg);
}
