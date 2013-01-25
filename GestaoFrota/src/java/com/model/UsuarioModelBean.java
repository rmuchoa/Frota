/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.UsuarioDao;
import com.model.entity.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author renanmarceluchoa
 */
@Stateless
public class UsuarioModelBean implements UsuarioModel {
    
    @EJB
    private UsuarioDao dao;
    
    public UsuarioModelBean() {
        
    }
    
    @Override
    public void salvar(Usuario usuario) {
        if(usuario.getId() == null) {
            dao.inserir(usuario);
        } else {
            dao.atualizar(usuario);
        }
    }
    
    @Override
    public void remover(Usuario usuario) {
        dao.remover(usuario);
    }
    
    @Override
    public Usuario remover(Integer id) {
        Usuario usuario = dao.buscar(id);
        dao.remover(usuario);
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
    
}
