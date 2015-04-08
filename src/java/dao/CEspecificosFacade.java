/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CEspecificos;
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
public class CEspecificosFacade extends AbstractFacade<CEspecificos> implements CEspecificosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CEspecificosFacade() {
        super(CEspecificos.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("CEspecificos.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer rubro) {			
	return em.createNamedQuery("CEspecificos.findByCRubroId").setParameter("cRubroId",rubro).getResultList();
    }
    
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT d FROM CEspecificos d where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(d.cEspecDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CEspecificos getEspec(Integer espec){		
		return (CEspecificos) em.createNamedQuery("CEspecificos.findByCEspecId").setParameter("cEspecId",espec).getSingleResult();
	}
    
    
}
