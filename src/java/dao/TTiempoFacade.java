/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TTiempo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Teo de Renderos
 */
@Stateless
public class TTiempoFacade extends AbstractFacade<TTiempo> implements TTiempoFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TTiempoFacade() {
        super(TTiempo.class);
    }
    
	@Override
	public TTiempo getFecha(Date fech){		
		return (TTiempo) em.createNamedQuery(TTiempo.BUSCAR_FECHA).setParameter("tTmFecha",fech).getSingleResult();
	}
	
	public TTiempo getTm(Integer tm){		
		return (TTiempo) em.createNamedQuery(TTiempo.BUSCAR_UNA).setParameter("tTmId",tm).getSingleResult();
	}
	@Override
	public List getList() {			
		return em.createNamedQuery(TTiempo.BUSCAR_TODOS).getResultList();
	}    
    
}
