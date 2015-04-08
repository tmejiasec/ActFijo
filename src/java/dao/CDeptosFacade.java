/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CDeptos;
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
public class CDeptosFacade extends AbstractFacade<CDeptos> implements CDeptosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CDeptosFacade() {
        super(CDeptos.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CDeptos.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT d FROM CDeptos d where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(d.cDeptoDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CDeptos getDepto(Integer depto){		
		return (CDeptos) em.createNamedQuery("CDeptos.findByCDeptoId").setParameter("cDeptoId",depto).getSingleResult();
	}

    
    
}
