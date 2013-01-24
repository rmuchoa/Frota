/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.TipoUsuario;
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
public class TipoUsuarioDaoBean implements TipoUsuarioDao {

    @PersistenceContext(unitName="FrotaPU")
    private EntityManager em;
    
    @Override
    public List<TipoUsuario> listar() {
        Query query = em.createNamedQuery("TipoUsuario.findAll");
        return query.getResultList();
    }

    @Override
    public TipoUsuario buscar(Integer id) {
        return em.find(TipoUsuario.class, id);
    }

    
    
}
