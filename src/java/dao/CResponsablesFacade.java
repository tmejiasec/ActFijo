/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CResponsables;
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
public class CResponsablesFacade extends AbstractFacade<CResponsables> implements CResponsablesFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CResponsablesFacade() {
        super(CResponsables.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CResponsables.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CResponsables c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cRespNom1) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Nombre:", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CResponsables getResp(Integer resp){		
		return (CResponsables) em.createNamedQuery("CResponsables.findByCRespId").setParameter("cRespId",resp).getSingleResult();
	}
    
    
}
