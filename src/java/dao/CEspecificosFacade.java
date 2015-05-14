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
        
    @Override
    public Integer updateC(Integer espec, Integer corr){
    	
    	String actualiz = "UPDATE c_especificos SET c_espec_corr= ?2 WHERE c_espec_id= ?1";
        Query qactual = em.createNativeQuery(actualiz).setParameter(1,espec).setParameter(2,corr);
        int resultado = qactual.executeUpdate(); 
        return resultado;
    }
    
    @Override
    public Integer busCodE(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from c_especificos AS s WHERE s.c_espec_codigo = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }    
    
    
}
