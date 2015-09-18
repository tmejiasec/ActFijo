/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TMovimEnca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TMovimEncaFacade extends AbstractFacade<TMovimEnca> implements TMovimEncaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMovimEncaFacade() {
        super(TMovimEnca.class);
    }

    @Override
    public List getList() {			
	return em.createNamedQuery("TMovimEnca.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer correl, Integer anio) {			
	return em.createNamedQuery("TMovimEnca.findByTMoveCorr").setParameter("tMoveCorr",correl).getResultList();
    }

    @Override
    public List getListT(Integer tipm,Integer estm) {			
	return em.createNamedQuery("TMovimEnca.findByMovyEst").setParameter("cTipmId",tipm).setParameter("cEstmovId",estm).getResultList();
    }
    
  @Override
    public List getListJ(Integer jefe) {			
	return em.createNamedQuery("TMovimEnca.findByCJefesdId").setParameter("cJefesdId",jefe).getResultList();
    }
    
    @Override
    public List getListTipmo(Integer tipmo) {			
	return em.createNamedQuery("TMovimEnca.findByCTipmId").setParameter("cTipmId",tipmo).getResultList();
    }
    
    @Override
    public List getListEstmo(Integer estmo) {			
	return em.createNamedQuery("TMovimEnca.findByCEstmovId").setParameter("cEstmovId",estmo).getResultList();
    }
      
                    
    @Override
	public TMovimEnca getMove(Integer move){		
		return (TMovimEnca) em.createNamedQuery("TMovimEnca.findByTMoveId").setParameter("tMoveId",move).getSingleResult();
	}

   @Override
	public TMovimEnca getCorrel(Integer anio, Integer correl){		
		return  (TMovimEnca) em.createNamedQuery("TMovimEnca.findByTMoveCorr").setParameter("tMoveCorr",correl).setParameter("tMoveAnio",anio).getSingleResult();
	}        
    
}
