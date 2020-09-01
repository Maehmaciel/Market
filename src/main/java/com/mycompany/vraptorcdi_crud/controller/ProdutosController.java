/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.vraptorcdi_crud.model.Item;
import com.mycompany.vraptorcdi_crud.model.Produto;
import com.mycompany.vraptorcdi_crud.model.dao.ProdutoDao;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author banana
 */
@Controller
public class ProdutosController{

    @Inject
    ProdutoDao dao;
    @Inject
    Result result;
    @Inject
    Validator validator;
    
    @Path("/")
    public List<Produto> lista(){
        return dao.produtos();
    }

    public void form() {

    }
  
   
   public void salvar(Produto produto, Result result) {
        validator.validate(produto);
        validator.onErrorRedirectTo(ClientesController.class).form();
        
      
        dao.salvar(produto); 

       result.of(this).form();
    }
   
 


}