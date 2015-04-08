/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CMunic;
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
public class CMunicFacade extends AbstractFacade<CMunic> implements CMunicFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CMunicFacade() {
        super(CMunic.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CMunic.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer depto) {			
	return em.createNamedQuery("CMunic.findByCDeptoId").setParameter("cDeptoId",depto).getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT m FROM CMunic m where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.cMuniDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CMunic getMuni(Integer muni){		
		return (CMunic) em.createNamedQuery("CMunic.findByCMuniId").setParameter("cMuniId",muni).getSingleResult();
	}

    
}
