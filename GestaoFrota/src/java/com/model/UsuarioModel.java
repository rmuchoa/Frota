/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.entity.Cidade;
import com.model.entity.Estado;
import com.model.entity.TipoUsuario;
import com.model.entity.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface UsuarioModel {
    
    public void salvar(Usuario usuario);
    public void remover(Usuario usuario);
    public Usuario remover(Integer id);
    public Usuario buscar(Integer id);
    public List<Usuario> listar();
    
}
