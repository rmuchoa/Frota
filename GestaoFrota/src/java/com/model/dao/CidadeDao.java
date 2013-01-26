/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Cidade;
import com.model.entity.Estado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author renanmarceluchoa
 */
@Local
public interface CidadeDao {
    
    public Cidade buscar(Integer id);
    public List<Cidade> listar();
    public List<Cidade> buscarByEstado(Estado estado);
    
}
