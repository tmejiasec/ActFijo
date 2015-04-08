/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CZonas;
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
public class CZonasFacade extends AbstractFacade<CZonas> implements CZonasFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CZonasFacade() {
        super(CZonas.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CZonas.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CZonas c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cZonaDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CZonas getZona(Integer zona){		
		return (CZonas) em.createNamedQuery("CZonas.findByCZonaId").setParameter("cZonaId",zona).getSingleResult();
	}
    
    
}
