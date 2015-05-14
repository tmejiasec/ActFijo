/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CNiveles;
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
public class CNivelesFacade extends AbstractFacade<CNiveles> implements CNivelesFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CNivelesFacade() {
        super(CNiveles.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CNiveles.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CNiveles c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cNivelDescrip) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CNiveles getNivel(Integer niv){		
		return (CNiveles) em.createNamedQuery("CNiveles.findByCNivelId").setParameter("cNivelId",niv).getSingleResult();
	}
    
  public Integer busCodN(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from c_niveles AS s WHERE s.c_nivel_codigo = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }
    
}
