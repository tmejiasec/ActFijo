/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoBien;
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
public class CEstadoBienFacade extends AbstractFacade<CEstadoBien> implements CEstadoBienFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEstadoBienFacade() {
        super(CEstadoBien.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CEstadoBien.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CEstadoBien c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cEstadbDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CEstadoBien getEstBien(Integer estb){		
		return (CEstadoBien) em.createNamedQuery("CEstadoBien.findByCEstadbId").setParameter("cEstadbId",estb).getSingleResult();
	}

    
}
