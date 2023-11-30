package ru.geekbrains.lesson4;

public class ArrayUtils {


    int a;


    public ArrayUtils(int a) {
        this.a = a;
    }

    public static <T> T[] replaceTwoElements(T[] array, int index1, int index2){

        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length)
            throw new IndexOutOfBoundsException();
        T[] bufArray = array.clone();
        T buf = bufArray[index1];
        bufArray[index1] = bufArray[index2];
        bufArray[index2] = buf;
        return bufArray;
    }

    public static Object[] replaceTwoElementsV2(Object[] array, int index1, int index2){
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length)
            throw new IndexOutOfBoundsException();
        Object[] bufArray = array.clone();
        Object buf = bufArray[index1];
        bufArray[index1] = bufArray[index2];
        bufArray[index2] = buf;
        return bufArray;
    }


}
