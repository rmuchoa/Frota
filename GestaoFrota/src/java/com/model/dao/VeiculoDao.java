/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.entity.Veiculo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author renanmarceluchoa
 */
@Remote
public interface VeiculoDao {
    
    public void inserir(Veiculo veiculo);
    public void atualizar(Veiculo veiculo);
    public void remover(Veiculo veiculo);
    public Veiculo buscar(Integer id);
    public List<Veiculo> buscarPorModelo(String modelo);
    public List<Veiculo> listar();
    
}
