import calculator.Calculator;

public class Main {

    /**
     * Entry point
     * @param args arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addNumbers(2, 23);
        calculator.diffNumbers(10, 7);
        calculator.divNumbers(15, 4);
        calculator.multiNumbers(5, 3);
    }

}