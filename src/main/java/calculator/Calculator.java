package calculator;

public class Calculator {
    private final OutFormatter outFormatter;

    public Calculator() {
        outFormatter = new OutFormatter();
    }

    /**
     * Prints summ of numbers
     * @param a first
     * @param b second
     */
    public void addNumbers(int a, int b) {
        int result = b + a;
        outFormatter.printResult(a, b, "+", String.valueOf(result));
    }

    /**
     * Prints difference of numbers
     * @param a first
     * @param b first
     */
    public void diffNumbers(int a, int b) {
        int result = a - b;
        outFormatter.printResult(a, b, "-", String.valueOf(result));
    }

    /**
     * Prints multiplication of two numbers
     * @param a first
     * @param b second
     */
    public void multiNumbers(int a, int b){
        int result = a * b;
        outFormatter.printResult(a, b, "*", String.valueOf(result));
    }

    /**
     * Prints division result
     * @param a divisible
     * @param b divider
     */
    public void divNumbers(int a, int b) {
        double result = (double) a / b;
        outFormatter.printResult(a, b, "/", String.valueOf(result));
    }
}
