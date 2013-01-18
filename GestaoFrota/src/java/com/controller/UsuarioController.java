/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.UsuarioModel;
import com.model.UsuarioModelBean;
import com.model.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author renanmarceluchoa
 */
@ManagedBean
@RequestScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private UsuarioModel model;
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    private static Logger logger = Logger.getLogger(UsuarioController.class.getName());
    
    @ManagedProperty(name="id", value="#{param.id}")
    private Integer id;
    
    public UsuarioController() {
        this.usuario = new Usuario();
    }
    
    public String salvar() {
        this.model.salvar(usuario);
        this.usuarios = model.listar();
        this.addMessage("O usuário "+usuario.getNome()+" foi "+model.getStatus()+"com sucesso!");
        return "listaUsuario";
    }
    
    public String editar() {
        this.usuario = model.buscar(id);
        return "formulario";
    }
    
    public String deletar() {
        this.usuario = model.remover(id);
        this.usuarios = model.listar();
        this.addMessage("O usuário "+usuario.getNome()+" foi "+model.getStatus()+" com sucesso!");
        return "listaUsuario";
    }
    
    @PostConstruct
    public void listar() {
        this.usuarios = model.listar();
    }
    
    public String onFlowProcess(FlowEvent event) {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());  
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        return event.getNewStep();
    }
    
    public void addMessage(String message) {
        FacesMessage msg = new FacesMessage("Successful", message);  
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
