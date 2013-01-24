/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.UsuarioModel;
import com.model.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author renanmarceluchoa
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private UsuarioModel model;
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    private static Logger logger = Logger.getLogger(UsuarioController.class.getName());  
    private Boolean skip;
    
    public UsuarioController() {
        
    }
    
    @PostConstruct
    public void init() {
        this.usuarios = model.listar();
        System.out.println(usuarios.size());
    }
    
    public String cadastrar() {
        this.usuario = new Usuario();
        this.usuario.setCidade(model.buscarCidade(new Integer(1)));
        this.usuario.setTipoUsuario(model.buscarTipoUsuario(new Integer(1)));
        return "formulario";
    }
    
    public String editar() {
        return "formulario";
    }
    
    public String salvar() {
        this.model.salvar(usuario);
        this.usuarios = model.listar();
        FacesMessage msg = new FacesMessage("Successful", "Usuario "+usuario.getNome()+" "+model.getStatus()+" com sucesso!");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        return "listaUsuario";
    }
    
    public String remover() {
        this.usuario = model.buscar(usuario.getId());
        this.model.remover(usuario);
        this.usuarios = model.listar();
        return "listaUsuario";
    }
    
    public void save(ActionEvent actionEvent) {  
        this.model.salvar(usuario);
        this.usuarios = model.listar();
        FacesMessage msg = new FacesMessage("Successful", "Usuario " + usuario.getNome() + " registrado com sucesso!");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public String onFlowProcess(FlowEvent event) {  
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
          
        if(skip) {  
            skip = false;
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
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
     * @return the skip
     */
    public Boolean getSkip() {
        return skip;
    }

    /**
     * @param skip the skip to set
     */
    public void setSkip(Boolean skip) {
        this.skip = skip;
    }
    
}
