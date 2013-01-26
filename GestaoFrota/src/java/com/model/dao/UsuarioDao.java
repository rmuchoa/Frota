/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author renanmarceluchoa
 */
@Local
public interface UsuarioDao {
    
    public void inserir(Usuario usuario);
    public void atualizar(Usuario usuario);
    public void remover(Usuario usuario);
    public Usuario buscar(Integer id);
    public List<Usuario> listar();
    
}
