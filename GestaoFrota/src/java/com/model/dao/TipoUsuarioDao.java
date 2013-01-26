/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.TipoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author renanmarceluchoa
 */
@Local
public interface TipoUsuarioDao {
    
    public TipoUsuario buscar(Integer id);
    public List<TipoUsuario> listar();
    
}
