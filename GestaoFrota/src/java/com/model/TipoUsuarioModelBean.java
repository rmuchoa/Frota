/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.TipoUsuarioDao;
import com.model.entity.TipoUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author renanmarceluchoa
 */
@Stateless
public class TipoUsuarioModelBean implements TipoUsuarioModel {

    @EJB
    private TipoUsuarioDao dao;
    
    @Override
    public TipoUsuario buscar(Integer id) {
        return dao.buscar(id);
    }

    @Override
    public List<TipoUsuario> listar() {
        return dao.listar();
    }
    
}
