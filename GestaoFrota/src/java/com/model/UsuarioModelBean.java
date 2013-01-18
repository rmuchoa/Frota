/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.UsuarioDao;
import com.model.entity.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author renanmarceluchoa
 */
@Stateful
public class UsuarioModelBean implements UsuarioModel {
    
    @EJB
    private UsuarioDao dao;
    private String status;
    
    public UsuarioModelBean() {
        
    }
    
    @Override
    public void salvar(Usuario usuario) {
        if(usuario.getId() == null) {
            dao.inserir(usuario);
            setStatus("cadastrado");
        } else {
            dao.atualizar(usuario);
            setStatus("atualizado");
        }
    }
    
    @Override
    public void remover(Usuario usuario) {
        dao.remover(usuario);
        setStatus("removido");
    }
    
    @Override
    public Usuario remover(Integer id) {
        Usuario usuario = dao.buscar(id);
        dao.remover(usuario);
        setStatus("removido");
        return usuario;
    }
    
    @Override
    public Usuario buscar(Integer id) {
        return dao.buscar(id);
    }
    
    @Override
    public List<Usuario> listar() {
        return dao.listar();
    }

    /**
     * @return the status
     */
    @Override
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    @Override
    public void setStatus(String status) {
        this.status = status;
    }
    
}
