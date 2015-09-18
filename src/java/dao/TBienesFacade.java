/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TBienes;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Date;
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
public class TBienesFacade extends AbstractFacade<TBienes> implements TBienesFacadeLocal {

    @PersistenceContext(unitName = "ActFijoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TBienesFacade() {
        super(TBienes.class);
    }

    @Override
    public List getList() {
        return em.createNamedQuery("TBienes.findAll").getResultList();
    }

    @Override
    public List getListL() {
        return em.createNamedQuery("TBienes.findByTBienInglote").setParameter("tBienInglote", TRUE).setParameter("tBienLoteingre", FALSE).getResultList();
    }

    @Override
    public List getListM(Integer respo) {
        return em.createNamedQuery("TBienes.findByResponsable").setParameter("cRespId", respo).getResultList();
    }
    
    @Override
    public List getListU(Integer ubic) {
        return em.createNamedQuery("TBienes.findByCUbicId").setParameter("cUbicId", ubic).getResultList();
    }

    @Override
    public List getListE(Integer espec) {
        return em.createNamedQuery("TBienes.findByCEspecId").setParameter("cEspecId", espec).getResultList();
    }
    
    @Override
    public List getListEB(Integer estb) {
        return em.createNamedQuery("TBienes.findByCEstadbId").setParameter("cEstadbId", estb).getResultList();
    }
    
    @Override
    public List getListCB(Integer conb) {
        return em.createNamedQuery("TBienes.findByCCondbId").setParameter("cCondbId", conb).getResultList();
    }
    
    @Override
    public List getListTD(Integer tipdes) {
        return em.createNamedQuery("TBienes.findByCTipdescId").setParameter("cTipdescId", tipdes).getResultList();
    }

    @Override
    public List getListEP(Integer estpro) {
        return em.createNamedQuery("TBienes.findByCEstproId").setParameter("cEstproId", estpro).getResultList();
    }
    
    @Override
    public List getListPV(Integer prov) {
        return em.createNamedQuery("TBienes.findByCProvId").setParameter("cProvId", prov).getResultList();
    }

    @Override
    public List getListPY(Integer proy) {
        return em.createNamedQuery("TBienes.findByCProyId").setParameter("cProyId", proy).getResultList();
    }
    
    @Override
    public List getListMB(Integer marca) {
        return em.createNamedQuery("TBienes.findByCMarcaId").setParameter("cMarcaId", marca).getResultList();
    }

    @Override
    public List getListFT(Integer fuente) {
        return em.createNamedQuery("TBienes.findByCFuentesId").setParameter("cFuentesId", fuente).getResultList();
    }

    @Override
    public List getListFM(Integer forma) {
        return em.createNamedQuery("TBienes.findByCFormadId").setParameter("cFormadId", forma).getResultList();
    }
    @Override
    public List busqueda(String desc) {

        String jpql = "SELECT m FROM TBienes m where 1=1";

        if (desc != null) {
            jpql += " AND UPPER(m.tBienDesc) like :desc";
        }

        Query query = em.createQuery(jpql);

        if (desc != null) {
            query.setParameter("Descripción", "%" + desc.toUpperCase() + "%");
        }

        return query.getResultList();

    }

    @Override
    public TBienes getBien(Integer bien) {
        return (TBienes) em.createNamedQuery("TBienes.findByTBienId").setParameter("tBienId", bien).getSingleResult();
    }

    @Override
    public TBienes getCodBien(String cod) {
        return (TBienes) em.createNamedQuery("TBienes.findByTBienCodigo").setParameter("tBienCodigo", cod).getSingleResult();
    }

   @Override
	public TBienes getIdCod(Integer cod){		
		return (TBienes) em.createNamedQuery("TBienes.findByTBienId").setParameter("tBienId",cod).getSingleResult();
	}
    
    @Override
    public Integer busCod(String cod) {
        Integer resul;
        String consuld = "SELECT count (s) from t_bienes AS s WHERE s.t_bien_codigo = ?1";
        Query qconsuld = em.createNativeQuery(consuld).setParameter(1, cod);
        resul = ((Long) qconsuld.getSingleResult()).intValue();
//    	System.out.println("query ejecutada en busDoc");
        return resul;
    }

    @Override
    public List datosI(String cod) {
        System.out.println("cod: " + cod);
        String consul = "SELECT * FROM t_bienes t WHERE t.t_bien_codigo = ?1";
        Query qconsul = em.createNativeQuery(consul).setParameter(1, cod);

//	 generando datos a replicar
        List ingresos = qconsul.getResultList();
       

        System.out.println("query ejecutada");
        System.out.println("tot: " + ingresos.size());
        return ingresos;
    }

    @Override
    public Integer updateL(Integer idcod, Date fecinl, String codini, String codfin) {
        String actualiz = "UPDATE t_bienes SET t_bien_fecinglote = ?2, t_bien_codinilot = ?3, t_bien_codfinlot = ?4, t_bien_loteingre = ?5 WHERE t_bien_id= ?1";
        Query qactual = em.createNativeQuery(actualiz).setParameter(1, idcod).setParameter(2, fecinl).setParameter(3, codini).setParameter(4, codfin).setParameter(5, true);
        int resultado = qactual.executeUpdate();
        return resultado;
    }
}
