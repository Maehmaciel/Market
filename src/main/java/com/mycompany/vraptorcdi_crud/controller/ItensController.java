/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.mycompany.vraptorcdi_crud.model.Item;
import com.mycompany.vraptorcdi_crud.model.dao.ItemDao;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author banana
 */
@Controller
public class ItensController{

    @Inject
    ItemDao dao;
    @Inject
    Result result;

    public void lista(){
        
    }
    
      @Path("/item/delete/{id}")
    public void delete(long id, Result result) {
        Item item = dao.item(id);
        dao.remove(item);

        result.redirectTo(this).lista();
    }
    
       
  
  

    
   
   
 
 


}