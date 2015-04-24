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
    public List getListM(Short correl, Short anio) {			
	return em.createNamedQuery("TMovimEnca.findByT<TMoveCorr").setParameter("tMoveCorr",correl).getResultList();
    }
    
    @Override
	public TMovimEnca getMove(Integer move){		
		return (TMovimEnca) em.createNamedQuery("TMovimEnca.findByTMoveId").setParameter("tMoveId",move).getSingleResult();
	}


    
}
