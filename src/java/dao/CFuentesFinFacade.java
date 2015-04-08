/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CFuentesFin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class CFuentesFinFacade extends AbstractFacade<CFuentesFin> implements CFuentesFinFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CFuentesFinFacade() {
        super(CFuentesFin.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CFuentesFin.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CFuentesFin c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cFuestesDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CFuentesFin getFuentef(Integer fuente){		
		return (CFuentesFin) em.createNamedQuery("CFuentesFin.findByCFuentesId").setParameter("cFuentesId",fuente).getSingleResult();
	}

}
