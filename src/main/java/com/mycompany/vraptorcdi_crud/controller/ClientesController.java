/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.controller;

/**
 *
 * @author maeh
 */

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import com.mycompany.vraptorcdi_crud.model.Cliente;
import com.mycompany.vraptorcdi_crud.model.dao.ClienteDao;
import java.util.List;
import javax.inject.Inject;
import br.com.caelum.vraptor.validator.Validator;
import com.mycompany.vraptorcdi_crud.model.Empresa;
import com.mycompany.vraptorcdi_crud.model.Pessoa;
import javax.persistence.NoResultException;


@Controller
public class ClientesController{

    @Inject
    ClienteDao dao;
    
    @Inject
    Cliente logado;
    @Inject
    Validator validator;
    
    @Inject
    Result result;
     

   
    public List<Cliente> lista(){
        return dao.clientes();
    }
    
    @Path("/cadastro")
    public void form() {

    }
    
    @Path("/login")
    public void login() {

    }
    @Path("/delete/{id}")
    public void delete(long id, Result result) {
        dao.excluir(id);

        result.redirectTo(this).lista();
    }
   
    public void update() {
        Cliente c = dao.buscarCliente(logado.getId());
        logado.setEmail(c.getEmail());
        logado.setNome(c.getNome());
        logado.setAcesso(c.getAcesso());
        logado.setVendas(c.getVendas());
        result.of(VendasController.class).lista();

    }
    
     @Path("/logout")
    public void sair() {
       this.logado.setEmail(null);
       this.logado.setNome(null);
       result.redirectTo(this).login();
    }
    
 
    
   
    public void logar(Cliente cliente) {
        validator.validate(cliente);
        validator.onErrorRedirectTo(this).login();
        try{
            Cliente c= dao.login(cliente.getEmail(), cliente.getSenha());
        logado.setId(c.getId());
        logado.setEmail(c.getEmail());
        logado.setNome(c.getNome());
        logado.setAcesso(c.getAcesso());
        logado.setVendas(c.getVendas());
        }
        catch (NoResultException e){
            validator.add(new SimpleMessage("login", "Email ou senha Incorretos"));
            validator.onErrorRedirectTo(this).login();
        }
        
        
        
        
        result.redirectTo(ProdutosController.class).lista();
//        insert into cliente (acesso,email,nome,senha,tipo) values (2,'admin@gmail.com','admin','admin','Cliente')

        
    }

    public void admin() {
       result.redirectTo(ProdutosController.class).form();
    }
   
 
 


}