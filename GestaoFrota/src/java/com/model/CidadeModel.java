/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.model.entity.Cidade;
import com.model.entity.Estado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface CidadeModel {
    
    public Cidade buscar(Integer id);
    public List<Cidade> listar();
    public List<Cidade> listarByEstado(Estado estado);
    
}
