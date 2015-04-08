/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoMov;
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
public class CEstadoMovFacade extends AbstractFacade<CEstadoMov> implements CEstadoMovFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEstadoMovFacade() {
        super(CEstadoMov.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CEstadoMov.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CEstadoMov c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cEstmovDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CEstadoMov getEstMov(Integer estm){		
		return (CEstadoMov) em.createNamedQuery("CEstadoMov.findByCEstmovId").setParameter("cEstmovId",estm).getSingleResult();
	}
    

    
}
