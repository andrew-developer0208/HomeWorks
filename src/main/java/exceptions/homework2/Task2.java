package exceptions.homework2;

/*
Задание2: Если необходимо, исправьте данный код
 */
public class Task2 {

    private static void printCatchedRes1(int[] intArray) {
        if (intArray != null) {
            if (intArray.length >= 9) {
                try {
                    int d = 0;
                    double catchedRes1 = intArray[8] / d;
                    System.out.println("catchedRes1 = " + catchedRes1);
                } catch (ArithmeticException e) {
                    System.out.println("Catching exception: " + e);
                }
            } else {
                System.out.println("Размер массива должен быть больше или равен 9");
            }
        }
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printCatchedRes1(intArray);

    }

}

