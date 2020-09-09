/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 * @author maeh
 */

@SessionScoped
@Named("logado")
@Entity

@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")

public class Cliente implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @NotNull(message = "{obrigatorio}")
    private String email;
    @NotNull(message = "{obrigatorio}")
    private String senha;
    private int acesso;
     @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cliente")
      
     @Fetch(FetchMode.JOIN)
      private List<Venda> vendas;
      public List<Venda> getVendas() {
        return vendas;
    }
      

    public void setVendas(List<Venda> vendas) {
        this.vendas= new ArrayList();
        this.vendas = vendas;
    }
    
    public void setVenda(Venda venda) {
        this.vendas.add(venda);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public void setType(int acesso) {
        this.acesso = acesso;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    

    
}
