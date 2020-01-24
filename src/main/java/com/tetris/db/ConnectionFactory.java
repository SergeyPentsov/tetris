package com.tetris.db;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


@Slf4j
public class ConnectionFactory {

    public final static SessionFactory sessionFactory;

    static {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }


    public void init() {
    }

}
