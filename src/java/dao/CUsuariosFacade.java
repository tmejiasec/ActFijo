/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CUsuarios;
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
public class CUsuariosFacade extends AbstractFacade<CUsuarios> implements CUsuariosFacadeLocal {
    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CUsuariosFacade() {
        super(CUsuarios.class);
    }
    
    @Override
    public List getList() {			
	return em.createNamedQuery("CUsuarios.findAll").getResultList();
    }
    
    @Override
    public List busqueda(String desc) {
			
		String jpql = "SELECT c FROM CUsuarios c where 1=1";
		
		if(desc != null  ){
			jpql += " AND UPPER(c.cUsuariosNombre) like :desc";
		}
		
		Query query = em.createQuery(jpql);
		
		if(desc != null  ){
			query.setParameter("Nombre", "%"+desc.toUpperCase()+"%");
		}
		
		return query.getResultList();
		
	}
    
    @Override
	public CUsuarios getUsuario(Integer usuario){		
		return (CUsuarios) em.createNamedQuery("CUsuarios.findByCUserId").setParameter("cUserId",usuario).getSingleResult();
	}
    
        public CUsuarios traeUsuarioLogeado(String nombre){
	        CUsuarios usuarioC=new CUsuarios();
	        try {
	            Query q=this.em.createNamedQuery("CUsuarios.findByCUserLogin");
	            q.setParameter("cUserLogin", nombre);
	            usuarioC=(CUsuarios) q.getSingleResult();
	            System.out.println("seleccionando usuario después de query");
	            System.out.println("nombre para prueba: "+usuarioC.getCUserNombre());
	            return usuarioC;
	            }catch (Exception e) {
	            return usuarioC;
	        }
	    }

 @Override
    public Integer busLogin(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from c_usuarios AS s WHERE s.c_user_login = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }        
}
