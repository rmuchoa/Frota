/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.TipoVeiculoDao;
import com.model.entity.TipoVeiculo;
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
public class TipoVeiculoController {
    
    @EJB
    private TipoVeiculoDao dao;
    
    private TipoVeiculo tipo;
    private List<TipoVeiculo> tipos;
    
    public TipoVeiculoController() {
        this.tipo = new TipoVeiculo();
    }
    
    
    
    @PostConstruct
    public void listar() {
        this.tipos = dao.listar();
    }

    /**
     * @return the tipo
     */
    public TipoVeiculo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tipos
     */
    public List<TipoVeiculo> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(List<TipoVeiculo> tipos) {
        this.tipos = tipos;
    }
    
}
