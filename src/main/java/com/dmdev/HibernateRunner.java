package com.dmdev;

import com.dmdev.entity.User;
import com.dmdev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
        User user = User.builder()
                .username("gena1@gmail.com")
                .lastname("Ivanov")
                .firstname("Ivan")
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();


                session1.saveOrUpdate(user);



                session1.getTransaction().commit();
            }
            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();
                session2.delete(user);


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
