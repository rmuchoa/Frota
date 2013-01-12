/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.OpcionaisVeiculoDao;
import com.model.entity.OpcionaisVeiculo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author renanmarceluchoa
 */
@ManagedBean
@RequestScoped
public class OpcionaisVeiculoController {
    
    @EJB
    private OpcionaisVeiculoDao dao;
    
    private OpcionaisVeiculo opcional;
    private List<OpcionaisVeiculo> opcionais;
    
    public OpcionaisVeiculoController() {
        this.opcional = new OpcionaisVeiculo();
    }
    
    @PostConstruct
    public void listar() {
        this.opcionais = dao.listar();
    }

    /**
     * @return the opcional
     */
    public OpcionaisVeiculo getOpcional() {
        return opcional;
    }

    /**
     * @param opcional the opcional to set
     */
    public void setOpcional(OpcionaisVeiculo opcional) {
        this.opcional = opcional;
    }

    /**
     * @return the opcionais
     */
    public List<OpcionaisVeiculo> getOpcionais() {
        return opcionais;
    }

    /**
     * @param opcionais the opcionais to set
     */
    public void setOpcionais(List<OpcionaisVeiculo> opcionais) {
        this.opcionais = opcionais;
    }
    
    
    
}
