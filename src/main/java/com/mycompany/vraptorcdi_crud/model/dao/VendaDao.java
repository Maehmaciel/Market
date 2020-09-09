/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.dao;


import com.mycompany.vraptorcdi_crud.model.Venda;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author maeh
 */
@Dependent   
public class VendaDao {
    @Inject
    EntityManager em;

    public void add(Venda venda){
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
    }

    public Venda venda(Long id){
        return em.find(Venda.class, id);
    }

      public List<Venda> vendas(){
        Query query = em.createQuery("from Venda");
        return query.getResultList();
    }

    
   
    public void remove(Venda venda){
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, venda.getId());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void update(Venda venda){
        em.getTransaction().begin();
        em.merge(venda);
        em.getTransaction().commit();
    }

}
