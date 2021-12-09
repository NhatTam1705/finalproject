/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.core.common.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Properties;

import com.project.core.persistence.entity.*;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
/**
 *
 * @author 19110
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static StandardServiceRegistry registry;
    // private static final SessionFactory sessionFactory = buildSessionFactory();
    // private static SessionFactory buildSessionFactory() {
    //     try {
    //         //create sessionfactory from hibernate.cfg.xml 
    //         return new Configuration().configure().buildSessionFactory();
    //     } catch (Throwable e) {
    //         System.out.println("Initial session factory fail");
    //         throw new ExceptionInInitializerError(e);
    //     }        
    // }
    
    // public static SessionFactory getSessionFactory() {
    //     return  sessionFactory;
    // }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_d598f10d747228b?autoReconnect=true");
                settings.put(Environment.USER, "bc11b4d93b8d9b");   
                settings.put(Environment.PASS, "14c4bd20");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                // settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(UsersEntity.class);
                configuration.addAnnotatedClass(RolesEntity.class);
                configuration.addAnnotatedClass(DiscountEntity.class);
                configuration.addAnnotatedClass(ManuFacterEntity.class);
                configuration.addAnnotatedClass(OrderDetailsEntity.class);
                configuration.addAnnotatedClass(OrderItemsEntity.class);
                configuration.addAnnotatedClass(ProductEntity.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}
