package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static final String DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private static Connection connection = null;
    private static SessionFactory sessionFactory = null;

    private Util() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.URL, URL);
                properties.put(Environment.USER, USER);
                properties.put(Environment.PASS, PASSWORD);
                properties.put(Environment.DIALECT, DIALECT);
                properties.put(Environment.SHOW_SQL, "true");

                sessionFactory = configuration.setProperties(properties)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory(new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties()).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
