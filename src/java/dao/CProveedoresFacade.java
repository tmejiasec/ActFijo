/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CProveedores;
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
public class CProveedoresFacade extends AbstractFacade<CProveedores> implements CProveedoresFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CProveedoresFacade() {
        super(CProveedores.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CProveedores.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CProveedores c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cProvDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CProveedores getProv(Integer prov){		
		return (CProveedores) em.createNamedQuery("CProveedores.findByCProvId").setParameter("cProvId",prov).getSingleResult();
	}
    
    
}
