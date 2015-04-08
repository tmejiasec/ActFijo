/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CAreas;
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
public class CAreasFacade extends AbstractFacade<CAreas> implements CAreasFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CAreasFacade() {
        super(CAreas.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CAreas.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer edif) {			
	return em.createNamedQuery("CAreas.findByCEdifId").setParameter("cEdifId",edif).getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT a FROM CAreas a where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.cAreaDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CAreas getArea(Integer area){		
		return (CAreas) em.createNamedQuery("CAreas.findByCAreaId").setParameter("cAreaId",area).getSingleResult();
	}
    
    
}
