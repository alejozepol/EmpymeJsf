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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "inforfinanciera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inforfinanciera.findAll", query = "SELECT i FROM Inforfinanciera i")
    , @NamedQuery(name = "Inforfinanciera.findByNoRegistro", query = "SELECT i FROM Inforfinanciera i WHERE i.noRegistro = :noRegistro")
    , @NamedQuery(name = "Inforfinanciera.findByFechaCorte", query = "SELECT i FROM Inforfinanciera i WHERE i.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "Inforfinanciera.findByBancos", query = "SELECT i FROM Inforfinanciera i WHERE i.bancos = :bancos")
    , @NamedQuery(name = "Inforfinanciera.findByCuentasxCobrar", query = "SELECT i FROM Inforfinanciera i WHERE i.cuentasxCobrar = :cuentasxCobrar")
    , @NamedQuery(name = "Inforfinanciera.findByInventarios", query = "SELECT i FROM Inforfinanciera i WHERE i.inventarios = :inventarios")
    , @NamedQuery(name = "Inforfinanciera.findByValoresRealizables", query = "SELECT i FROM Inforfinanciera i WHERE i.valoresRealizables = :valoresRealizables")
    , @NamedQuery(name = "Inforfinanciera.findByActivosCorrientes", query = "SELECT i FROM Inforfinanciera i WHERE i.activosCorrientes = :activosCorrientes")
    , @NamedQuery(name = "Inforfinanciera.findByPropiedadplantayEquipo", query = "SELECT i FROM Inforfinanciera i WHERE i.propiedadplantayEquipo = :propiedadplantayEquipo")
    , @NamedQuery(name = "Inforfinanciera.findByActivosNoCorrientes", query = "SELECT i FROM Inforfinanciera i WHERE i.activosNoCorrientes = :activosNoCorrientes")
    , @NamedQuery(name = "Inforfinanciera.findByCuentasxPagar", query = "SELECT i FROM Inforfinanciera i WHERE i.cuentasxPagar = :cuentasxPagar")
    , @NamedQuery(name = "Inforfinanciera.findByPasivosCorrientes", query = "SELECT i FROM Inforfinanciera i WHERE i.pasivosCorrientes = :pasivosCorrientes")
    , @NamedQuery(name = "Inforfinanciera.findByOtrosPasivos", query = "SELECT i FROM Inforfinanciera i WHERE i.otrosPasivos = :otrosPasivos")
    , @NamedQuery(name = "Inforfinanciera.findByPasivosNoCorrientes", query = "SELECT i FROM Inforfinanciera i WHERE i.pasivosNoCorrientes = :pasivosNoCorrientes")
    , @NamedQuery(name = "Inforfinanciera.findByPatrimonio", query = "SELECT i FROM Inforfinanciera i WHERE i.patrimonio = :patrimonio")
    , @NamedQuery(name = "Inforfinanciera.findByIngresosOperacionales", query = "SELECT i FROM Inforfinanciera i WHERE i.ingresosOperacionales = :ingresosOperacionales")
    , @NamedQuery(name = "Inforfinanciera.findByCostodeVentas", query = "SELECT i FROM Inforfinanciera i WHERE i.costodeVentas = :costodeVentas")
    , @NamedQuery(name = "Inforfinanciera.findByIngresosNoOperacionales", query = "SELECT i FROM Inforfinanciera i WHERE i.ingresosNoOperacionales = :ingresosNoOperacionales")
    , @NamedQuery(name = "Inforfinanciera.findByGastosdeVenta", query = "SELECT i FROM Inforfinanciera i WHERE i.gastosdeVenta = :gastosdeVenta")
    , @NamedQuery(name = "Inforfinanciera.findByGastosdeAdministraci\u00f3n", query = "SELECT i FROM Inforfinanciera i WHERE i.gastosdeAdministraci\u00f3n = :gastosdeAdministraci\u00f3n")
    , @NamedQuery(name = "Inforfinanciera.findByOtrosGastos", query = "SELECT i FROM Inforfinanciera i WHERE i.otrosGastos = :otrosGastos")
    , @NamedQuery(name = "Inforfinanciera.findByIngresosFinancieros", query = "SELECT i FROM Inforfinanciera i WHERE i.ingresosFinancieros = :ingresosFinancieros")
    , @NamedQuery(name = "Inforfinanciera.findByGastosFinancieros", query = "SELECT i FROM Inforfinanciera i WHERE i.gastosFinancieros = :gastosFinancieros")})
