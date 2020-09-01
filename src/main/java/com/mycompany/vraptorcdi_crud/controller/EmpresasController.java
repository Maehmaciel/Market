/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.vraptorcdi_crud.model.Empresa;
import com.mycompany.vraptorcdi_crud.model.dao.ClienteDao;
import javax.inject.Inject;

/**
 *
 * @author banana
 */
@Controller
public class EmpresasController {
     @Inject
    ClienteDao dao;
     @Inject
    Validator validator;
     @Inject
    Result result;
    
    public void form() {

    }
     
    
     
     public void salvar(Empresa empresa) {
        validator.validate(empresa);
        validator.onErrorRedirectTo(ClientesController.class).form();
        empresa.setType(1);
        
        if (empresa.getId() == null) {
       
            dao.add(empresa);
            
          
        } else {
            dao.update(empresa);
        }

       result.of(ClientesController.class).login();
    }
}
