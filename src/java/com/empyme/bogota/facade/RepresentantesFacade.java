/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empyme.bogota.facade;

import com.empyme.bogota.entitys.Representantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class RepresentantesFacade extends AbstractFacade<Representantes> {

    @PersistenceContext(unitName = "EmpymeJsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentantesFacade() {
        super(Representantes.class);
    }
    
}
