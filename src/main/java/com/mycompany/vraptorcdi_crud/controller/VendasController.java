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
import com.mycompany.vraptorcdi_crud.model.dao.ProdutoDao;
import com.mycompany.vraptorcdi_crud.model.dao.VendaDao;
import java.util.Date;
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

    @Path("/add/{id}")
    public void addItem(long id) {
       
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
    

    
    @Path("/newVenda/{id}")
    public void newVenda(long id){
        venda.setData(new Date());
        addItem(id);
    }
    
     @Path("/comprar")
    public void comprar(){
        Venda v = new Venda();
        v.setData(venda.getData());
        v.setItens(venda.getItens());
        dao.add(v);

        result.redirectTo(ProdutosController.class).lista();
    }
    @Path("/qtd/{item}/{qtd}")
    public void change(int item,double qtd) {
        venda.getItens().get(item).setQtd(qtd);
     
        result.redirectTo(ItensController.class).lista();
    }

    
    
}

