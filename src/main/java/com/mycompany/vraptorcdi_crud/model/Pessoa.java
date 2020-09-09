/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vraptorcdi_crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.validation.constraints.NotNull;
/**
 *
 * @author banana
 */
@Entity
@DiscriminatorValue("F")
public class Pessoa extends Cliente {
    @NotNull(message = "{obrigatorio}")
     private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
