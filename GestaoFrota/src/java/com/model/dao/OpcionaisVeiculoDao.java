/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.OpcionaisVeiculo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface OpcionaisVeiculoDao {
    
    public List<OpcionaisVeiculo> listar();
    
}
