/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.EstadoDao;
import com.model.entity.Estado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author renanmarceluchoa
 */
@Stateless
public class EstadoModelBean implements EstadoModel {

    @EJB
    private EstadoDao dao;
    
    @Override
    public Estado buscar(Integer id) {
        return dao.buscar(id);
    }

    @Override
    public List<Estado> listar() {
        return dao.listar();
    }

    
    
}
