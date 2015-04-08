/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CCondBien;
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
public class CCondBienFacade extends AbstractFacade<CCondBien> implements CCondBienFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CCondBienFacade() {
        super(CCondBien.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CCondBien.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CCondBien c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cCondbDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CCondBien getCondb(Integer condb){		
		return (CCondBien) em.createNamedQuery("CCondBien.findByCCondbId").setParameter("cCondbId",condb).getSingleResult();
	}
    
}
