/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.util;

/**
 *
 * @author maeh
 */
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * @Dependent: escopo dependente, ou seja, uma instância será criada para cada objeto que precisar dessa dependência.
 */
@Dependent
public class JpaUtil{

    @ApplicationScoped
    @Produces
    public EntityManagerFactory factory() {
        return Persistence.createEntityManagerFactory("market");
    }

    @Produces
    public EntityManager manager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManagerFactory factory) {
        factory.close();
    }

    public void close(@Disposes EntityManager manager) {
        manager.close();
    }

}