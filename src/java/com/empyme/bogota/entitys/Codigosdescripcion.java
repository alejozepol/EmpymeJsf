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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "codigosdescripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigosdescripcion.findAll", query = "SELECT c FROM Codigosdescripcion c")
    , @NamedQuery(name = "Codigosdescripcion.findByCodDescripcion", query = "SELECT c FROM Codigosdescripcion c WHERE c.codDescripcion = :codDescripcion")
    , @NamedQuery(name = "Codigosdescripcion.findByDescripcion", query = "SELECT c FROM Codigosdescripcion c WHERE c.descripcion = :descripcion")})
public class Codigosdescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodDescripcion")
    private Integer codDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "ActivEconomica", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Actividades activEconomica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciiu")
    private List<Empresas> empresasList;

    public Codigosdescripcion() {
    }

    public Codigosdescripcion(Integer codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    public Codigosdescripcion(Integer codDescripcion, String descripcion) {
        this.codDescripcion = codDescripcion;
        this.descripcion = descripcion;
    }

    public Integer getCodDescripcion() {
        return codDescripcion;
    }

    public void setCodDescripcion(Integer codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividades getActivEconomica() {
        return activEconomica;
    }

    public void setActivEconomica(Actividades activEconomica) {
        this.activEconomica = activEconomica;
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
        hash += (codDescripcion != null ? codDescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigosdescripcion)) {
            return false;
        }
        Codigosdescripcion other = (Codigosdescripcion) object;
        if ((this.codDescripcion == null && other.codDescripcion != null) || (this.codDescripcion != null && !this.codDescripcion.equals(other.codDescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Codigosdescripcion[ codDescripcion=" + codDescripcion + " ]";
    }
    
}
