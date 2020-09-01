/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model.dao;

/**
 *
 * @author maeh
 */
import com.mycompany.vraptorcdi_crud.model.Cliente;
import com.mycompany.vraptorcdi_crud.model.Pessoa;
import com.mycompany.vraptorcdi_crud.model.Empresa;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

@Dependent
public class ClienteDao {
    


    @Inject
    EntityManager manager;

    public List<Cliente> clientes() {
        Query query = manager.createQuery("from Cliente");
        return query.getResultList();
    }
     public void excluir(long id) {
          Cliente cliente = manager.find(Cliente.class, id);

  manager.getTransaction().begin();
  manager.remove(cliente);
  manager.getTransaction().commit();
      
        
    }
     
   
  public void add(Cliente cliente) {
            manager.getTransaction().begin();  
            manager.persist(cliente);       
  
manager.getTransaction().commit();  
          
         
         
    }
             public void update(Cliente cliente) {
                   manager.getTransaction().begin();
manager.merge(cliente);
manager.getTransaction().commit();
        
    }
             
             public Cliente buscarCliente(long id) {
             Query query = manager.createQuery("SELECT p FROM Cliente p where p.id =:id");
        query.setParameter("id", id);
        return (Cliente) query.getSingleResult();
    }
             
                          public Cliente login(String email,String senha) {
             Query query = manager.createQuery("SELECT c FROM Cliente c where  c.email =:email AND c.senha=:senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        query.setMaxResults(1);
        //insert into cliente values ('Cliente',2,2,'b','b','b',null,null);
        return (Cliente) query.getSingleResult();
       
    }
}