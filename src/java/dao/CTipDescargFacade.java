/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTipDescarg;
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
public class CTipDescargFacade extends AbstractFacade<CTipDescarg> implements CTipDescargFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CTipDescargFacade() {
        super(CTipDescarg.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CTipDescarg.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CTipDescarg c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cTipdescDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CTipDescarg getTipd(Integer tipdes){		
 		return (CTipDescarg) em.createNamedQuery("CTipDescarg.findByCTipdescId").setParameter("cTipdescId",tipdes).getSingleResult();
	}
    
    
}
