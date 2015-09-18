/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRobHur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TRobHurFacade extends AbstractFacade<TRobHur> implements TRobHurFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List getList() {
        
        return em.createNamedQuery("TRobHur.findAll").getResultList();
    }

    public TRobHurFacade() {
        super(TRobHur.class);
    }
    
    @Override
    public List getListJ(Integer jefe) {			
	return em.createNamedQuery("TRobHur.findByCJefesId").setParameter("cJefesId",jefe).getResultList();
    }
                
    
}
