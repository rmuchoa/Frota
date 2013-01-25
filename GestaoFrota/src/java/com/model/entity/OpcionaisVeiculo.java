/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author renanmarceluchoa
 */
@Entity
@Table(name = "opcionais_veiculo")
@NamedQueries({
    @NamedQuery(name = "OpcionaisVeiculo.findAll", query = "SELECT o FROM OpcionaisVeiculo o"),
    @NamedQuery(name = "OpcionaisVeiculo.findById", query = "SELECT o FROM OpcionaisVeiculo o WHERE o.id = :id"),
    @NamedQuery(name = "OpcionaisVeiculo.findByDescricao", query = "SELECT o FROM OpcionaisVeiculo o WHERE o.descricao = :descricao")})
public class OpcionaisVeiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String descricao;

    public OpcionaisVeiculo() {
    }

    public OpcionaisVeiculo(Integer id) {
        this.id = id;
    }

    public OpcionaisVeiculo(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionaisVeiculo)) {
            return false;
        }
        OpcionaisVeiculo other = (OpcionaisVeiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entity.OpcionaisVeiculo[ id=" + id + " ]";
    }
    
}
