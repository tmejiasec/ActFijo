/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CDependencias;
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
public class CDependenciasFacade extends AbstractFacade<CDependencias> implements CDependenciasFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CDependenciasFacade() {
        super(CDependencias.class);
    }
    
     @Override
    public List getList() {			
	return em.createNamedQuery("CDependencias.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer nivel) {			
	return em.createNamedQuery("CDependencias.findByCNivelId").setParameter("cNivelId",nivel).getResultList();
    }
        
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CDependencias c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cDepenDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CDependencias getDepend(Integer dep){		
		return (CDependencias) em.createNamedQuery("CDependencias.findByCDepenId").setParameter("cDepenId",dep).getSingleResult();
	}
    
    public Integer busCodD(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from c_dependencias AS s WHERE s.c_depen_codigo = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }    
    
    
}
