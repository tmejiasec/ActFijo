/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRecepEnca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TRecepEncaFacade extends AbstractFacade<TRecepEnca> implements TRecepEncaFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TRecepEncaFacade() {
        super(TRecepEnca.class);
    }

    @Override
    public List getList() {
        return em.createNamedQuery("TRecepEnca.findAll").getResultList();
    }

    @Override
    public TRecepEnca getEnca(Integer mov) {
        return (TRecepEnca) em.createNamedQuery("TRecepEnca.findByTReceId").setParameter("tReceId", mov).getSingleResult();
    }

    @Override
    public List getListJ(Integer jefe) {			
	return em.createNamedQuery("TRecepEnca.findByCJefesId").setParameter("cJefesId",jefe).getResultList();
    }            
}
