/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CMarcasBm;
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
public class CMarcasBmFacade extends AbstractFacade<CMarcasBm> implements CMarcasBmFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CMarcasBmFacade() {
        super(CMarcasBm.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CMarcasBm.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CMarcasBm c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cMarcaDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CMarcasBm getMarca(Integer marca){		
		return (CMarcasBm) em.createNamedQuery("CMarcasBm.findByCMarcaId").setParameter("cMarcaId",marca).getSingleResult();
	}
    
    
}
