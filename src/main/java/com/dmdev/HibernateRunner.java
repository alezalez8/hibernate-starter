package com.dmdev;

import com.dmdev.entity.User;
import com.dmdev.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;

@Slf4j
public class HibernateRunner {
   // private static Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) throws SQLException {
        User user = User.builder()
                .username("gena341@gmail.com")
                .lastname("Ivanov")
                .firstname("Ivan")
                .build();

        log.info("User entity is in transient state, object: {}", user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();
               // session1.beginTransaction();
                log.trace("Transaction is created, {}", transaction);

                session1.saveOrUpdate(user);
                log.trace("User is in persistent state: {}, session {}", user, session1);

                session1.getTransaction().commit();

            }
            log.warn("User is detached state: {}, session is closed {}", user, session1);
        } catch (Exception exception) {
            log.error("Exeption occured", exception);
            throw exception;
        }
/*
            try (Session session2 = sessionFactory.openSession()) {
                session2.beginTransaction();
                session2.delete(user);


                session2.getTransaction().commit();
            }
*/


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
