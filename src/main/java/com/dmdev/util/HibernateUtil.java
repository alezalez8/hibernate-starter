package com.dmdev.util;


import com.dmdev.converter.BirthdayConverter;
import com.dmdev.entity.User;
import com.vladmihalcea.hibernate.naming.CamelCaseToSnakeCaseNamingStrategy;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass // private constructor and final class
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToSnakeCaseNamingStrategy());
        configuration.addAnnotatedClass(User.class); // это маппинг на таблицу
        configuration.addAttributeConverter(new BirthdayConverter());
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.configure();

        return configuration.buildSessionFactory();
    }
}
