package ru.geekbrains.junior.hw3;

import static ru.geekbrains.junior.hw3.Handler.*;

public class Program {

    /**
     * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     * Обеспечьте поддержку сериализации для этого класса.
     * Создайте объект класса Student и инициализируйте его данными.
     * Сериализуйте этот объект в файл.
     * Десериализуйте объект обратно в программу из файла.
     * Выведите все поля объекта, включая GPA, и ответьте на вопрос,
     * почему значение GPA не было сохранено/восстановлено.
     *
     * 2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
     * @param args
     */
    public static void main(String[] args) {

        Student student = new Student("Андрей", 20, 5.0);
        System.out.println("\n Новый студент:\n" + student);

        // Сериализуем в bin
        serialToBin(student);

        // Десериализуем из bin
        // значение GPA не было сохранено/восстановлено
        // потому что значение переменной с модификатором доступа `transient` не сохраняется
        student = deSerialFromBin();
        System.out.println("\n После десериализации из bin:\n" + student);

        student = new Student("Ирина", 19, 4.9);
        System.out.println("\n Новый студент:\n" + student);

        // сериализуем в json
        serialToJson(student);

        // Десериализируем из json
        student = deSerialFromJson();
        System.out.println("\n После десериализации из json:\n" + student);

        student = new Student("Роман", 23, 4.5);
        System.out.println("\n Новый студент:\n" + student);

        // Сериализуем в xml
        serialToXml(student);

        // Десериализируем из xml
        student = deSerialFromXml();
        System.out.println("\n После десериализации из xml:\n" + student);

    }
}
