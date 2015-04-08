/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CFormasAdq;
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
public class CFormasAdqFacade extends AbstractFacade<CFormasAdq> implements CFormasAdqFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CFormasAdqFacade() {
        super(CFormasAdq.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CFormasAdq.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CFormasAdq c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cFormadDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CFormasAdq getFormad(Integer forma){		
		return (CFormasAdq) em.createNamedQuery("CFormasAdq.findByCFormadId").setParameter("cFormadId",forma).getSingleResult();
	}
    
    
}
