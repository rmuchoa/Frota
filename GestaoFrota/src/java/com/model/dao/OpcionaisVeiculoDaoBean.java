/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.OpcionaisVeiculo;
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
public class OpcionaisVeiculoDaoBean implements OpcionaisVeiculoDao {

    @PersistenceContext(unitName = "FrotaPU")
    private EntityManager em;
    
    @Override
    public List<OpcionaisVeiculo> listar() {
        Query query = em.createNamedQuery("OpcionaisVeiculo.findAll");
        return query.getResultList();
    }

    
    
}
