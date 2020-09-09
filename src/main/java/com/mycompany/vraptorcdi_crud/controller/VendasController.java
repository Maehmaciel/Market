/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptorcdi_crud.model.Cliente;
import com.mycompany.vraptorcdi_crud.model.Item;
import com.mycompany.vraptorcdi_crud.model.Produto;
import com.mycompany.vraptorcdi_crud.model.Venda;
import com.mycompany.vraptorcdi_crud.model.dao.ClienteDao;
import com.mycompany.vraptorcdi_crud.model.dao.ProdutoDao;
import com.mycompany.vraptorcdi_crud.model.dao.VendaDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author banana
 */
@Controller
public class VendasController {
  @Inject
    private VendaDao dao;
   @Inject
   private  Venda venda;
    @Inject
    private ProdutoDao produtoDao;
    @Inject
    private Result result;
       @Inject
    ClienteDao daoCliente;

    @Path("/add/{id}")
    public void addItem(long id) {
        
       if(venda.getData()==null){
           
           venda.setData(new Date());
         
            

       }
        Item item = new Item();
        item.setQtd(1);
        Produto produto = produtoDao.produto(id);
        item.setProduto(produto);
        venda.setItem(item);
      
        result.redirectTo(ProdutosController.class).lista();
        
    }
    
    public List<Venda> lista() {
       
       return dao.vendas();
        
    }
    

    

    
     @Path("/comprar/{comprador}")
    public void comprar(long comprador){
        Cliente c= daoCliente.buscarCliente(comprador);
        Venda v = new Venda();
        v.setData(venda.getData());
        v.setItens(venda.getItens());
        v.setCliente(c);
        dao.add(v);
      
        
//        c.setVenda(dao.venda(v.getId()));
//        daoCliente.update(c); 
         venda.getItens().clear();
      
       venda.setData(null);
       
        
     

        result.redirectTo(ClientesController.class).update();
    }
    @Path("/qtd/{item}/{qtd}")
    public void change(int item,double qtd) {
        venda.getItens().get(item).setQtd(qtd);
     
        result.redirectTo(ItensController.class).lista();
    }

    
     @Path("/itens/remove/{item}")
    public void remove(int item) {
        venda.getItens().remove(item);
     
        result.redirectTo(ItensController.class).lista();
    }
    
    
}

