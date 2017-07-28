/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "movimientos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientosUsuarios.findAll", query = "SELECT m FROM MovimientosUsuarios m")
    , @NamedQuery(name = "MovimientosUsuarios.findByIdMovimiento", query = "SELECT m FROM MovimientosUsuarios m WHERE m.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "MovimientosUsuarios.findByMovimiento", query = "SELECT m FROM MovimientosUsuarios m WHERE m.movimiento = :movimiento")
    , @NamedQuery(name = "MovimientosUsuarios.findByIdentificacion", query = "SELECT m FROM MovimientosUsuarios m WHERE m.identificacion = :identificacion")
    , @NamedQuery(name = "MovimientosUsuarios.findByNombre", query = "SELECT m FROM MovimientosUsuarios m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "MovimientosUsuarios.findByApellido", query = "SELECT m FROM MovimientosUsuarios m WHERE m.apellido = :apellido")
    , @NamedQuery(name = "MovimientosUsuarios.findByTelefono", query = "SELECT m FROM MovimientosUsuarios m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "MovimientosUsuarios.findByCelular", query = "SELECT m FROM MovimientosUsuarios m WHERE m.celular = :celular")
    , @NamedQuery(name = "MovimientosUsuarios.findByEmail", query = "SELECT m FROM MovimientosUsuarios m WHERE m.email = :email")
    , @NamedQuery(name = "MovimientosUsuarios.findByFechaRegistro", query = "SELECT m FROM MovimientosUsuarios m WHERE m.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "MovimientosUsuarios.findByCargo", query = "SELECT m FROM MovimientosUsuarios m WHERE m.cargo = :cargo")
    , @NamedQuery(name = "MovimientosUsuarios.findByUsuario", query = "SELECT m FROM MovimientosUsuarios m WHERE m.usuario = :usuario")
    , @NamedQuery(name = "MovimientosUsuarios.findByFecha", query = "SELECT m FROM MovimientosUsuarios m WHERE m.fecha = :fecha")})
public class MovimientosUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimiento")
    private Integer idMovimiento;
    @Size(max = 45)
    @Column(name = "Movimiento")
    private String movimiento;
    @Column(name = "Identificacion")
    private Integer identificacion;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "Apellido")
    private String apellido;
    @Size(max = 7)
    @Column(name = "Telefono")
    private String telefono;
    @Size(max = 10)
    @Column(name = "Celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "Cargo")
    private Integer cargo;
    @Size(max = 45)
    @Column(name = "Usuario")
    private String usuario;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public MovimientosUsuarios() {
    }

    public MovimientosUsuarios(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
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

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientosUsuarios)) {
            return false;
        }
        MovimientosUsuarios other = (MovimientosUsuarios) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.MovimientosUsuarios[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
