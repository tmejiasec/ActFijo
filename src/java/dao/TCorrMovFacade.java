/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TCorrMov;
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
public class TCorrMovFacade extends AbstractFacade<TCorrMov> implements TCorrMovFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TCorrMovFacade() {
        super(TCorrMov.class);
    }
    
    public List getList() {			
	return em.createNamedQuery("TCorrMov.findAll").getResultList();
    }
    
   
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT a FROM CAreas a where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.cAreaDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public TCorrMov getCorrel(Integer tipm, Integer anio){		
		return  (TCorrMov) em.createNamedQuery("TCorrMov.findByTCorrAnio").setParameter("cTipmId",tipm).setParameter("tCorrAnio",anio).getSingleResult();
	}
 
    @Override        
    public Integer updateC(Integer tipm, Integer anio, Integer corr){
    	
    	String actualiz = "UPDATE t_corr_mov SET t_corr_correl= ?3 WHERE c_tipm_id= ?1 AND t_corr_anio= ?2";
        Query qactual = em.createNativeQuery(actualiz).setParameter(1,tipm).setParameter(2,anio).setParameter(3, corr);
        int resultado = qactual.executeUpdate(); 
        return resultado;
    }        
        
}
