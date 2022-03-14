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
       // configuration.addAnnotatedClass(User.class); // это маппинг на таблицу
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
           // System.out.println("OK");

            session.beginTransaction();
            User user = User.builder()
                    .username("gena@gmail.com")
                    .firstname("Gena")
                    .lastname("Genavov")
                    .birthDate(LocalDate.of(1998, 11, 14))
                    .age(22)
                    .build();
            session.save(user);
            session.getTransaction().commit();

            session.beginTransaction();
            user = User.builder()
                    .username("petr@gmail.com")
                    .firstname("Petr")
                    .lastname("Petrov")
                    .birthDate(LocalDate.of(1995, 5, 11))
                    .age(25)
                    .build();
            session.save(user);
            session.getTransaction().commit();


        }





    }
}
