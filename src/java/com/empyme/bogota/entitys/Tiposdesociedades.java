/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "tiposdesociedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposdesociedades.findAll", query = "SELECT t FROM Tiposdesociedades t")
    , @NamedQuery(name = "Tiposdesociedades.findByCodigo", query = "SELECT t FROM Tiposdesociedades t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tiposdesociedades.findByTipoSociedad", query = "SELECT t FROM Tiposdesociedades t WHERE t.tipoSociedad = :tipoSociedad")})
public class Tiposdesociedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TipoSociedad")
    private String tipoSociedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaJuridica")
    private List<Empresas> empresasList;

    public Tiposdesociedades() {
    }

    public Tiposdesociedades(Integer codigo) {
        this.codigo = codigo;
    }

    public Tiposdesociedades(Integer codigo, String tipoSociedad) {
        this.codigo = codigo;
        this.tipoSociedad = tipoSociedad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoSociedad() {
        return tipoSociedad;
    }

    public void setTipoSociedad(String tipoSociedad) {
        this.tipoSociedad = tipoSociedad;
    }

    @XmlTransient
    public List<Empresas> getEmpresasList() {
        return empresasList;
    }

    public void setEmpresasList(List<Empresas> empresasList) {
        this.empresasList = empresasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposdesociedades)) {
            return false;
        }
        Tiposdesociedades other = (Tiposdesociedades) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Tiposdesociedades[ codigo=" + codigo + " ]";
    }
    
}
