/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Cidade;
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
public class CidadeDaoBean implements CidadeDao {

    @PersistenceContext(unitName="FrotaPU")
    private EntityManager em;
    
    @Override
    public List<Cidade> listar() {
        Query query = em.createNamedQuery("Cidade.findAll");
        return query.getResultList();
    }

    
    
}
