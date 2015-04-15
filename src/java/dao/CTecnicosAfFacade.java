/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTecnicosAf;
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
public class CTecnicosAfFacade extends AbstractFacade<CTecnicosAf> implements CTecnicosAfFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CTecnicosAfFacade() {
        super(CTecnicosAf.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CTecnicosAf.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String nombre) {
			
		String jpql = "SELECT c FROM CTecnicosAf c where 1=1";
		
		if(nombre != null  ){
			jpql += " AND UPPER(c.cTecnicosAfNombre) like :nombre";
		}
		
		Query query = em.createQuery(jpql);
		
		if(nombre != null  ){
			query.setParameter("Nombre", "%"+nombre.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CTecnicosAf getTecAf(Integer tec){		
		return (CTecnicosAf) em.createNamedQuery("CTecnicosAf.findByCTecafId").setParameter("cTecafId",tec).getSingleResult();
	}
    
    
}
