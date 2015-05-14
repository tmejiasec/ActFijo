/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CRubros;
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
public class CRubrosFacade extends AbstractFacade<CRubros> implements CRubrosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CRubrosFacade() {
        super(CRubros.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CRubros.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CRubros c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cRubroDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CRubros getRubro(Integer rubro){		
		return (CRubros) em.createNamedQuery("CRubros.findByCRubroId").setParameter("cRubroId",rubro).getSingleResult();
	}
    @Override
    public Integer busCodR(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from c_rubros AS s WHERE s.c_rubro_codigo = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }    
}
