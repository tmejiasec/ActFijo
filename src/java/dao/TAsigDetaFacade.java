/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TAsigDeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TAsigDetaFacade extends AbstractFacade<TAsigDeta> implements TAsigDetaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TAsigDetaFacade() {
        super(TAsigDeta.class);
    }

    @Override
    public List<TAsigDeta> getListDet(Integer move) {
        return em.createNamedQuery("TAsigDeta.findByTAsigEncabId").setParameter("tAsigeId",move).getResultList();
    }

    @Override
    public List<TAsigDeta> getListM(Integer move) {
        return em.createNamedQuery("TMovimDeta.findByTAsigEncabId").setParameter("tMoveId",move).getResultList();
    }

    @Override
    public List getList() {
        return em.createNamedQuery("TAsigDeta.findAll").getResultList();
    }
    
}
