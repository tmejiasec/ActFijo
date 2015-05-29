/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CJefesDep;
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
public class CJefesDepFacade extends AbstractFacade<CJefesDep> implements CJefesDepFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CJefesDepFacade() {
        super(CJefesDep.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CJefesDep.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String nombre) {
			
		String jpql = "SELECT c FROM CJefesDep c where 1=1";
		
		if(nombre != null  ){
			jpql += " AND UPPER(c.cJefesdNombre) like :nombre";
		}
		
		Query query = em.createQuery(jpql);
		
		if(nombre != null  ){
			query.setParameter("Nombre", "%"+nombre.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CJefesDep getJefeDep(Integer jef){		
		return (CJefesDep) em.createNamedQuery("CJefesDep.findByCJefesdId").setParameter("cJefesdId",jef).getSingleResult();
	}
    @Override
    public CJefesDep getDep(Integer dep){		
      return (CJefesDep) em.createNamedQuery("CJefesDep.findByCDepenId").setParameter("cDepenId",dep).getSingleResult();
    }
    
    
    
}
