/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEdificios;
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
public class CEdificiosFacade extends AbstractFacade<CEdificios> implements CEdificiosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEdificiosFacade() {
        super(CEdificios.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CEdificios.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT e FROM CEdificios e where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(e.cEdifDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CEdificios getEdif(Integer edif){		
		return (CEdificios) em.createNamedQuery("CEdificios.findByCEdifId").setParameter("cEdifId",edif).getSingleResult();
	}

    
    
}
