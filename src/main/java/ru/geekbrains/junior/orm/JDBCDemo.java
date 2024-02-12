package ru.geekbrains.junior.orm;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "db@0208347022";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement = connection.createStatement();

            statement.execute("DROP SCHEMA `test` ;");
            statement.execute("CREATE SCHEMA `test` ;");

            statement.execute("CREATE TABLE `test`.`table` (`id` INT NOT NULL,`firstname` VARCHAR(45) NULL, `lastname` VARCHAR(45) NULL, PRIMARY KEY (`id`));");
            statement.execute("CREATE TABLE `test`.`magic` (`id` INT NOT NULL,`название` VARCHAR(45) NULL, `повреждение` INT NULL, `атака` INT NULL, PRIMARY KEY (`id`));");

            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`) VALUES (1,'Иванов','Иван');");

            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`) VALUES (2,'Петров','Пётр');");

            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");

            while (set.next()) {
                System.out.printf("%s %s %s\n", set.getString(3), set.getString(2), set.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static Connection getConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
