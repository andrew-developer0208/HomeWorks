package exceptions.homework3;

public interface LineParser {

    /**
     * Parses input line
     * @param line String
     * @return String formatted line
     */
    public String parseLine(String line) throws IncorrectInputException;

    /**
     * Checks the equal of the number of arguments to the strandard
     */
    public int checkLine(String line, int standard);
}
