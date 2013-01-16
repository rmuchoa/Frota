/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author renanmarceluchoa
 */
@Entity
@Table(name = "tipoveiculo")
@NamedQueries({
    @NamedQuery(name = "TipoVeiculo.findAll", query = "SELECT t FROM TipoVeiculo t"),
    @NamedQuery(name = "TipoVeiculo.findById", query = "SELECT t FROM TipoVeiculo t WHERE t.id = :id"),
    @NamedQuery(name = "TipoVeiculo.findByDescricao", query = "SELECT t FROM TipoVeiculo t WHERE t.descricao = :descricao")})
public class TipoVeiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String descricao;

    public TipoVeiculo() {
    }

    public TipoVeiculo(Integer id) {
        this.id = id;
    }

    public TipoVeiculo(Integer id, String descricao) {
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
    @Column(name = "descricaotipoveiculo")
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
        if (!(object instanceof TipoVeiculo)) {
            return false;
        }
        TipoVeiculo other = (TipoVeiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entity.TipoVeiculo[ id=" + id + " ]";
    }
    
}
