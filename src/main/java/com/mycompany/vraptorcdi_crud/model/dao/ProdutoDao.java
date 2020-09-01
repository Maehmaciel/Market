/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.dao;

import com.mycompany.vraptorcdi_crud.model.Produto;
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
public class ProdutoDao {
    @Inject
    EntityManager em;
    
    
    public void salvar(Produto produto){
        //inicia a transação
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public Produto produto(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> produtos(){
        Query query = em.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(Produto produto){
        em.getTransaction().begin();
        Produto p = em.find(Produto.class, produto.getId());
        em.remove(p);
        em.getTransaction().commit();
    }

    public void update(Produto produto){
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }


}
