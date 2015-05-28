/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TSustit;
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
public class TSustitFacade extends AbstractFacade<TSustit> implements TSustitFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TSustitFacade() {
        super(TSustit.class);
    }

    @Override
    public List getList() {
        throw new UnsupportedOperationException("TSustit.findAll"); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List busqueda(String desc) {
			
		String jpql = "SELECT a FROM TSustit s where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.tSustitDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
	public TSustit getSustituc(Integer susti){		
		return (TSustit) em.createNamedQuery("TSustit.findByCAreaId").setParameter("tSustId",susti).getSingleResult();
	}
    
}
