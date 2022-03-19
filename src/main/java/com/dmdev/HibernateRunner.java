package com.dmdev;

import com.dmdev.converter.BirthdayConverter;
import com.dmdev.entity.*;
import com.dmdev.type.JsonType;
import com.vladmihalcea.hibernate.naming.CamelCaseToSnakeCaseNamingStrategy;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToSnakeCaseNamingStrategy());
        configuration.addAnnotatedClass(User.class); // это маппинг на таблицу
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();


                session1.getTransaction().commit();
            }
            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();


                session2.getTransaction().commit();
            }


/*
            session.beginTransaction();
            User user = User.builder()
                    .username("gena4565241@gmail.com")
                    .firstname("Ge6na")
                    .lastname("Gen5avov")
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
            User user1 = session.get(User.class, "gena4565241@gmail.com");
            user1.setFirstname("Iva3n2");
              session.flush();
            System.out.println(session.isDirty());


            session.getTransaction().commit();
*/


        }

    }
}
