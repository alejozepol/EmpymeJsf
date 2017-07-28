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
@Table(name = "tipodoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodoc.findAll", query = "SELECT t FROM Tipodoc t")
    , @NamedQuery(name = "Tipodoc.findByCodTipo", query = "SELECT t FROM Tipodoc t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tipodoc.findByTipoDocumento", query = "SELECT t FROM Tipodoc t WHERE t.tipoDocumento = :tipoDocumento")})
public class Tipodoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodTipo")
    private Integer codTipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TipoDocumento")
    private String tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docTipo")
    private List<Representantes> representantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private List<Empresas> empresasList;

    public Tipodoc() {
    }

    public Tipodoc(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public Tipodoc(Integer codTipo, String tipoDocumento) {
        this.codTipo = codTipo;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public List<Representantes> getRepresentantesList() {
        return representantesList;
    }

    public void setRepresentantesList(List<Representantes> representantesList) {
        this.representantesList = representantesList;
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
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodoc)) {
            return false;
        }
        Tipodoc other = (Tipodoc) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Tipodoc[ codTipo=" + codTipo + " ]";
    }
    
}
