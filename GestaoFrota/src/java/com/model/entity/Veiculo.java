/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author renanmarceluchoa
 */
@Entity
@Table(name = "veiculo")
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findById", query = "SELECT v FROM Veiculo v WHERE v.id = :id"),
    @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Veiculo.findByRenavam", query = "SELECT v FROM Veiculo v WHERE v.renavam = :renavam"),
    @NamedQuery(name = "Veiculo.findByMarca", query = "SELECT v FROM Veiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Veiculo.findByCor", query = "SELECT v FROM Veiculo v WHERE v.cor = :cor"),
    @NamedQuery(name = "Veiculo.findByAno", query = "SELECT v FROM Veiculo v WHERE v.ano = :ano"),
    @NamedQuery(name = "Veiculo.findByCapacidadePassageiros", query = "SELECT v FROM Veiculo v WHERE v.capacidadePassageiros = :capacidadePassageiros"),
    @NamedQuery(name = "Veiculo.findByCapacidadeCarga", query = "SELECT v FROM Veiculo v WHERE v.capacidadeCarga = :capacidadeCarga")})
public class Veiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String placa;
    private String renavam;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;
    private int capacidadePassageiros;
    private int capacidadeCarga;
    private List<OpcionaisVeiculo> opcionaisVeiculo;
    private TipoVeiculo tipoVeiculo;

    public Veiculo() {
    }

    public Veiculo(Integer id) {
        this.id = id;
    }

    public Veiculo(Integer id, String placa, String renavam, String marca, String modelo, String cor, String ano, int capacidadePassageiros, int capacidadeCarga) {
        this.id = id;
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.capacidadeCarga = capacidadeCarga;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "placa")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "renavam")
    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cor")
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano")
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @NotNull
    @Column(name = "capacidade_passageiros")
    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    @NotNull
    @Column(name = "capacidade_carga")
    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @ManyToMany()
    @JoinTable(name="veiculo_opcionais_veiculo",
             joinColumns={@JoinColumn(name = "id_veiculo")},
             inverseJoinColumns={@JoinColumn(name = "id_opcionais_veiculo")})
    public List<OpcionaisVeiculo> getOpcionaisVeiculo() {
        return opcionaisVeiculo;
    }

    public void setOpcionaisVeiculo(List<OpcionaisVeiculo> opcionaisVeiculo) {
        this.opcionaisVeiculo = opcionaisVeiculo;
    }

    @JoinColumn(name = "tipo_veiculo", referencedColumnName = "id")
    @ManyToOne
    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
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
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.entity.Veiculo[ id=" + id + " ]";
    }
    
}