public class Inforfinanciera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoRegistro")
    private Integer noRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCorte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bancos")
    private double bancos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CuentasxCobrar")
    private double cuentasxCobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Inventarios")
    private double inventarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValoresRealizables")
    private double valoresRealizables;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActivosCorrientes")
    private double activosCorrientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Propiedad, planta y Equipo")
    private double propiedadplantayEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ActivosNoCorrientes")
    private double activosNoCorrientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CuentasxPagar")
    private double cuentasxPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PasivosCorrientes")
    private double pasivosCorrientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OtrosPasivos")
    private double otrosPasivos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PasivosNoCorrientes")
    private double pasivosNoCorrientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Patrimonio")
    private double patrimonio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IngresosOperacionales")
    private double ingresosOperacionales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CostodeVentas")
    private double costodeVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IngresosNoOperacionales")
    private double ingresosNoOperacionales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GastosdeVenta")
    private double gastosdeVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GastosdeAdministraci\u00f3n")
    private double gastosdeAdministración;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OtrosGastos")
    private double otrosGastos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IngresosFinancieros")
    private double ingresosFinancieros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GastosFinancieros")
    private double gastosFinancieros;
    @ManyToMany(mappedBy = "inforfinancieraList")
    private List<Empresas> empresasList;

    public Inforfinanciera() {
    }

    public Inforfinanciera(Integer noRegistro) {
        this.noRegistro = noRegistro;
    }

    public Inforfinanciera(Integer noRegistro, Date fechaCorte, double bancos, double cuentasxCobrar, double inventarios, double valoresRealizables, double activosCorrientes, double propiedadplantayEquipo, double activosNoCorrientes, double cuentasxPagar, double pasivosCorrientes, double otrosPasivos, double pasivosNoCorrientes, double patrimonio, double ingresosOperacionales, double costodeVentas, double ingresosNoOperacionales, double gastosdeVenta, double gastosdeAdministración, double otrosGastos, double ingresosFinancieros, double gastosFinancieros) {
        this.noRegistro = noRegistro;
        this.fechaCorte = fechaCorte;
        this.bancos = bancos;
        this.cuentasxCobrar = cuentasxCobrar;
        this.inventarios = inventarios;
        this.valoresRealizables = valoresRealizables;
        this.activosCorrientes = activosCorrientes;
        this.propiedadplantayEquipo = propiedadplantayEquipo;
        this.activosNoCorrientes = activosNoCorrientes;
        this.cuentasxPagar = cuentasxPagar;
        this.pasivosCorrientes = pasivosCorrientes;
        this.otrosPasivos = otrosPasivos;
        this.pasivosNoCorrientes = pasivosNoCorrientes;
        this.patrimonio = patrimonio;
        this.ingresosOperacionales = ingresosOperacionales;
        this.costodeVentas = costodeVentas;
        this.ingresosNoOperacionales = ingresosNoOperacionales;
        this.gastosdeVenta = gastosdeVenta;
        this.gastosdeAdministración = gastosdeAdministración;
        this.otrosGastos = otrosGastos;
        this.ingresosFinancieros = ingresosFinancieros;
        this.gastosFinancieros = gastosFinancieros;
    }

    public Integer getNoRegistro() {
        return noRegistro;
    }

    public void setNoRegistro(Integer noRegistro) {
        this.noRegistro = noRegistro;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public double getBancos() {
        return bancos;
    }

    public void setBancos(double bancos) {
        this.bancos = bancos;
    }

    public double getCuentasxCobrar() {
        return cuentasxCobrar;
    }

    public void setCuentasxCobrar(double cuentasxCobrar) {
        this.cuentasxCobrar = cuentasxCobrar;
    }

    public double getInventarios() {
        return inventarios;
    }

    public void setInventarios(double inventarios) {
        this.inventarios = inventarios;
    }

    public double getValoresRealizables() {
        return valoresRealizables;
    }

    public void setValoresRealizables(double valoresRealizables) {
        this.valoresRealizables = valoresRealizables;
    }

    public double getActivosCorrientes() {
        return activosCorrientes;
    }

    public void setActivosCorrientes(double activosCorrientes) {
        this.activosCorrientes = activosCorrientes;
    }

    public double getPropiedadplantayEquipo() {
        return propiedadplantayEquipo;
    }

    public void setPropiedadplantayEquipo(double propiedadplantayEquipo) {
        this.propiedadplantayEquipo = propiedadplantayEquipo;
    }

    public double getActivosNoCorrientes() {
        return activosNoCorrientes;
    }

    public void setActivosNoCorrientes(double activosNoCorrientes) {
        this.activosNoCorrientes = activosNoCorrientes;
    }

    public double getCuentasxPagar() {
        return cuentasxPagar;
    }

    public void setCuentasxPagar(double cuentasxPagar) {
        this.cuentasxPagar = cuentasxPagar;
    }

    public double getPasivosCorrientes() {
        return pasivosCorrientes;
    }

    public void setPasivosCorrientes(double pasivosCorrientes) {
        this.pasivosCorrientes = pasivosCorrientes;
    }

    public double getOtrosPasivos() {
        return otrosPasivos;
    }

    public void setOtrosPasivos(double otrosPasivos) {
        this.otrosPasivos = otrosPasivos;
    }

    public double getPasivosNoCorrientes() {
        return pasivosNoCorrientes;
    }

    public void setPasivosNoCorrientes(double pasivosNoCorrientes) {
        this.pasivosNoCorrientes = pasivosNoCorrientes;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public double getIngresosOperacionales() {
        return ingresosOperacionales;
    }

    public void setIngresosOperacionales(double ingresosOperacionales) {
        this.ingresosOperacionales = ingresosOperacionales;
    }

    public double getCostodeVentas() {
        return costodeVentas;
    }

    public void setCostodeVentas(double costodeVentas) {
        this.costodeVentas = costodeVentas;
    }

    public double getIngresosNoOperacionales() {
        return ingresosNoOperacionales;
    }

    public void setIngresosNoOperacionales(double ingresosNoOperacionales) {
        this.ingresosNoOperacionales = ingresosNoOperacionales;
    }

    public double getGastosdeVenta() {
        return gastosdeVenta;
    }

    public void setGastosdeVenta(double gastosdeVenta) {
        this.gastosdeVenta = gastosdeVenta;
    }

    public double getGastosdeAdministración() {
        return gastosdeAdministración;
    }

    public void setGastosdeAdministración(double gastosdeAdministración) {
        this.gastosdeAdministración = gastosdeAdministración;
    }

    public double getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(double otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public double getIngresosFinancieros() {
        return ingresosFinancieros;
    }

    public void setIngresosFinancieros(double ingresosFinancieros) {
        this.ingresosFinancieros = ingresosFinancieros;
    }

    public double getGastosFinancieros() {
        return gastosFinancieros;
    }

    public void setGastosFinancieros(double gastosFinancieros) {
        this.gastosFinancieros = gastosFinancieros;
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
        hash += (noRegistro != null ? noRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inforfinanciera)) {
            return false;
        }
        Inforfinanciera other = (Inforfinanciera) object;
        if ((this.noRegistro == null && other.noRegistro != null) || (this.noRegistro != null && !this.noRegistro.equals(other.noRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.Inforfinanciera[ noRegistro=" + noRegistro + " ]";
    }
    
}
