/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e")
    , @NamedQuery(name = "Empresas.findByNit", query = "SELECT e FROM Empresas e WHERE e.nit = :nit")
    , @NamedQuery(name = "Empresas.findByRazonSocial", query = "SELECT e FROM Empresas e WHERE e.razonSocial = :razonSocial")
    , @NamedQuery(name = "Empresas.findByDireccion", query = "SELECT e FROM Empresas e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empresas.findByTelefono", query = "SELECT e FROM Empresas e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Empresas.findByPaginaWeb", query = "SELECT e FROM Empresas e WHERE e.paginaWeb = :paginaWeb")
    , @NamedQuery(name = "Empresas.findByFechaConstitucion", query = "SELECT e FROM Empresas e WHERE e.fechaConstitucion = :fechaConstitucion")
    , @NamedQuery(name = "Empresas.findByObjetoSocial", query = "SELECT e FROM Empresas e WHERE e.objetoSocial = :objetoSocial")
    , @NamedQuery(name = "Empresas.findByEstablecimientos", query = "SELECT e FROM Empresas e WHERE e.establecimientos = :establecimientos")
    , @NamedQuery(name = "Empresas.findByNumEmpleados", query = "SELECT e FROM Empresas e WHERE e.numEmpleados = :numEmpleados")
    , @NamedQuery(name = "Empresas.findByArchivo", query = "SELECT e FROM Empresas e WHERE e.archivo = :archivo")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nit")
    private Integer nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PaginaWeb")
    private String paginaWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaConstitucion")
    @Temporal(TemporalType.DATE)
    private Date fechaConstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ObjetoSocial")
    private String objetoSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Establecimientos")
    private int establecimientos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumEmpleados")
    private int numEmpleados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Archivo")
    private String archivo;
    @JoinTable(name = "periodos", joinColumns = {
        @JoinColumn(name = "NitEmpresa", referencedColumnName = "Nit")}, inverseJoinColumns = {
        @JoinColumn(name = "RegistroNo", referencedColumnName = "NoRegistro")})
    @ManyToMany
    private List<Inforfinanciera> inforfinancieraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresas")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "Ciiu", referencedColumnName = "CodDescripcion")
    @ManyToOne(optional = false)
    private Codigosdescripcion ciiu;
    @JoinColumn(name = "Estado", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Estadosempresas estado;
    @JoinColumn(name = "FormaJuridica", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Tiposdesociedades formaJuridica;
    @JoinColumn(name = "Tipo", referencedColumnName = "CodTipo")
    @ManyToOne(optional = false)
    private Tipodoc tipo;

    public Empresas() {
    }

    public Empresas(Integer nit) {
        this.nit = nit;
    }

    public Empresas(Integer nit, String razonSocial, String direccion, int telefono, String paginaWeb, Date fechaConstitucion, String objetoSocial, int establecimientos, int numEmpleados, String archivo) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.fechaConstitucion = fechaConstitucion;
        this.objetoSocial = objetoSocial;
        this.establecimientos = establecimientos;
        this.numEmpleados = numEmpleados;
        this.archivo = archivo;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Date getFechaConstitucion() {
        return fechaConstitucion;
    }

    public void setFechaConstitucion(Date fechaConstitucion) {
        this.fechaConstitucion = fechaConstitucion;
    }

    public String getObjetoSocial() {
        return objetoSocial;
    }

    public void setObjetoSocial(String objetoSocial) {
        this.objetoSocial = objetoSocial;
    }

    public int getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(int establecimientos) {
        this.establecimientos = establecimientos;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @XmlTransient
    public List<Inforfinanciera> getInforfinancieraList() {
        return inforfinancieraList;
    }

    public void setInforfinancieraList(List<Inforfinanciera> inforfinancieraList) {
        this.inforfinancieraList = inforfinancieraList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Codigosdescripcion getCiiu() {
        return ciiu;
    }

    public void setCiiu(Codigosdescripcion ciiu) {
        this.ciiu = ciiu;
    }

    public Estadosempresas getEstado() {
        return estado;
    }

    public void setEstado(Estadosempresas estado) {
        this.estado = estado;
    }

    public Tiposdesociedades getFormaJuridica() {
        return formaJuridica;
    }

    public void setFormaJuridica(Tiposdesociedades formaJuridica) {
        this.formaJuridica = formaJuridica;
    }

    public Tipodoc getTipo() {
        return tipo;
    }

    public void setTipo(Tipodoc tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Empresas[ nit=" + nit + " ]";
    }
    
}
