/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CRoles;
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
public class CRolesFacade extends AbstractFacade<CRoles> implements CRolesFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CRolesFacade() {
        super(CRoles.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CRoles.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CRoles c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cRolesDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CRoles getRol(Integer rol){		
		return (CRoles) em.createNamedQuery("CRoles.findByCRolId").setParameter("cRolId",rol).getSingleResult();
	}

    
}
