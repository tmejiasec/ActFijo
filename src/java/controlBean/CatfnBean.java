/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;


import dao.CDependenciasFacadeLocal;
import dao.CDeptosFacadeLocal;
import dao.CFuentesFinFacadeLocal;
import entidades.CFuentesFin;
import dao.CFormasAdqFacadeLocal;
import entidades.CFormasAdq;
import dao.CTipDocFacadeLocal;
import entidades.CTipDoc;
import dao.CProyectosFacadeLocal;
import entidades.CProyectos;
import dao.CProveedoresFacadeLocal;
import entidades.CProveedores;
import dao.CMarcasBmFacadeLocal;
import dao.CMunicFacadeLocal;
import dao.CNivelesFacadeLocal;
import dao.CResponsablesFacadeLocal;
import entidades.CDependencias;
import entidades.CDeptos;
import entidades.CMarcasBm;
import entidades.CMunic;
import entidades.CNiveles;
import entidades.CResponsables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import util.FacesUtil;

/**
 *
 * @author Teo de Renderos
 */
@ManagedBean
@SessionScoped
public class CatfnBean implements Serializable {
    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    private String desc;	
   
    private List<CFuentesFin> fuentes = new ArrayList<>();
    private CFuentesFin fuente;
    private CFuentesFin nuevaFuente = new CFuentesFin();
    private CFuentesFin fuenteSeleccionada = new CFuentesFin();
    private List<CFormasAdq> formas = new ArrayList<>();
    private CFormasAdq forma;
    private CFormasAdq nuevaForma = new CFormasAdq();
    private CFormasAdq formaSeleccionada = new CFormasAdq();
    private List<CTipDoc> tipdocs = new ArrayList<>();
    private CTipDoc tipdoc;
    private CTipDoc nuevoTipdoc = new CTipDoc();
    private CTipDoc tipdocSeleccionado = new CTipDoc();
    private List<CProyectos> proys = new ArrayList<>();
    private CProyectos proy;
    private CProyectos nuevoProy = new CProyectos();
    private CProyectos proySeleccionado = new CProyectos();
    private List<CProveedores> provs = new ArrayList<>();
    private CProveedores prov;
    private CProveedores nuevoProv = new CProveedores();
    private CProveedores provSeleccionado = new CProveedores();
    private List<CMarcasBm> marcas = new ArrayList<>();
    private CMarcasBm marca;
    private CMarcasBm nuevaMarca = new CMarcasBm();
    private CMarcasBm marcaSeleccionada = new CMarcasBm();
    private List<CDeptos> deptos = new ArrayList<>();
    private List<CMunic> munic = new ArrayList<>();
    private List<CResponsables> resps = new ArrayList<>();
    private List<CNiveles> niveles = new ArrayList<>();
    private List<CDependencias> depens = new ArrayList<>();
    private Integer depSeleccionado;
    private Integer depeSeleccionada;
    private Integer nivSeleccionado;
    private Integer munSeleccionado;
    private Integer ftefSeleccionada;
    private Integer respSeleccionado;
    
    /**
    /**
    /**
    /**
     * Creates a new instance 
     */
    public CatfnBean() {
	fuentes  =  getDaoFuentes().getList();
        formas  =  getDaoFormas().getList();
        tipdocs  =  getDaoTipdoc().getList();
        proys  =  getDaoProyec().getList();
        provs  =  getDaoProvee().getList();
        marcas  =  getDaoMarcas().getList();
        deptos  =  getDaoDeptos().getList();
        munic = getDaoMunic().getList();
        resps = getDaoRespon().getList();        
        niveles = getDaoNivel().getList();
        depens = getDaoDepen().getList();
    }
    
    public String buscarFf() throws NamingException {

        fuentes = getDaoFuentes().busqueda(desc);

        return null;
    }

    public String guardarFf() throws NamingException {
        getDaoFuentes().create(nuevaFuente);
        FacesUtil.addMensaje("Dato Guardado");
        nuevaFuente = new CFuentesFin();
        fuentes  =  getDaoFuentes().getList();
        return null;
    }

