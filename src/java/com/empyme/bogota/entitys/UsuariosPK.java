/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Acer
 */
@Embeddable
public class UsuariosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmpresaNit")
    private int empresaNit;

    public UsuariosPK() {
    }

    public UsuariosPK(int idusuario, int empresaNit) {
        this.idusuario = idusuario;
        this.empresaNit = empresaNit;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getEmpresaNit() {
        return empresaNit;
    }

    public void setEmpresaNit(int empresaNit) {
        this.empresaNit = empresaNit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idusuario;
        hash += (int) empresaNit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (this.empresaNit != other.empresaNit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.empyme.bogota.entitys.UsuariosPK[ idusuario=" + idusuario + ", empresaNit=" + empresaNit + " ]";
    }
    
}
