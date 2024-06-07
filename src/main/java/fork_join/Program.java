package fork_join;

import java.util.concurrent.ForkJoinPool;

public class Program {
    public static void main(String[] args) {
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        double[] array = getArray(100000);
        System.out.println("Часть последовательности");
        for (int i = 0; i <= 10; i++) {
            System.out.printf(" %.2f |", array[i]);
        }
        System.out.println();

        SqrtTransform task = new SqrtTransform(array, 0, array.length);
//        fjp.invoke(task);
        task.invoke();
        System.out.println("Уровень параллелизма: " + fjp.getParallelism());

        System.out.println("Часть преобразованной последовательности");
        for (int i = 0; i <= 10; i++) {
            System.out.printf(" %.2f |", array[i]);
        }

    }

    /**
     * gets double array
     * @param size array size
     */
    private static double[] getArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) i;
        }
        return array;
    }
}
