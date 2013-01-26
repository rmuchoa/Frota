/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.CidadeModel;
import com.model.EstadoModel;
import com.model.TipoUsuarioModel;
import com.model.UsuarioModel;
import com.model.entity.Cidade;
import com.model.entity.Estado;
import com.model.entity.TipoUsuario;
import com.model.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
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
    @EJB
    private TipoUsuarioModel tipo;
    @EJB
    private CidadeModel cidade;
    @EJB
    private EstadoModel estado;
    
    private Usuario usuario;
    private Usuario selectedUsuario;
    private String filtroNome;
    private List<Usuario> usuarios;
    
    private List<TipoUsuario> tipos;
    private List<Cidade> cidades;
    private List<Estado> estados;
    
    private Estado selectedEstado;
    
    private static Logger logger = Logger.getLogger(UsuarioController.class.getName());  
    private Boolean skip;
    
    public UsuarioController() {
        
    }
    
    @PostConstruct
    public void init() {
        this.usuarios = model.listar();
        this.tipos = tipo.listar();
        this.cidades = new ArrayList<Cidade>();
        this.estados = estado.listar();
    }
    
    public String add() {
        this.usuario = new Usuario();
        return "formulario";
    }
    
    public String edit() {
        this.usuario = selectedUsuario;
        return "formulario";
    }
    
    public String view() {
        this.usuario = selectedUsuario;
        return "viewUsuario";
    }
    
    public String save() {
        this.model.salvar(usuario);
        this.usuarios = model.listar();
        FacesMessage msg = new FacesMessage("Successful", "Usuario "+usuario.getNome()+" registrado com sucesso!");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        return "listaUsuario";
    }
    
    public String remove() {
        this.model.remover(selectedUsuario);
        this.usuarios = model.listar();
        return "listaUsuario";
    }
    
    public String filtrar() {
        this.usuarios = model.listar();
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        for (int i=0; i<usuarios.size(); i++) {
            if (usuarios.get(i).getNome().contains(filtroNome)) {
                list.add(usuarios.get(i));
            }
        }
        this.usuarios = list;
        return "listaUsuario";
    }
    
    public void updateCities(AjaxBehaviorEvent event) {
        if (selectedEstado != null) {
            cidades = cidade.listarByEstado(selectedEstado);
        } else {
            cidades = new ArrayList<Cidade>();
        }
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
     * @return the selectedUsuario
     */
    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    /**
     * @param selectedUsuario the selectedUsuario to set
     */
    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    /**
     * @return the filtroNome
     */
    public String getFiltroNome() {
        return filtroNome;
    }

    /**
     * @param filtroNome the filtroNome to set
     */
    public void setFiltroNome(String filtroNome) {
        this.filtroNome = filtroNome;
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
     * @return the tipos
     */
    public List<TipoUsuario> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(List<TipoUsuario> tipos) {
        this.tipos = tipos;
    }

    /**
     * @return the cidades
     */
    public List<Cidade> getCidades() {
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    /**
     * @return the estados
     */
    public List<Estado> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    /**
     * @return the selectedEstado
     */
    public Estado getSelectedEstado() {
        return selectedEstado;
    }

    /**
     * @param selectedEstado the selectedEstado to set
     */
    public void setSelectedEstado(Estado selectedEstado) {
        this.selectedEstado = selectedEstado;
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
