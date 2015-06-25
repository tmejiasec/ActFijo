/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TMovimDeta;
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
public class TMovimDetaFacade extends AbstractFacade<TMovimDeta> implements TMovimDetaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMovimDetaFacade() {
        super(TMovimDeta.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("TMovimDeta.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer move) {			
	return em.createNamedQuery("TMovimDeta.findByTMoveId").setParameter("tMoveId",move).getResultList();
    }
    
    @Override
	public TMovimDeta getMoved(Integer moved){		
		return (TMovimDeta) em.createNamedQuery("TMovimDeta.findByTMovdId").setParameter("tMovdId",moved).getSingleResult();
	}
    
  @Override
    public Integer busCod(String cod, Integer move) {
        Integer resul;
        String consuld = "SELECT count (s) from t_movim_deta AS s WHERE s.t_movd_codigo = ?1 AND s.t_move_id = ?2";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod).setParameter(2, move);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }
        
    
}
