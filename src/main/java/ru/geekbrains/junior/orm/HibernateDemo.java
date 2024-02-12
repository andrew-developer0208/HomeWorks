package ru.geekbrains.junior.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//
//        SessionFactory sessionFactory = new MetadataSources(registry)
//                .buildMetadata()
//                .buildSessionFactory();

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Magic.class)
                .buildSessionFactory();


        Session session = sessionFactory.openSession();



        session.beginTransaction();

//        Magic magic = new Magic("Волшебная стрела", 300, 1000);
//        session.save(magic);

        Magic magic = new Magic("Жажда крови", 100, 500);
        session.save(magic);

        magic = new Magic("Лечение", -30, 0);
        session.save(magic);

        session.getTransaction().commit();

        session.close();

    }
}
