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
@Table(name = "representantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representantes.findAll", query = "SELECT r FROM Representantes r")
    , @NamedQuery(name = "Representantes.findByIdentificacion", query = "SELECT r FROM Representantes r WHERE r.identificacion = :identificacion")
    , @NamedQuery(name = "Representantes.findByNombre", query = "SELECT r FROM Representantes r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Representantes.findByApellido", query = "SELECT r FROM Representantes r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "Representantes.findByTelefono", query = "SELECT r FROM Representantes r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Representantes.findByCelular", query = "SELECT r FROM Representantes r WHERE r.celular = :celular")
    , @NamedQuery(name = "Representantes.findByEmail", query = "SELECT r FROM Representantes r WHERE r.email = :email")
    , @NamedQuery(name = "Representantes.findByFechaRegistro", query = "SELECT r FROM Representantes r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Representantes.findByFotocopia", query = "SELECT r FROM Representantes r WHERE r.fotocopia = :fotocopia")})
public class Representantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Identificacion")
    private Integer identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Celular")
    private int celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Fotocopia")
    private String fotocopia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representantes")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "Cargo", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Cargos cargo;
    @JoinColumn(name = "DocTipo", referencedColumnName = "CodTipo")
    @ManyToOne(optional = false)
    private Tipodoc docTipo;

    public Representantes() {
    }

    public Representantes(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Representantes(Integer identificacion, String nombre, String apellido, int telefono, int celular, String email, Date fechaRegistro, String fotocopia) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.fotocopia = fotocopia;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFotocopia() {
        return fotocopia;
    }

    public void setFotocopia(String fotocopia) {
        this.fotocopia = fotocopia;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public Tipodoc getDocTipo() {
        return docTipo;
    }

    public void setDocTipo(Tipodoc docTipo) {
        this.docTipo = docTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representantes)) {
            return false;
        }
        Representantes other = (Representantes) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Representantes[ identificacion=" + identificacion + " ]";
    }
    
}
