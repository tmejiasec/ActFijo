/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TSegMov;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TSegMovFacade extends AbstractFacade<TSegMov> implements TSegMovFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TSegMovFacade() {
        super(TSegMov.class);
    }

       @Override
    public List getList() {			
	return em.createNamedQuery("TSegMov.findAll").getResultList();
    }
    
    @Override
    public List getListM(Integer move) {			
	return em.createNamedQuery("TSegMov.findByTMoveId").setParameter("tMoveId",move).getResultList();
    }
    
    @Override
	public TSegMov getSegM(Integer segm){		
		return (TSegMov) em.createNamedQuery("TSegMov.findByTSegId").setParameter("tSegId",segm).getSingleResult();
	}
    
    
}
