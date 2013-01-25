/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Estado;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface EstadoDao {
    
    public List<Estado> listar();
    
}
