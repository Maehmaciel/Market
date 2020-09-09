/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.vraptorcdi_crud.model.Cliente;
import com.mycompany.vraptorcdi_crud.model.Pessoa;
import com.mycompany.vraptorcdi_crud.model.dao.ClienteDao;
import javax.inject.Inject;

/**
 *
 * @author banana
 */
@Controller
public class PessoasController {
    @Inject
    ClienteDao dao;
     @Inject
    Validator validator;
    
    
    public void form() {

    }
     
    
     
     public void salvar(Pessoa pessoa, Result result) {
        validator.validate(pessoa);
        validator.onErrorRedirectTo(ClientesController.class).form();
        pessoa.setType(1);
         if(dao.existeUsuario(pessoa.getEmail())){
      validator.add(new SimpleMessage("Email", "Ja cadastrado"));
            validator.onErrorRedirectTo(ClientesController.class).form();
      }else{
        if (pessoa.getId() == null) {
       
            dao.add(pessoa);
           
          
        } else {
            dao.update(pessoa);
        }

       result.of(ClientesController.class).login();
    }
     }
}
