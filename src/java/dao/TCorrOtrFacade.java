/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TCorrOtr;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Soporte
 */
@Stateless
public class TCorrOtrFacade extends AbstractFacade<TCorrOtr> implements TCorrOtrFacadeLocal {

    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TCorrOtrFacade() {
        super(TCorrOtr.class);
    }


   
    @Override
    public List getList() {
        throw new UnsupportedOperationException("TCorrOtr.findAll"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateC(int anio, int nvoCorr, int idMovim) {
        String actualiz = "UPDATE t_corr_otr SET t_otroc_correl= ?2 WHERE t_otroc_id= ?3 AND t_otroc_anio= ?1";
        Query qactual = em.createNativeQuery(actualiz).setParameter(1, anio).setParameter(2, nvoCorr).setParameter(3, idMovim);
        int resultado = qactual.executeUpdate();
        return resultado;
    }

    @Override
    public TCorrOtr getTOtrocCorrel(int corId, int anio) {
        return  (TCorrOtr) em.createNamedQuery("TCorrOtr.findByTOtrocAnio").setParameter("tOtrocId", corId).setParameter("tOtrocAnio", anio).getSingleResult();
   }

    

    

}
