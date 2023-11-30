package exceptions.homework2;

import java.io.*;

/*
Задание 4:
Исправьте код, примените подходящие способы обработки исключений
 */
public class SomeClass {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};

            try {
                String strings1 = strings[2];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Обращение к несуществующему индексу\n" + e.getMessage());
                System.out.println("-".repeat(30));
            }

            test();

            try {
                int a = 1 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль\n" + e.getMessage());
                System.out.println("-".repeat(30));
            }

            inputStream = new FileInputStream(("sdafgdsaf"));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не существует\n" + e.getMessage());
            System.out.println("-".repeat(30));
        } catch (IOException e) {
            System.out.println(("asdfasdfdsa"));
        } finally {
            System.out.println("Я всё равно выполнился");
        }
        System.out.println("Я жив!");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
//        test(); Попытка запустить рекурсию без базы рекурсии

    }
}
