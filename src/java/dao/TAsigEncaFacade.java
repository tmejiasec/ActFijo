/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TAsigEnca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TAsigEncaFacade extends AbstractFacade<TAsigEnca> implements TAsigEncaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TAsigEncaFacade() {
        super(TAsigEnca.class);
    }
    
    @Override
    public List getList() {
        return em.createNamedQuery("TAsigEnca.findAll").getResultList();
    }
    
    @Override
	public TAsigEnca getEnca(Integer move){		
		return (TAsigEnca) em.createNamedQuery("TAsigEnca.findByTAsigeId").setParameter("tAsigeId",move).getSingleResult();
	}
        
    @Override
    public List getListJ(Integer jefe) {			
	return em.createNamedQuery("TAsigEnca.findByCJefesId").setParameter("cJefesId",jefe).getResultList();
    }        
}
