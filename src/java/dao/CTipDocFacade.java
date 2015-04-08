/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTipDoc;
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
public class CTipDocFacade extends AbstractFacade<CTipDoc> implements CTipDocFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CTipDocFacade() {
        super(CTipDoc.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CTipDoc.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CTipDoc c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cTipdDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CTipDoc getTipdoc(Integer tipdoc){		
		return (CTipDoc) em.createNamedQuery("CTipDoc.findByCTipdId").setParameter("cTipdId",tipdoc).getSingleResult();
	}
    
    
}
