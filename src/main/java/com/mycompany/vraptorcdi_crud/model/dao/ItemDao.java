/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.dao;

import com.mycompany.vraptorcdi_crud.model.Item;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author maeh
 */
@Dependent   
public class ItemDao {
    @Inject
    EntityManager em;

    public void salvar(Item itemVenda){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(itemVenda);
        em.getTransaction().commit();
    }

    public Item item(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> itens(){
        Query query = em.createQuery("from Item");
        return query.getResultList();
    }

    public void remove(Item itemVenda){
        em.getTransaction().begin();
        Item v = em.find(Item.class, itemVenda.getId());
        em.remove(v);
        em.getTransaction().commit();
    }

    public void update(Item itemVenda){
        em.getTransaction().begin();
        em.merge(itemVenda);
        em.getTransaction().commit();
    }
}
