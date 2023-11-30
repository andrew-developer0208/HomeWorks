package exceptions;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Запишите в файл следующие строки:

        Анна=4
        Елена=5
        Марина=6
        Владимир=?
        Константин=?
        Иван=4
        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
        (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти
        по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
        Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее
        исключение.Записать в тот же файл данные с замененными символами ?.
 */

public class Seminar2 {


    public static void main(String[] args) {
        File file = new File("1.txt");
        FileWriter fileWriter = null;
        HashMap<String, String> map = new HashMap<>();
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");

            map = read(file);System.out.println(map);
            change(map);

            write(map,file);


        } catch (IOException e) {
            System.out.println("Write process problem");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static HashMap<String, String> read(File file) {
        HashMap<String, String> map = new HashMap<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = input.readLine()) != null) {
                map.put(str.split("=")[0], str.split("=")[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();


        }
        return map;
    }

    public static void change(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("?")) {
                entry.setValue(String.valueOf(entry.getKey().length()));
            }
        }

    }

    public static void write(HashMap<String, String> map, File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                fileWriter.write(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}