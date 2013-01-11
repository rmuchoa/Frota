/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.VeiculoDao;
import com.model.entity.Veiculo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author renanmarceluchoa
 */
@ManagedBean
@RequestScoped
public class VeiculoController {
    
    @EJB
    private VeiculoDao dao;
    
    @ManagedProperty(name="id", value="#{param.id}")
    private Integer id;
    
    private Veiculo veiculo;
    private List<Veiculo> veiculos;
    
    public VeiculoController() {
        this.veiculo = new Veiculo();
    }
    
    public String salvar() {
        if(veiculo.getId() == null) {
            dao.inserir(veiculo);
            this.veiculos = dao.listar();
        } else {
            dao.atualizar(veiculo);
            this.veiculos = dao.listar();
        }
        return "listaVeiculo";
    }
    
    public String editar() {
        this.veiculo = dao.buscar(id);
        return "formulario";
    }
    
    public String deletar() {
        this.veiculo = dao.buscar(id);
        dao.remover(veiculo);
        this.veiculos = dao.listar();
        return "listaVeiculo";
    }
    
    @PostConstruct
    public void listar() {
        this.veiculos = dao.listar();
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the veiculos
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     * @param veiculos the veiculos to set
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
