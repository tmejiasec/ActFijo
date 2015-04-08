/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTiposMov;
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
public class CTiposMovFacade extends AbstractFacade<CTiposMov> implements CTiposMovFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CTiposMovFacade() {
        super(CTiposMov.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CTiposMov.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CTiposMov c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cTimpDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CTiposMov getTipmov(Integer tipm){		
		return (CTiposMov) em.createNamedQuery("CTiposMov.findByCTipmId").setParameter("cTipmId",tipm).getSingleResult();
	}
    
    
}
