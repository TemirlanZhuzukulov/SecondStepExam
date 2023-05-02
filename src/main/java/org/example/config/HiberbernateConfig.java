package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entity.Products;
import org.example.entity.Shop;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class HiberbernateConfig {
    public static EntityManager getEntityManager() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty(DRIVER, "org.postgresql.Driver");
            configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
            configuration.setProperty(USER, "postgres");
            configuration.setProperty(PASS, "postgres");
            configuration.setProperty(HBM2DDL_AUTO, "update");
            configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty(SHOW_SQL, "true");
            configuration.addAnnotatedClass(Shop.class);
            configuration.addAnnotatedClass(Products.class);
            return configuration.buildSessionFactory().createEntityManager();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
