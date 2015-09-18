/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRecepDeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TRecepDetaFacade extends AbstractFacade<TRecepDeta> implements TRecepDetaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TRecepDetaFacade() {
        super(TRecepDeta.class);
    }

    @Override
    public List<TRecepDeta> getListDet(Integer move) {
        return em.createNamedQuery("TRecepDeta.findByTRecepEncabId").setParameter("tReceId",move).getResultList();
    }

    @Override
    public List getList() {
        return em.createNamedQuery("TRecepDeta.findByTRecdId").getResultList();
    }
    
}
