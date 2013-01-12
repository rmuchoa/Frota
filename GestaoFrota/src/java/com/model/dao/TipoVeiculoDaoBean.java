/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.TipoVeiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author renanmarceluchoa
 */
@Stateless
public class TipoVeiculoDaoBean implements TipoVeiculoDao {

    @PersistenceContext(unitName = "FrotaPU")
    private EntityManager em;
    
    @Override
    public List<TipoVeiculo> listar() {
        Query query = em.createNamedQuery("TipoVeiculo.findAll");
        return query.getResultList();
    }
    
}
