/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEstadoProc;
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
public class CEstadoProcFacade extends AbstractFacade<CEstadoProc> implements CEstadoProcFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEstadoProcFacade() {
        super(CEstadoProc.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CEstadoProc.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CEstadoProc c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cEstproDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CEstadoProc getEstpro(Integer estp){		
		return (CEstadoProc) em.createNamedQuery("CEstadoProc.findByCEstproId").setParameter("cEstproId",estp).getSingleResult();
	}

    
}
