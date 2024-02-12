package ru.geekbrains.junior.hw4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Создайте базу данных (например, SchoolDB).
 * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
 * Настройте Hibernate для работы с вашей базой данных.
 * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
 * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
 * Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */
public class Program {

    public static void main(String[] args) throws SQLException {

        createDB();
        System.out.println("БД успешно создана");

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        List<Course> courses =Arrays.asList(
                Course.getNewCourse("Архитектура ПО",12),
                Course.getNewCourse("Java Core",4),
                Course.getNewCourse("JDK",5),
                Course.getNewCourse("Spring",12)
        );

        courses.forEach(System.out::println);

        try {

            // Вставляем в БД список курсов
            courses.forEach(course -> insertCourse(sessionFactory.openSession(), course));

            // Выводим все записи
            System.out.println("\nВсе записи из БД:");
            getAll(sessionFactory.openSession()).forEach(System.out::println);

            // Выводим запись с индексом = 2
            System.out.println("\nЗапись из БД с индексом 2:");
            System.out.println(getById(sessionFactory.openSession(),2));

            // Обновляем запись
            System.out.println("\nОбновляем запись с индексом 1:");
            update(sessionFactory.openSession(),
                    1,
                    "Java Junior",
                    5);
            getAll(sessionFactory.openSession()).forEach(System.out::println);

            // Удаляем запись с индексом 1
            System.out.println("\nУдаляем запись с индексом 1:");
            remove(sessionFactory.openSession(), 1);
            getAll(sessionFactory.openSession()).forEach(System.out::println);

        } finally {
            sessionFactory.close();
        }
    }

    /**
     * Удаляет из БД запись с указанным индексом
     * @param session открытая сессия
     * @param index индекс удаляемой записи
     */
    private static void remove(Session session, int index) {
        session.beginTransaction();

        Course deletedCourse = session.get(Course.class, index);
        session.delete(deletedCourse);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Обновляет запись с указанным id
     * @param session отктытая сессия
     * @param id id
     * @param title Новое название курса
     * @param duration Новоя продолжительность курса
     */
    private static void update(Session session,
                               int id,
                               String title,
                               int duration) {
        session.beginTransaction();

        Course updatedCourse = session.get(Course.class, id);

        updatedCourse.setTitle(title);
        updatedCourse.setDuration(duration);

        session.update(updatedCourse);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Возвращает из БД запись, соответствующую index
     * @param session Открытая сессия
     * @param index индекс
     * @return Course
     */
    private static Course getById(Session session, int index) {
        Course course = null;
        course = session.get(Course.class, index);
        session.close();
        return course;
    }

    /**
     * Читает из БД все записи
     * @param session открытая сессия
     * @return Список курсов
     */
    private static List<Course> getAll(Session session) {
        List<Course> courses = session
                .createQuery("FROM Course", Course.class)
                .getResultList();

        session.close();
        return courses;
    }

    /**
     * Вставляет информацию о новом курсе в БД
     * @param session Открытая сессия
     * @param course Новый курс
     */
    private static void insertCourse(Session session, Course course) {

        session.beginTransaction();

        session.save(course);

        session.getTransaction().commit();

        session.close();
    }

    /**
     * Создаёт базу данных SchoolDB и в ней таблицу
     * Courses с полями id, title, duration
     */
    private static void createDB() throws SQLException {

        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "db@0208347022";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            statement.execute("DROP DATABASE IF EXISTS SchoolDB;");

            statement.execute("CREATE DATABASE SchoolDB;");

            statement.execute("USE SchoolDB;");

            statement.execute("CREATE TABLE Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);");

        }
    }

}
