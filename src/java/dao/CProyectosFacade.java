/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CProyectos;
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
public class CProyectosFacade extends AbstractFacade<CProyectos> implements CProyectosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CProyectosFacade() {
        super(CProyectos.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CProyectos.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CProyectos c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cProyDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CProyectos getProy(Integer proy){		
		return (CProyectos) em.createNamedQuery("CProyectos.findByCProyId").setParameter("cProyId",proy).getSingleResult();
	}
    
}
