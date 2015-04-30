/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TArchivos;
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
public class TArchivosFacade extends AbstractFacade<TArchivos> implements TArchivosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TArchivosFacade() {
        super(TArchivos.class);
    }
    
        @Override
    public List getList() {			
	return em.createNamedQuery("TArchivos.findAll").getResultList();
    }
    
    @Override
    public List getListM(String codbien) {			
	return em.createNamedQuery("TArchivos.findByTArchCodref").setParameter("tArchCodref",codbien).getResultList();
    }
    
    @Override
    public List getListT(String tipar) {			
	return em.createNamedQuery("TArchivos.findByTArchTipref").setParameter("tArchTipref",tipar).getResultList();
    }
    
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT m FROM TArchivos m where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.tArchDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public TArchivos getArch(Integer arch){		
		return (TArchivos) em.createNamedQuery("TArchivos.findByTArchId").setParameter("tArchiId",arch).getSingleResult();
	}

}
