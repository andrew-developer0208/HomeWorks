package algorithms;

import java.util.Date;

public class Seminar2 {

    /**
     * Shaker Sort
     * @param arr
     */
    public static void shakerSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            for(int j = n - 1 - i; j > i; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    /**
     * Merge Sort
     * @param arr
     */
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    public static int[] buff = new int[100001];

    public static void mergeSort(int[] arr, int left, int right){ // O(n * log n)
        if(left == right){
            return ;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int i = left, j = mid+1, k = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                buff[k++] = arr[i++];
            }else{
                buff[k++] = arr[j++];
            }
        }

        while(i <= mid){
            buff[k++] = arr[i++];
        }

        while(j <= right){
            buff[k++] = arr[j++];
        }

        for(int q = left; q<=right; q++){
            arr[q] = buff[q];
        }
    }

    /**
     * BinarySearch
     * @param array
     * @param valume
     * @return
     */
    public static int BinarySearch(int[] array, int valume){ // O(log N)
        int left = 0, right = array.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(array[mid] >= valume){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(array[left] == valume)
            return left;
        if(array[right] == valume)
            return right;
        return -1;
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
//        int n = 100000;
//        int[] arr1 = new int[n];
//        //int[] arr2 = new int[n];
//        for(int i=0; i<n; i++){
//            arr1[i] = (int)(Math.random() * 10000);
//            //arr2[i] = arr1[i];
//        }

        int[] arr1 = {18, 12, 4, 13, 6, 5, 8, 8, 9, 10};


//        Date start = new Date();
//        //sort1(arr1);
//        Date end = new Date();
//        //long time1 = end.getTime() - start.getTime();
//
//        start = new Date();
//        mergeSort(arr1);
//        end = new Date();
//        long time2 = end.getTime() - start.getTime();
//
//        //System.out.printf("time1 = %d, time2 = %d ", time1, time2);
//
//        int pos = BinarySearch(arr1, 8);
//
//        System.out.printf("pos = %d, arr[pos] = %d , arr[pos-1] = %d ", pos, arr1[pos], arr1[pos-1]);
//

        for (int element: arr1) {
            System.out.printf("%d | ", element);
        }

        shakerSort(arr1);
        System.out.println();

        for (int element: arr1) {
            System.out.printf("%d | ", element);
        }

    }
}