package algorithms;

public class HeapSort {

    /**
     * Sorts by a heap style
     * @param array integer array
     */
    public static void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >=0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >=0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    /**
     * builds the heap
     * @param array integer array
     * @param heapSize heap size
     * @param rootIndex root index (parent node)
     */
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }


    /**
     * Gets array with random elements on a range
     * @param size  array size
     * @param min beginning of the range
     * @param max end of the range
     * @return int array
     */
    private static int[] getDemoArray(int size, int min, int max) {
        int[] demoArray = new int[size];
        for (int i = 0; i < demoArray.length; i++) {
            demoArray[i] = (int)(Math.random() * (max - min) + min);
        }
        return demoArray;
    }

    /**
     * Main
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println("Random array:");
        int[] array = getDemoArray(20, 1, 100);

        for (int element: array) {
            System.out.printf("%d |", element);
        }
        System.out.println("\nSorted array:");

        sort(array);

        for (int element: array) {
            System.out.printf("%d |", element);
        }

    }
}
