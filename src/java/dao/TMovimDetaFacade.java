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
    
    
}
