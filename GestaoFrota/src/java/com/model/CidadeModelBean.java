/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.dao.CidadeDao;
import com.model.entity.Cidade;
import com.model.entity.Estado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author renanmarceluchoa
 */
@Stateless
public class CidadeModelBean implements CidadeModel {

    @EJB
    private CidadeDao dao;

    @Override
    public Cidade buscar(Integer id) {
        return dao.buscar(id);
    }

    @Override
    public List<Cidade> listar() {
        return dao.listar();
    }

    @Override
    public List<Cidade> listarByEstado(Estado estado) {
        return dao.buscarByEstado(estado);
    }
    
}
