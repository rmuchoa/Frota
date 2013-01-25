/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Estado;
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
public class EstadoDaoBean implements EstadoDao {

    @PersistenceContext(unitName="FrotaPU")
    private EntityManager em;

    @Override
    public Estado buscar(Integer id) {
        return em.find(Estado.class, id);
    }
    
    @Override
    public List<Estado> listar() {
        Query query = em.createNamedQuery("Estado.findAll");
        return query.getResultList();
    }

    
    
}
