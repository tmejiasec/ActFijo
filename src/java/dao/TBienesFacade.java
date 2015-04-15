/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TBienes;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Date;
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
public class TBienesFacade extends AbstractFacade<TBienes> implements TBienesFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TBienesFacade() {
        super(TBienes.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("TBienes.findAll").getResultList();
    }
    
    @Override
    public List getListL() {			
	return em.createNamedQuery("TBienes.findByTBienInglote").setParameter("tBienInglote",TRUE).setParameter("tBienLoteingre", FALSE).getResultList();
    }
    
    
    @Override
    public List getListM(Integer respo) {			
	return em.createNamedQuery("TBienes.findByCRespId").setParameter("cRespId",respo).getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT m FROM TBienes m where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(m.tBienDesc) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Descripción", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public TBienes getBien(Integer bien){		
		return (TBienes) em.createNamedQuery("TBienes.findByTBienId").setParameter("tBienId",bien).getSingleResult();
	}

    @Override
	public Integer busCod(String cod) {
	  	Integer resul;
        	String consuld = "SELECT count (s) from t_bienes AS s WHERE s.t_bien_codigo = ?1";
                Query qconsuld = em.createNativeQuery(consuld).setParameter(1,cod);
        	resul = ((Long) qconsuld.getSingleResult()).intValue(); 
//    	System.out.println("query ejecutada en busDoc");
		return resul;
	}        

        
    @Override
        public List datosI(String cod){
        System.out.println("cod: "+cod);
	String consul = "SELECT * FROM t_bienes t WHERE t.t_bien_codigo = ?1";
	 Query qconsul = em.createNativeQuery(consul).setParameter(1,cod);
	 
//	 generando datos a replicar

	 List  ingresos = qconsul.getResultList();
   
	 System.out.println("query ejecutada");
         System.out.println("tot: "+ingresos.size());
	 return ingresos;
        }
    
@Override
    public Integer updateL(Integer idcod,Date fecinl,String codini,String codfin){
    	String actualiz = "UPDATE t_bienes SET t_bien_fecinglote = ?2, t_bien_codinilot = ?3, t_bien_codfinlot = ?4, t_bien_loteingre = ?5 WHERE t_bien_id= ?1";
        Query qactual = em.createNativeQuery(actualiz).setParameter(1,idcod).setParameter(2,fecinl).setParameter(3,codini).setParameter(4,codfin).setParameter(5, true);
        int resultado = qactual.executeUpdate(); 
        return resultado;
    }        
}
