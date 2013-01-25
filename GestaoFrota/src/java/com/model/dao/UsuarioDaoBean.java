/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;


import com.model.entity.Usuario;
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
public class UsuarioDaoBean implements UsuarioDao {

    @PersistenceContext(unitName="FrotaPU")
    private EntityManager em;
    
    @Override
    public void inserir(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        em.remove(usuario);
    }

    @Override
    public Usuario buscar(Integer id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> listar() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
    
}
