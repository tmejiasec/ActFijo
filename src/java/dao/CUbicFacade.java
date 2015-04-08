/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CUbic;
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
public class CUbicFacade extends AbstractFacade<CUbic> implements CUbicFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CUbicFacade() {
        super(CUbic.class);
    }
    
     public List getList() {			
	return em.createNamedQuery("CUbic.findAll").getResultList();
    }
    
    @Override
    public List getListA(Integer area) {			
	return em.createNamedQuery("CUbic.findByCAreaId").setParameter("cAreaId",area).getResultList();
    }
    
    @Override
    public List getListE(Integer edif) {			
	return em.createNamedQuery("CUbic.findByCEdifId").setParameter("cEdifId",edif).getResultList();
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
	public CUbic getUbic(Integer ubic){		
		return (CUbic) em.createNamedQuery("CUbic.findByCUbicId").setParameter("cUbicId",ubic).getSingleResult();
	}
    
    
    
}
