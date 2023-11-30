package calculator;

public class OutFormatter {

    /**
     * Prints to console arithmetic expression
     * @param a first argument
     * @param b second argument
     * @param glif icon indicating an arithmetic action
     * @param result String result
     */
    public void printResult(int a, int b, String glif, String result) {
        System.out.printf("%d %s %d = %s\n", a, glif, b, result);
    }
}
