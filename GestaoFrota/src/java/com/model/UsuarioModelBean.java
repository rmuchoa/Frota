/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.CidadeDao;
import com.model.dao.TipoUsuarioDao;
import com.model.dao.UsuarioDao;
import com.model.entity.Cidade;
import com.model.entity.TipoUsuario;
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
    
    @EJB
    private TipoUsuarioDao tipoUsuario;
    @EJB
    private CidadeDao cidade;
    
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

    @Override
    public TipoUsuario buscarTipoUsuario(Integer id) {
        return tipoUsuario.buscar(id);
    }

    @Override
    public List<TipoUsuario> listarTiposUsuario() {
        return tipoUsuario.listar();
    }

    @Override
    public Cidade buscarCidade(Integer id) {
        return cidade.buscar(id);
    }

    @Override
    public List<Cidade> listarCidades() {
        return cidade.listar();
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
