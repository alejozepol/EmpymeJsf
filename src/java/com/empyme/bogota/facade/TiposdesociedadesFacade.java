/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.facade;

import com.empyme.bogota.entitys.Tiposdesociedades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class TiposdesociedadesFacade extends AbstractFacade<Tiposdesociedades> {

    @PersistenceContext(unitName = "EmpymeJsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposdesociedadesFacade() {
        super(Tiposdesociedades.class);
    }
    
}