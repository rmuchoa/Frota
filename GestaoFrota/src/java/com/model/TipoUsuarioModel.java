/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.entity.TipoUsuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface TipoUsuarioModel {
    
    public TipoUsuario buscar(Integer id);
    public List<TipoUsuario> listar();
    
}
