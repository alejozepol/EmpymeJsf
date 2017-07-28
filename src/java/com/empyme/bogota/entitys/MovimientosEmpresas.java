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
@Table(name = "movimientos_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientosEmpresas.findAll", query = "SELECT m FROM MovimientosEmpresas m")
    , @NamedQuery(name = "MovimientosEmpresas.findByIdMovimiento", query = "SELECT m FROM MovimientosEmpresas m WHERE m.idMovimiento = :idMovimiento")
    , @NamedQuery(name = "MovimientosEmpresas.findByMovimiento", query = "SELECT m FROM MovimientosEmpresas m WHERE m.movimiento = :movimiento")
    , @NamedQuery(name = "MovimientosEmpresas.findByNit", query = "SELECT m FROM MovimientosEmpresas m WHERE m.nit = :nit")
    , @NamedQuery(name = "MovimientosEmpresas.findByRazonSocial", query = "SELECT m FROM MovimientosEmpresas m WHERE m.razonSocial = :razonSocial")
    , @NamedQuery(name = "MovimientosEmpresas.findByDirecci\u00f3n", query = "SELECT m FROM MovimientosEmpresas m WHERE m.direcci\u00f3n = :direcci\u00f3n")
    , @NamedQuery(name = "MovimientosEmpresas.findByTelefono", query = "SELECT m FROM MovimientosEmpresas m WHERE m.telefono = :telefono")
    , @NamedQuery(name = "MovimientosEmpresas.findByPaginaWeb", query = "SELECT m FROM MovimientosEmpresas m WHERE m.paginaWeb = :paginaWeb")
    , @NamedQuery(name = "MovimientosEmpresas.findByFechaConstitucion", query = "SELECT m FROM MovimientosEmpresas m WHERE m.fechaConstitucion = :fechaConstitucion")
    , @NamedQuery(name = "MovimientosEmpresas.findByCiiu", query = "SELECT m FROM MovimientosEmpresas m WHERE m.ciiu = :ciiu")
    , @NamedQuery(name = "MovimientosEmpresas.findByEstado", query = "SELECT m FROM MovimientosEmpresas m WHERE m.estado = :estado")
    , @NamedQuery(name = "MovimientosEmpresas.findByFormaJuridica", query = "SELECT m FROM MovimientosEmpresas m WHERE m.formaJuridica = :formaJuridica")
    , @NamedQuery(name = "MovimientosEmpresas.findByObjetoSocial", query = "SELECT m FROM MovimientosEmpresas m WHERE m.objetoSocial = :objetoSocial")
    , @NamedQuery(name = "MovimientosEmpresas.findByEstablecimientos", query = "SELECT m FROM MovimientosEmpresas m WHERE m.establecimientos = :establecimientos")
    , @NamedQuery(name = "MovimientosEmpresas.findByNumEmpleados", query = "SELECT m FROM MovimientosEmpresas m WHERE m.numEmpleados = :numEmpleados")
    , @NamedQuery(name = "MovimientosEmpresas.findByUsuario", query = "SELECT m FROM MovimientosEmpresas m WHERE m.usuario = :usuario")
    , @NamedQuery(name = "MovimientosEmpresas.findByFecha", query = "SELECT m FROM MovimientosEmpresas m WHERE m.fecha = :fecha")})
public class MovimientosEmpresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimiento")
    private Integer idMovimiento;
    @Size(max = 45)
    @Column(name = "Movimiento")
    private String movimiento;
    @Column(name = "Nit")
    private Integer nit;
    @Size(max = 50)
    @Column(name = "RazonSocial")
    private String razonSocial;
    @Size(max = 45)
    @Column(name = "Direcci\u00f3n")
    private String dirección;
    @Column(name = "Telefono")
    private Integer telefono;
    @Size(max = 100)
    @Column(name = "PaginaWeb")
    private String paginaWeb;
    @Column(name = "FechaConstitucion")
    @Temporal(TemporalType.DATE)
    private Date fechaConstitucion;
    @Column(name = "Ciiu")
    private Integer ciiu;
    @Column(name = "Estado")
    private Integer estado;
    @Column(name = "FormaJuridica")
    private Integer formaJuridica;
    @Size(max = 80)
    @Column(name = "ObjetoSocial")
    private String objetoSocial;
    @Column(name = "Establecimientos")
    private Integer establecimientos;
    @Column(name = "NumEmpleados")
    private Integer numEmpleados;
    @Size(max = 45)
    @Column(name = "Usuario")
    private String usuario;
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public MovimientosEmpresas() {
    }

    public MovimientosEmpresas(Integer idMovimiento) {
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

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
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

    public Integer getCiiu() {
        return ciiu;
    }

    public void setCiiu(Integer ciiu) {
        this.ciiu = ciiu;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getFormaJuridica() {
        return formaJuridica;
    }

    public void setFormaJuridica(Integer formaJuridica) {
        this.formaJuridica = formaJuridica;
    }

    public String getObjetoSocial() {
        return objetoSocial;
    }

    public void setObjetoSocial(String objetoSocial) {
        this.objetoSocial = objetoSocial;
    }

    public Integer getEstablecimientos() {
        return establecimientos;
    }

    public void setEstablecimientos(Integer establecimientos) {
        this.establecimientos = establecimientos;
    }

    public Integer getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(Integer numEmpleados) {
        this.numEmpleados = numEmpleados;
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
        if (!(object instanceof MovimientosEmpresas)) {
            return false;
        }
        MovimientosEmpresas other = (MovimientosEmpresas) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.MovimientosEmpresas[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
