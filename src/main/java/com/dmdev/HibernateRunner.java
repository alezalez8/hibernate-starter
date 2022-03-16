package com.dmdev;

import com.dmdev.converter.BirthdayConverter;
import com.dmdev.entity.*;
import com.dmdev.type.JsonType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
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
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
           // System.out.println("OK");

            session.beginTransaction();
            User user = User.builder()
                    .username("gena45411@gmail.com")
                    .firstname("Gena")
                    .lastname("Genavov")
                    .info("""
                            {
                                "name": "Ivan",
                                "id": 25
                            }
                            """)
                    .birthDate(new Birthday(LocalDate.of(1998, 11, 14)))
                     .role(Role.ADMIN)
                    .build();
            session.save(user);
            session.getTransaction().commit();

/*
            session.beginTransaction();
            MyFamily family = MyFamily.builder()
                    .id("first")
                    .department("IT")
                    .position("Midle")
                    .hairDate(LocalDate.of(2022, 5, 10))
                    .sex(MaleFemale.MALE)
                    .build();
            session.save(family);
            session.getTransaction().commit();
*/


/*
            session.beginTransaction();
            user = User.builder()
                    .username("petr@gmail.com")
                    .firstname("Petr")
                    .lastname("Petrov")
                    .birthDate(LocalDate.of(1995, 5, 11))
                    .age(25)
                    .role(Role.USER)
                    .build();
            session.save(user);
            session.getTransaction().commit();
*/


        }


    }
}
