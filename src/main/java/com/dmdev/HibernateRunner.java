package com.dmdev;

import com.dmdev.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

       // DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_postgres_test", "postgres", "postgres");


        Configuration configuration = new Configuration();
       // configuration.addAnnotatedClass(User.class); // это маппинг
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
           // System.out.println("OK");

            session.beginTransaction();
            User user = User.builder()
                    .username("ivan@gmail.com")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .birthDate(LocalDate.of(2000, 1, 12))
                    .age(20)
                    .build();
            session.save(user);
            session.getTransaction().commit();
        }


    }
}