    public String actualFf() throws NamingException {
        getDaoFuentes().edit(fuenteSeleccionada);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarFf() throws NamingException {
        return null;
    }


    public String limpiarFf() {
        fuente = new CFuentesFin();
        return null;
    }

    public String guardarFa() throws NamingException {
        getDaoFormas().create(nuevaForma);
        FacesUtil.addMensaje("Dato Guardado");
        nuevaForma = new CFormasAdq();
        formas  =  getDaoFormas().getList();
        return null;
    }

    public String actualFa() throws NamingException {
        getDaoFormas().edit(formaSeleccionada);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarFa() throws NamingException {
        return null;
    }


    public String limpiarFa() {
        forma = new CFormasAdq();
        return null;
    }

    public String guardarTi() throws NamingException {
        getDaoTipdoc().create(nuevoTipdoc);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoTipdoc = new CTipDoc();
        tipdocs  =  getDaoTipdoc().getList();
        return null;
    }

    public String actualTi() throws NamingException {
        getDaoTipdoc().edit(tipdocSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarTi() throws NamingException {
        return null;
    }


    public String limpiarTi() {
        tipdoc = new CTipDoc();
        return null;
    }

    public String guardarPy() throws NamingException {
        nuevoProy.setCFuentesId(getDaoFuentes().getFuentef(ftefSeleccionada));
        nuevoProy.setCRespId(getDaoRespon().getResp(respSeleccionado));
        nuevoProy.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        nuevoProy.setCDepenId(getDaoDepen().getDepend(depeSeleccionada));
        nuevoProy.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        nuevoProy.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoProyec().create(nuevoProy);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoProy = new CProyectos();
        proys  =  getDaoProyec().getList();
        return null;
    }
    

    public String actualPy() throws NamingException {
        proySeleccionado.setCFuentesId(getDaoFuentes().getFuentef(ftefSeleccionada));
        proySeleccionado.setCRespId(getDaoRespon().getResp(respSeleccionado));
        proySeleccionado.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        proySeleccionado.setCDepenId(getDaoDepen().getDepend(depeSeleccionada));
        proySeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        proySeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoProyec().edit(proySeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarPy() throws NamingException {
        return null;
    }


    public String limpiarPy() {
        proy = new CProyectos();
        return null;
    }

    public String guardarPv() throws NamingException {
        nuevoProv.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        nuevoProv.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoProvee().create(nuevoProv);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoProv = new CProveedores();
        provs  =  getDaoProvee().getList();
        return null;
    }

    public String actualPv() throws NamingException {
        provSeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        provSeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoProvee().edit(provSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarPv() throws NamingException {
        return null;
    }


    public String limpiarPv() {
        prov = new CProveedores();
        return null;
    }

    public String guardarMb() throws NamingException {
        getDaoMarcas().create(nuevaMarca);
        FacesUtil.addMensaje("Dato Guardado");
        nuevaMarca = new CMarcasBm();
        marcas  =  getDaoMarcas().getList();
        return null;
    }

    public String actualMb() throws NamingException {
        getDaoMarcas().edit(marcaSeleccionada);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarMb() throws NamingException {
        return null;
    }


    public String limpiarMb() {
        marca = new CMarcasBm();
        return null;
    }

    
    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    private CFuentesFinFacadeLocal getDaoFuentes() {
        return (CFuentesFinFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CFuentesFinFacade!dao.CFuentesFinFacadeLocal");
    }

    private CFormasAdqFacadeLocal getDaoFormas() {
        return (CFormasAdqFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CFormasAdqFacade!dao.CFormasAdqFacadeLocal");
    }

    private CTipDocFacadeLocal getDaoTipdoc() {
        return (CTipDocFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTipDocFacade!dao.CTipDocFacadeLocal");
    }

    private CProyectosFacadeLocal getDaoProyec() {
        return (CProyectosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CProyectosFacade!dao.CProyectosFacadeLocal");
    }

    private CProveedoresFacadeLocal getDaoProvee() {
        return (CProveedoresFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CProveedoresFacade!dao.CProveedoresFacadeLocal");
    }

    private CMarcasBmFacadeLocal getDaoMarcas() {
        return (CMarcasBmFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CMarcasBmFacade!dao.CMarcasBmFacadeLocal");
    }

    private CDeptosFacadeLocal getDaoDeptos() {
        return (CDeptosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDeptosFacade!dao.CDeptosFacadeLocal");
    }

    private CMunicFacadeLocal getDaoMunic() {
        return (CMunicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CMunicFacade!dao.CMunicFacadeLocal");
    }
    
    private CResponsablesFacadeLocal getDaoRespon() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private CNivelesFacadeLocal getDaoNivel() {
        return (CNivelesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CNivelesFacade!dao.CNivelesFacadeLocal");
    }
    
    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }


    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<CFuentesFin> getFuentes() {
        return fuentes;
    }

    public void setFuentes(List<CFuentesFin> fuentes) {
        this.fuentes = fuentes;
    }

    public CFuentesFin getFuente() {
        return fuente;
    }

    public void setFuente(CFuentesFin fuente) {
        this.fuente = fuente;
    }

    public CFuentesFin getNuevaFuente() {
        return nuevaFuente;
    }

    public void setNuevaFuente(CFuentesFin nuevaFuente) {
        this.nuevaFuente = nuevaFuente;
    }

    public CFuentesFin getFuenteSeleccionada() {
        return fuenteSeleccionada;
    }

    public void setFuenteSeleccionada(CFuentesFin fuenteSeleccionada) {
        this.fuenteSeleccionada = fuenteSeleccionada;
    }

    public List<CFormasAdq> getFormas() {
        return formas;
    }

    public void setFormas(List<CFormasAdq> formas) {
        this.formas = formas;
    }

    public CFormasAdq getForma() {
        return forma;
    }

    public void setForma(CFormasAdq forma) {
        this.forma = forma;
    }

    public CFormasAdq getNuevaForma() {
        return nuevaForma;
    }

    public void setNuevaForma(CFormasAdq nuevaForma) {
        this.nuevaForma = nuevaForma;
    }

    public CFormasAdq getFormaSeleccionada() {
        return formaSeleccionada;
    }

    public void setFormaSeleccionada(CFormasAdq formaSeleccionada) {
        this.formaSeleccionada = formaSeleccionada;
    }

    public List<CTipDoc> getTipdocs() {
        return tipdocs;
    }

    public void setTipdocs(List<CTipDoc> tipdocs) {
        this.tipdocs = tipdocs;
    }

    public CTipDoc getTipdoc() {
        return tipdoc;
    }

    public void setTipdoc(CTipDoc tipdoc) {
        this.tipdoc = tipdoc;
    }

    public CTipDoc getNuevoTipdoc() {
        return nuevoTipdoc;
    }

    public void setNuevoTipdoc(CTipDoc nuevoTipdoc) {
        this.nuevoTipdoc = nuevoTipdoc;
    }

    public CTipDoc getTipdocSeleccionado() {
        return tipdocSeleccionado;
    }

    public void setTipdocSeleccionado(CTipDoc tipdocSeleccionado) {
        this.tipdocSeleccionado = tipdocSeleccionado;
    }

    public List<CProyectos> getProys() {
        return proys;
    }

    public void setProys(List<CProyectos> proys) {
        this.proys = proys;
    }

    public CProyectos getProy() {
        return proy;
    }

    public void setProy(CProyectos proy) {
        this.proy = proy;
    }

    public CProyectos getNuevoProy() {
        return nuevoProy;
    }

    public void setNuevoProy(CProyectos nuevoProy) {
        this.nuevoProy = nuevoProy;
    }

    public CProyectos getProySeleccionado() {
        return proySeleccionado;
    }

    public void setProySeleccionado(CProyectos proySeleccionado) {
        this.proySeleccionado = proySeleccionado;
    }

    public List<CProveedores> getProvs() {
        return provs;
    }

    public void setProvs(List<CProveedores> provs) {
        this.provs = provs;
    }

    public CProveedores getProv() {
        return prov;
    }

    public void setProv(CProveedores prov) {
        this.prov = prov;
    }

    public CProveedores getNuevoProv() {
        return nuevoProv;
    }

    public void setNuevoProv(CProveedores nuevoProv) {
        this.nuevoProv = nuevoProv;
    }

    public CProveedores getProvSeleccionado() {
        return provSeleccionado;
    }

    public void setProvSeleccionado(CProveedores provSeleccionado) {
        this.provSeleccionado = provSeleccionado;
    }

    public List<CMarcasBm> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<CMarcasBm> marcas) {
        this.marcas = marcas;
    }

    public CMarcasBm getMarca() {
        return marca;
    }

    public void setMarca(CMarcasBm marca) {
        this.marca = marca;
    }

    public CMarcasBm getNuevaMarca() {
        return nuevaMarca;
    }

    public void setNuevaMarca(CMarcasBm nuevaMarca) {
        this.nuevaMarca = nuevaMarca;
    }

    public CMarcasBm getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(CMarcasBm marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public Integer getDepSeleccionado() {
        return depSeleccionado;
    }

    public void setDepSeleccionado(Integer depSeleccionado) {
        this.depSeleccionado = depSeleccionado;
    }

    public Integer getMunSeleccionado() {
        return munSeleccionado;
    }

    public void setMunSeleccionado(Integer munSeleccionado) {
        this.munSeleccionado = munSeleccionado;
    }

    public Integer getFtefSeleccionada() {
        return ftefSeleccionada;
    }

    public void setFtefSeleccionada(Integer ftefSeleccionada) {
        this.ftefSeleccionada = ftefSeleccionada;
    }

    public Integer getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(Integer respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    
    public List<CDeptos> getDeptos() {
        return deptos;
    }

    public void setDeptos(List<CDeptos> deptos) {
        this.deptos = deptos;
    }

    public List<CMunic> getMunic() {
        return munic;
    }

    public void setMunic(List<CMunic> munic) {
        this.munic = munic;
    }

    public List<CResponsables> getResps() {
        return resps;
    }

    public void setResps(List<CResponsables> resps) {
        this.resps = resps;
    }

    public List<CNiveles> getNiveles() {
        return niveles;
    }

    public void setNiveles(List<CNiveles> niveles) {
        this.niveles = niveles;
    }

    public List<CDependencias> getDepens() {
        return depens;
    }

    public void setDepens(List<CDependencias> depens) {
        this.depens = depens;
    }

    public Integer getDepeSeleccionada() {
        return depeSeleccionada;
    }

    public void setDepeSeleccionada(Integer depeSeleccionada) {
        this.depeSeleccionada = depeSeleccionada;
    }

    public Integer getNivSeleccionado() {
        return nivSeleccionado;
    }

    public void setNivSeleccionado(Integer nivSeleccionado) {
        this.nivSeleccionado = nivSeleccionado;
    }
    
    public void municipioSeleccion() {
    munic = getDaoMunic().getListM(depSeleccionado);
    }


    public void asignarDeptoMuni(){
        munSeleccionado=provSeleccionado.getCMuniId().getCMuniId();
        depSeleccionado=provSeleccionado.getCDeptoId().getCDeptoId();
        munic = getDaoMunic().getListM(depSeleccionado);
    }    
    
    public void nivDepSeleccion() {
        nuevoProy.setCRespId(getDaoRespon().getResp(respSeleccionado));
        nivSeleccionado=nuevoProy.getCRespId().getCNivelId().getCNivelId();
        depeSeleccionada=nuevoProy.getCRespId().getCDepenId().getCDepenId();
        nuevoProy.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        nuevoProy.setCDepenId(getDaoDepen().getDepend(depeSeleccionada));
    }
    

    public void asignarDatProy() {
        respSeleccionado=proySeleccionado.getCRespId().getCRespId();
        nivSeleccionado=proySeleccionado.getCRespId().getCNivelId().getCNivelId();
        depeSeleccionada=proySeleccionado.getCRespId().getCDepenId().getCDepenId();
        ftefSeleccionada=proySeleccionado.getCFuentesId().getCFuentesId();
        depSeleccionado=proySeleccionado.getCDeptoId().getCDeptoId();
        munic = getDaoMunic().getListM(depSeleccionado);
        munSeleccionado=proySeleccionado.getCMuniId().getCMuniId();        

    }
    
    
   public void dependenciaSeleccion() {
    depens = getDaoDepen().getListM(nivSeleccionado);
    }    
    
   public void asignarNivelDep(){
        nivSeleccionado=proySeleccionado.getCNivelId().getCNivelId();
        depeSeleccionada=proySeleccionado.getCDepenId().getCDepenId();
	depens  =  getDaoDepen().getListM(nivSeleccionado);
    }
    
    
}

