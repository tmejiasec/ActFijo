
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import dao.CNivelesFacadeLocal;
import entidades.CNiveles;
import dao.CDependenciasFacadeLocal;
import entidades.CDependencias;
import dao.CJefesDepFacadeLocal;
import entidades.CJefesDep;
import dao.CJefesDepFacadeLocal;
import entidades.CTecnicosAf;
import dao.CTecnicosAfFacadeLocal;
import entidades.CEdificios;
import dao.CAreasFacadeLocal;
import entidades.CAreas;
import dao.CUbicFacadeLocal;
import entidades.CUbic;
import dao.CResponsablesFacadeLocal;
import entidades.CResponsables;
import dao.CZonasFacadeLocal;
import entidades.CZonas;
import dao.CDeptosFacadeLocal;
import dao.CEdificiosFacadeLocal;
import entidades.CDeptos;
import dao.CMunicFacadeLocal;
import dao.TAsigEncaFacadeLocal;
import dao.TBienesFacadeLocal;
import dao.TDescargEncaFacadeLocal;
import dao.TMovimEncaFacadeLocal;
import dao.TRecepEncaFacadeLocal;
import dao.TRobHurFacadeLocal;
import dao.TSustitFacadeLocal;
import entidades.CMunic;
import entidades.TAsigEnca;
import entidades.TBienes;
import entidades.TDescargEnca;
import entidades.TMovimEnca;
import entidades.TRecepEnca;
import entidades.TRobHur;
import entidades.TSustit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import util.FacesUtil;

/**
 *
 * @author Teo de Renderos
 */
@ManagedBean
@SessionScoped
public class CatgeBean implements Serializable {

//    @EJB
//    private CNivelesFacadeLocal cNivelesFacade;

    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    protected Boolean estado = false;
    protected Boolean estadoD = false;
    private String desc, nombre;
    private List<CNiveles> niveles = new ArrayList<>();
    private CNiveles nivel;
    private CNiveles nuevoNivel = new CNiveles();
    private CNiveles nivelSeleccionado = new CNiveles();
    private int jerarq;
    private List<CDependencias> depens = new ArrayList<>();
     private List<CDependencias> depenf = new ArrayList<>();
    private CDependencias depen;
    private Integer nivSeleccionado;
    private CDependencias nuevaDep = new CDependencias();
    private CDependencias depSeleccionada = new CDependencias();
    private Integer depenSeleccionada;
    private List<CJefesDep> jefes = new ArrayList<>();
    private CJefesDep jefe;
    private CJefesDep nuevoJefe = new CJefesDep();
    private CJefesDep jefeSeleccionado = new CJefesDep();
    private Integer jefSeleccionado;
    private List<CTecnicosAf> tecnicos = new ArrayList<>();
    private CTecnicosAf tecnico;
    private CTecnicosAf nuevoTec = new CTecnicosAf();
    private CTecnicosAf tecSeleccionado = new CTecnicosAf();
    private Integer tecniSeleccionado;
    
    private List<CEdificios> edificios = new ArrayList<>();
    private CEdificios edificio;
    private String descrip;
    private CEdificios nuevoEdificio = new CEdificios();
    private CEdificios edifSeleccionado = new CEdificios();
    private List<CAreas> areas = new ArrayList<>();
    private CAreas area;
    private Integer ediSeleccionado;
    private CAreas nuevaArea = new CAreas();
    private CAreas areaSeleccionada = new CAreas();
    private List<CUbic> ubics = new ArrayList<>();
    private CUbic ubic;
    private Integer areSeleccionada;
    private CUbic nuevaUbic = new CUbic();
    private Integer ubicaSel;
    private CUbic ubicSeleccionada = new CUbic();
    private List<CResponsables> respons = new ArrayList<>();
    private CResponsables respon;
    private CResponsables nuevoResp = new CResponsables();
    private CResponsables respSeleccionado = new CResponsables();
    private Integer respoSeleccionado;
    private List<CZonas> zonas = new ArrayList<>();
    private CZonas zona;
    private CZonas nuevaZona = new CZonas();
    private CZonas zonaSeleccionada = new CZonas();
    private List<CDeptos> deptos = new ArrayList<>();
    private CDeptos depto;
    private CDeptos nuevoDepto = new CDeptos();
    private CDeptos deptoSeleccionado = new CDeptos();
    private List<CMunic> munic = new ArrayList<>();
    private CMunic muni;
    private CMunic nuevoMuni = new CMunic();
    private CMunic muniSeleccionado = new CMunic();
    private Integer depSeleccionado;
    private Integer munSeleccionado;
    private Integer zonSeleccionada;
    private List<TAsigEnca> asig = new ArrayList<>();
    private List<TRecepEnca> recep = new ArrayList<>();
    private List<TDescargEnca> descarg = new ArrayList<>();
    private List<TMovimEnca> movim = new ArrayList<>();
    private List<TRobHur> robos = new ArrayList<>();
    private List<TSustit> susti = new ArrayList<>();
    private List<TBienes> bienes = new ArrayList<>();
    /**
     * Creates a new instance
     */
    public CatgeBean() {
        niveles = getDaoNivel().getList();
        depens = getDaoDepen().getList();
        jefes = getDaoJefes().getList();
        deptos = getDaoDeptos().getList();
        munic = getDaoMunic().getList();
        edificios = getDaoEdif().getList();
        areas = getDaoArea().getList();
        ubics = getDaoUbic().getList();
        respons = getDaoResp().getList();
        zonas = getDaoZona().getList();
        tecnicos = getDaoTecaf().getList();     
    }

    public String buscarNv() throws NamingException {
        niveles = getDaoNivel().busqueda(desc);
        return null;
    }

    public String guardarNv() throws NamingException {
        getDaoNivel().create(nuevoNivel);
        FacesUtil.addMensaje("Nivel Guardado");
        nuevoNivel = new CNiveles();
        niveles = getDaoNivel().getList();
        return null;
    }

    public String actualNv() throws NamingException {
        getDaoNivel().edit(nivelSeleccionado);
        FacesUtil.addMensaje("Nivel Actualizado");
        return null;
    }

    public String borrarNv() throws NamingException {
 	nivSeleccionado = nivelSeleccionado.getCNivelId();
        depenf = getDaoDepen().getListM(nivSeleccionado);
	Integer resuldet=0;
	if (depenf.isEmpty()){
             FacesUtil.addMensaje("Nivel eliminado satisfactoriamente");
	getDaoNivel().remove(nivelSeleccionado);
	nuevoNivel = new CNiveles();
            
	}
	else{
        FacesUtil.addMensaje("Nivel no puede borrarse ya que hay Dependencias asociadas");
	}
        return null;
    }

    public String limpiarNv() {
        nivel = new CNiveles();
        return null;
    }

    public String buscarDp() throws NamingException {

        depenf = getDaoDepen().busqueda(desc);

        return null;
    }

    public String guardarDp() throws NamingException {
        nuevaDep.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        getDaoDepen().create(nuevaDep);
        FacesUtil.addMensaje("Dependencia Guardada");
        nuevaDep = new CDependencias();
        depens = getDaoDepen().getList();
        return null;
    }

    public String actualDp() throws NamingException {
        depSeleccionada.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        getDaoDepen().edit(depSeleccionada);
        FacesUtil.addMensaje("Dependencia Actualizado");
        return null;
    }

    public String borrarDp() throws NamingException {
 	depenSeleccionada = depSeleccionada.getCDepenId();
        jefes = getDaoJefes().getListM(depenSeleccionada);
        areas = getDaoArea().getListD(depenSeleccionada);
        System.out.println("registros asociados: "+jefes.size());
	Integer resuldet=0;
	if (jefes.isEmpty() && areas.isEmpty() ){
             FacesUtil.addMensaje("Dependencia eliminada satisfactoriamente");
	getDaoDepen().remove(depSeleccionada);
	nuevaDep = new CDependencias();
            
	}
	else{
        FacesUtil.addMensaje("Dependencia no puede borrarse ya que tiene datos asociados");
	}
        return null;
    }

    public String limpiarDp() {
        depen = new CDependencias();
        return null;
    }

    public String buscarJd() throws NamingException {

        jefes = getDaoJefes().busqueda(nombre);

        return null;
    }

    public String guardarJd() throws NamingException {
        nuevoJefe.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoJefes().create(nuevoJefe);
        FacesUtil.addMensaje("Jefe de Dependencia Guardado");
        nuevoJefe = new CJefesDep();
        jefes = getDaoJefes().getList();
        return null;
    }

    public String actualJd() throws NamingException {
        jefeSeleccionado.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoJefes().edit(jefeSeleccionado);
        FacesUtil.addMensaje("Jefe de Dependencia Actualizado");
        return null;
    }

    public String borrarJd() throws NamingException {
      	jefSeleccionado = jefeSeleccionado.getCJefesdId();
        asig = getDaoAsig().getListJ(jefSeleccionado);
        recep = getDaoRecep().getListJ(jefSeleccionado);
        descarg = getDaoDesca().getListJ(jefSeleccionado);
        movim = getDaoMovim().getListJ(jefSeleccionado);
        robos = getDaoRobHur().getListJ(jefSeleccionado);
        susti = getDaoSusti().getListJ(jefSeleccionado);
        
	Integer resuldet=0;
	if (asig.isEmpty() && recep.isEmpty() && descarg.isEmpty() && movim.isEmpty() && robos.isEmpty() && susti.isEmpty()){
             FacesUtil.addMensaje("Jefe eliminado satisfactoriamente");
	getDaoJefes().remove(jefeSeleccionado);
	nuevoJefe = new CJefesDep();
        jefes = getDaoJefes().getList();            
	}
	else{
        FacesUtil.addMensaje("Jefe no puede borrarse ya que hay movimientos asociadas. Debe dejarlo en estado INACTIVO");
	}
        return null;
    }

    public String limpiarJd() {
        jefe = new CJefesDep();
        return null;
    }

    public String buscarTaf() throws NamingException {

        jefes = getDaoTecaf().busqueda(nombre);

        return null;
    }

    public String guardarTaf() throws NamingException {
        System.out.println("id jef "+jefSeleccionado);
        nuevoTec.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        nuevoTec.setCJefesdId(getDaoJefes().getJefeDep(jefSeleccionado));
        getDaoTecaf().create(nuevoTec);
        FacesUtil.addMensaje("Técnico Activo Fijo Guardado");
        nuevoTec = new CTecnicosAf();
        tecnicos = getDaoTecaf().getList();
        return null;
    }

    public String actualTaf() throws NamingException {
        tecSeleccionado.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        tecSeleccionado.setCJefesdId(getDaoJefes().getJefeDep(jefSeleccionado));
        getDaoTecaf().edit(tecSeleccionado);
        FacesUtil.addMensaje("Técnico Activo Fijo Actualizado");
        return null;
    }

    public String borrarTaf() throws NamingException {
        return null;
    }

    public String limpiarTaf() {
        tecnico = new CTecnicosAf();
        return null;
    }
    
    
    public String buscarEd() throws NamingException {

        edificios = getDaoEdif().busqueda(descrip);

        return null;
    }

    public String guardarEd() throws NamingException {
        nuevoEdificio.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        nuevoEdificio.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoEdif().create(nuevoEdificio);
        FacesUtil.addMensaje("Datos de Edificio Guardados");
        nuevoEdificio = new CEdificios();
        edificios = getDaoEdif().getList();
        return null;
    }

    public String actualEd() throws NamingException {
        edifSeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
        edifSeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoEdif().edit(edifSeleccionado);
        FacesUtil.addMensaje("Datos de Edificio Actualizados");
        return null;
    }

    public String borrarEd() throws NamingException {
	ediSeleccionado = edifSeleccionado.getCEdifId();
        areas = getDaoArea().getListM(ediSeleccionado);
	Integer resuldet=0;
	if (areas.isEmpty()){
             FacesUtil.addMensaje("Edificio eliminado satisfactoriamente");
	getDaoEdif().remove(edifSeleccionado);
	nuevoEdificio = new CEdificios();
        edificios = getDaoEdif().getList();            
	}
	else{
        FacesUtil.addMensaje("Edificio no puede borrarse ya que hay dependencias asociadas.");
	}        
        return null;
    }

    public String limpiarEd() {
        edificio = new CEdificios();
        return null;
    }

    public String buscarAr() throws NamingException {

        areas = getDaoArea().busqueda(desc);

        return null;
    }

    public String guardarAr() throws NamingException {
        nuevaArea.setCEdifId(getDaoEdif().getEdif(ediSeleccionado));
        nuevaArea.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoArea().create(nuevaArea);
        FacesUtil.addMensaje("Datos de Area Guardados");
        nuevaArea = new CAreas();
        areas = getDaoArea().getList();
        return null;
    }

    public String actualAr() throws NamingException {
        areaSeleccionada.setCEdifId(getDaoEdif().getEdif(ediSeleccionado));
        areaSeleccionada.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoArea().edit(areaSeleccionada);
        FacesUtil.addMensaje("Datos de Area Actualizados");
        return null;
    }

    public String borrarAr() throws NamingException {
 	areSeleccionada = areaSeleccionada.getCAreaId();
        ubics = getDaoUbic().getListA(areSeleccionada);
	Integer resuldet=0;
	if (ubics.isEmpty()){
             FacesUtil.addMensaje("Dependencia por Edificio eliminada satisfactoriamente");
	getDaoArea().remove(areaSeleccionada);
	nuevaArea = new CAreas();
            
	}
	else{
        FacesUtil.addMensaje("Dependencia no puede borrarse ya que tiene datos asociados");
	}
        
        return null;
    }

    public String limpiarAr() {
        area = new CAreas();
        return null;
    }

    public String buscarUb() throws NamingException {

        areas = getDaoUbic().busqueda(desc);

        return null;
    }

    public String guardarUb() throws NamingException {
        nuevaUbic.setCEdifId(getDaoEdif().getEdif(ediSeleccionado));
        nuevaUbic.setCAreaId(getDaoArea().getArea(areSeleccionada));
        getDaoUbic().create(nuevaUbic);
        FacesUtil.addMensaje("Datos de Ubicación Guardados");
        nuevaUbic = new CUbic();
        ubics = getDaoUbic().getList();
        return null;
    }

    public String actualUb() throws NamingException {
        ubicSeleccionada.setCEdifId(getDaoEdif().getEdif(ediSeleccionado));
        ubicSeleccionada.setCAreaId(getDaoArea().getArea(areSeleccionada));
        getDaoUbic().edit(ubicSeleccionada);
        FacesUtil.addMensaje("Datos de Ubicación Actualizados");
        return null;
    }

    public String borrarUb() throws NamingException {
        ubicaSel = ubicSeleccionada.getCUbicId();
        bienes = getDaoBienes().getListU(ubicaSel);
	Integer resuldet=0;
	if (bienes.isEmpty()){
             FacesUtil.addMensaje("Area por Dependencia eliminada satisfactoriamente");
	getDaoUbic().remove(ubicSeleccionada);
	nuevaUbic = new CUbic();
        ubics = getDaoUbic().getList();            
	}
	else{
        FacesUtil.addMensaje("Area por Dependencia no puede borrarse ya que tiene bienes asociados");
	}
        return null;
    }

    public String limpiarUb() {
        ubic = new CUbic();
        return null;
    }

    public String buscarRp() throws NamingException {

        respons = getDaoResp().busqueda(descrip);

        return null;
    }

    public String guardarRp() throws NamingException {
        nuevoResp.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        nuevoResp.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoResp().create(nuevoResp);
        FacesUtil.addMensaje("Datos de Responsable Guardados");
        nuevoResp = new CResponsables();
        respons = getDaoResp().getList();
        return null;
    }

    public String actualRp() throws NamingException {
        respSeleccionado.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
        respSeleccionado.setCDepenId(getDaoDepen().getDepend(depenSeleccionada));
        getDaoResp().edit(respSeleccionado);
        FacesUtil.addMensaje("Datos de Responsable Actualizados");
        return null;
    }

    public String borrarRp() throws NamingException {
      	respoSeleccionado = respSeleccionado.getCRespId();
        bienes = getDaoBienes().getListM(respoSeleccionado);
	Integer resuldet=0;
	if (bienes.isEmpty()){
             FacesUtil.addMensaje("Responsable eliminado satisfactoriamente");
	getDaoResp().remove(respSeleccionado);
	nuevoResp = new CResponsables();
        respons = getDaoResp().getList();            
	}
	else{
        FacesUtil.addMensaje("Responsable no puede borrarse ya que hay movimientos asociadas. Debe dejarlo en estado INACTIVO");
	}
        return null;
    }

    public String limpiarRp() {
        respon = new CResponsables();
        return null;
    }

    public String buscarZn() throws NamingException {

        respons = getDaoZona().busqueda(desc);

        return null;
    }

    public String guardarZn() throws NamingException {
//        nuevoEdificio.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        nuevoEdificio.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoZona().create(nuevaZona);
        FacesUtil.addMensaje("Datos de Zona Guardados");
        nuevaZona = new CZonas();
        zonas = getDaoZona().getList();
        return null;
    }

    public String actualZn() throws NamingException {
//        edifSeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        edifSeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoZona().edit(zonaSeleccionada);
        FacesUtil.addMensaje("Datos de Zona Actualizados");
        return null;
    }

    public String borrarZn() throws NamingException {
        return null;
    }

    public String buscarDt() throws NamingException {

        deptos = getDaoDeptos().busqueda(desc);

        return null;
    }

    public String guardarDt() throws NamingException {
//        nuevoEdificio.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        nuevoEdificio.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoDeptos().create(nuevoDepto);
        FacesUtil.addMensaje("Datos de Departamento Guardados");
        nuevoDepto = new CDeptos();
        deptos = getDaoDeptos().getList();
        return null;
    }

    public String actualDt() throws NamingException {
//        edifSeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        edifSeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoDeptos().edit(deptoSeleccionado);
        FacesUtil.addMensaje("Datos de Departamento Actualizados");
        return null;
    }

    public String borrarDt() throws NamingException {
        return null;
    }

    public String limpiarDt() {
        depto = new CDeptos();
        return null;
    }

    public String buscarMn() throws NamingException {

        munic = getDaoMunic().busqueda(desc);

        return null;
    }

    public String guardarMn() throws NamingException {
        nuevoMuni.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        nuevoEdificio.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoMunic().create(nuevoMuni);
        FacesUtil.addMensaje("Datos de Municipio Guardados");
        nuevoMuni = new CMunic();
        munic = getDaoMunic().getList();
        return null;
    }

    public String actualMn() throws NamingException {
        muniSeleccionado.setCDeptoId(getDaoDeptos().getDepto(depSeleccionado));
//        edifSeleccionado.setCMuniId(getDaoMunic().getMuni(munSeleccionado));
        getDaoMunic().edit(muniSeleccionado);
        FacesUtil.addMensaje("Datos de Municipio Actualizados");
        return null;
    }

    public String borrarMn() throws NamingException {
        return null;
    }

    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    private CNivelesFacadeLocal getDaoNivel() {
        return (CNivelesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CNivelesFacade!dao.CNivelesFacadeLocal");
    }

    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CJefesDepFacadeLocal getDaoJefes() {
        return (CJefesDepFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CJefesDepFacade!dao.CJefesDepFacadeLocal");
    }

    private CEdificiosFacadeLocal getDaoEdif() {
        return (CEdificiosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEdificiosFacade!dao.CEdificiosFacadeLocal");
    }
    
    private CTecnicosAfFacadeLocal getDaoTecaf() {
        return (CTecnicosAfFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTecnicosAfFacade!dao.CTecnicosAfFacadeLocal");
    }

    private CDeptosFacadeLocal getDaoDeptos() {
        return (CDeptosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDeptosFacade!dao.CDeptosFacadeLocal");
    }

    private CMunicFacadeLocal getDaoMunic() {
        return (CMunicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CMunicFacade!dao.CMunicFacadeLocal");
    }

    private CAreasFacadeLocal getDaoArea() {
        return (CAreasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CAreasFacade!dao.CAreasFacadeLocal");
    }

    private CUbicFacadeLocal getDaoUbic() {
        return (CUbicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CUbicFacade!dao.CUbicFacadeLocal");
    }

    private CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private CZonasFacadeLocal getDaoZona() {
        return (CZonasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CZonasFacade!dao.CZonasFacadeLocal");
    }

    private TAsigEncaFacadeLocal getDaoAsig() {
        return (TAsigEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TAsigEncaFacade!dao.TAsigEncaFacadeLocal");
    }
    
    private TRecepEncaFacadeLocal getDaoRecep() {
        return (TRecepEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TRecepEncaFacade!dao.TRecepEncaFacadeLocal");
    }
    
    private TDescargEncaFacadeLocal getDaoDesca() {
        return (TDescargEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TDescargEncaFacade!dao.TDescargEncaFacadeLocal");
    }

    private TMovimEncaFacadeLocal getDaoMovim() {
        return (TMovimEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TMovimEncaFacade!dao.TMovimEncaFacadeLocal");
    }
    
    private TRobHurFacadeLocal getDaoRobHur() {
        return (TRobHurFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TRobHurFacade!dao.TRobHurFacadeLocal");
    }

    private TSustitFacadeLocal getDaoSusti() {
        return (TSustitFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TSustitFacade!dao.TSustitFacadeLocal");
    }

    private TBienesFacadeLocal getDaoBienes() {
        return (TBienesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TBienesFacade!dao.TBienesFacadeLocal");
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<CNiveles> getNiveles() {
        return getDaoNivel().getList();
    }

//    public List<CNiveles> getAllNiveles() {
//        return cNivelesFacade.findAll();
//    }

    public void setNiveles(List<CNiveles> niveles) {
        this.niveles = niveles;
    }

    public CNiveles getNivel() {
        return nivel;
    }

    public void setNivel(CNiveles nivel) {
        this.nivel = nivel;
    }

    public CNiveles getNuevoNivel() {
        return nuevoNivel;
    }

    public void setNuevoNivel(CNiveles nuevoNivel) {
        this.nuevoNivel = nuevoNivel;
    }

    public CNiveles getNivelSeleccionado() {
        return nivelSeleccionado;
    }

    public void setNivelSeleccionado(CNiveles nivelSeleccionado) {
        this.nivelSeleccionado = nivelSeleccionado;
    }

    public int getJerarq() {
        return jerarq;
    }

    public void setJerarq(int jerarq) {
        this.jerarq = jerarq;
    }

    public List<CDependencias> getDepens() {
        return depens;
    }

    public void setDepens(List<CDependencias> depens) {
        this.depens = depens;
    }

    public List<CDependencias> getDepenf() {
        return depenf;
    }

    public void setDepenf(List<CDependencias> depenf) {
        this.depenf = depenf;
    }

    public CDependencias getDepen() {
        return depen;
    }

    public void setDepen(CDependencias depen) {
        this.depen = depen;
    }

    public Integer getNivSeleccionado() {
        return nivSeleccionado;
    }

    public void setNivSeleccionado(Integer nivSeleccionado) {
        this.nivSeleccionado = nivSeleccionado;
    }

    public CDependencias getNuevaDep() {
        return nuevaDep;
    }

    public void setNuevaDep(CDependencias nuevaDep) {
        this.nuevaDep = nuevaDep;
    }

    public CDependencias getDepSeleccionada() {
        return depSeleccionada;
    }

    public void setDepSeleccionada(CDependencias depSeleccionada) {
        this.depSeleccionada = depSeleccionada;
    }

    public List<CJefesDep> getJefes() {
        return jefes;
    }

    public void setJefes(List<CJefesDep> jefes) {
        this.jefes = jefes;
    }

    public CJefesDep getJefe() {
        return jefe;
    }

    public void setJefe(CJefesDep jefe) {
        this.jefe = jefe;
    }

    public Integer getDepenSeleccionada() {
        return depenSeleccionada;
    }

    public void setDepenSeleccionada(Integer depenSeleccionada) {
        this.depenSeleccionada = depenSeleccionada;
    }

    public CJefesDep getNuevoJefe() {
        return nuevoJefe;
    }

    public void setNuevoJefe(CJefesDep nuevoJefe) {
        this.nuevoJefe = nuevoJefe;
    }

    public CJefesDep getJefeSeleccionado() {
        return jefeSeleccionado;
    }

    public void setJefeSeleccionado(CJefesDep jefeSeleccionado) {
        this.jefeSeleccionado = jefeSeleccionado;
    }

    public Integer getJefSeleccionado() {
        return jefSeleccionado;
    }

    public void setJefSeleccionado(Integer jefSeleccionado) {
        this.jefSeleccionado = jefSeleccionado;
    }

    public List<CTecnicosAf> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<CTecnicosAf> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public CTecnicosAf getTecnico() {
        return tecnico;
    }

    public void setTecnico(CTecnicosAf tecnico) {
        this.tecnico = tecnico;
    }

    public CTecnicosAf getNuevoTec() {
        return nuevoTec;
    }

    public void setNuevoTec(CTecnicosAf nuevoTec) {
        this.nuevoTec = nuevoTec;
    }

    public CTecnicosAf getTecSeleccionado() {
        return tecSeleccionado;
    }

    public void setTecSeleccionado(CTecnicosAf tecSeleccionado) {
        this.tecSeleccionado = tecSeleccionado;
    }

    public Integer getTecniSeleccionado() {
        return tecniSeleccionado;
    }

    public void setTecniSeleccionado(Integer tecniSeleccionado) {
        this.tecniSeleccionado = tecniSeleccionado;
    }

    public List<CEdificios> getEdificios() {
        return edificios;
    }

    public void setEdificios(List<CEdificios> edificios) {
        this.edificios = edificios;
    }

    public CEdificios getEdificio() {
        return edificio;
    }

    public void setEdificio(CEdificios edificio) {
        this.edificio = edificio;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public CEdificios getNuevoEdificio() {
        return nuevoEdificio;
    }

    public void setNuevoEdificio(CEdificios nuevoEdificio) {
        this.nuevoEdificio = nuevoEdificio;
    }

    public CEdificios getEdifSeleccionado() {
        return edifSeleccionado;
    }

    public void setEdifSeleccionado(CEdificios edifSeleccionado) {
        this.edifSeleccionado = edifSeleccionado;
    }

    public Integer getUbicaSel() {
        return ubicaSel;
    }

    public void setUbicaSel(Integer ubicaSel) {
        this.ubicaSel = ubicaSel;   
    }

    public List<CAreas> getAreas() {
        return areas;
    }

    public void setAreas(List<CAreas> areas) {
        this.areas = areas;
    }

    public CAreas getArea() {
        return area;
    }

    public void setArea(CAreas area) {
        this.area = area;
    }

    public Integer getEdiSeleccionado() {
        return ediSeleccionado;
    }

    public void setEdiSeleccionado(Integer ediSeleccionado) {
        this.ediSeleccionado = ediSeleccionado;
    }

    public CAreas getNuevaArea() {
        return nuevaArea;
    }

    public void setNuevaArea(CAreas nuevaArea) {
        this.nuevaArea = nuevaArea;
    }

    public CAreas getAreaSeleccionada() {
        return areaSeleccionada;
    }

    public void setAreaSeleccionada(CAreas areaSeleccionada) {
        this.areaSeleccionada = areaSeleccionada;
    }

    public List<CUbic> getUbics() {
        return ubics;
    }

    public void setUbics(List<CUbic> ubics) {
        this.ubics = ubics;
    }

    public CUbic getUbic() {
        return ubic;
    }

    public void setUbic(CUbic ubic) {
        this.ubic = ubic;
    }

    public Integer getAreSeleccionada() {
        return areSeleccionada;
    }

    public void setAreSeleccionada(Integer areSeleccionada) {
        this.areSeleccionada = areSeleccionada;
    }

    public CUbic getNuevaUbic() {
        return nuevaUbic;
    }

    public void setNuevaUbic(CUbic nuevaUbic) {
        this.nuevaUbic = nuevaUbic;
    }

    public CUbic getUbicSeleccionada() {
        return ubicSeleccionada;
    }

    public void setUbicSeleccionada(CUbic ubicSeleccionada) {
        this.ubicSeleccionada = ubicSeleccionada;
    }

    public List<CResponsables> getRespons() {
        return respons;
    }

    public void setRespons(List<CResponsables> respons) {
        this.respons = respons;
    }

    public CResponsables getRespon() {
        return respon;
    }

    public void setRespon(CResponsables respon) {
        this.respon = respon;
    }

    public CResponsables getNuevoResp() {
        return nuevoResp;
    }

    public void setNuevoResp(CResponsables nuevoResp) {
        this.nuevoResp = nuevoResp;
    }

    public CResponsables getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(CResponsables respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    public List<CZonas> getZonas() {
        return zonas;
    }

    public void setZonas(List<CZonas> zonas) {
        this.zonas = zonas;
    }

    public CZonas getZona() {
        return zona;
    }

    public void setZona(CZonas zona) {
        this.zona = zona;
    }

    public CZonas getNuevaZona() {
        return nuevaZona;
    }

    public void setNuevaZona(CZonas nuevaZona) {
        this.nuevaZona = nuevaZona;
    }

    public CZonas getZonaSeleccionada() {
        return zonaSeleccionada;
    }

    public void setZonaSeleccionada(CZonas zonaSeleccionada) {
        this.zonaSeleccionada = zonaSeleccionada;
    }

    public List<CDeptos> getDeptos() {
        return deptos;
    }

    public void setDeptos(List<CDeptos> deptos) {
        this.deptos = deptos;
    }

    public CDeptos getDepto() {
        return depto;
    }

    public void setDepto(CDeptos depto) {
        this.depto = depto;
    }

    public CDeptos getNuevoDepto() {
        return nuevoDepto;
    }

    public void setNuevoDepto(CDeptos nuevoDepto) {
        this.nuevoDepto = nuevoDepto;
    }

    public CDeptos getDeptoSeleccionado() {
        return deptoSeleccionado;
    }

    public void setDeptoSeleccionado(CDeptos deptoSeleccionado) {
        this.deptoSeleccionado = deptoSeleccionado;
    }

    public List<CMunic> getMunic() {
        return munic;
    }

    public void setMunic(List<CMunic> munic) {
        this.munic = munic;
    }

    public CMunic getMuni() {
        return muni;
    }

    public void setMuni(CMunic muni) {
        this.muni = muni;
    }

    public CMunic getNuevoMuni() {
        return nuevoMuni;
    }

    public void setNuevoMuni(CMunic nuevoMuni) {
        this.nuevoMuni = nuevoMuni;
    }

    public CMunic getMuniSeleccionado() {
        return muniSeleccionado;
    }

    public void setMuniSeleccionado(CMunic muniSeleccionado) {
        this.muniSeleccionado = muniSeleccionado;
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

    public Integer getZonSeleccionada() {
        return zonSeleccionada;
    }

    public void setZonSeleccionada(Integer zonSeleccionada) {
        this.zonSeleccionada = zonSeleccionada;
    }

    public Integer getRespoSeleccionado() {
        return respoSeleccionado;
    }

    public void setRespoSeleccionado(Integer respoSeleccionado) {
        this.respoSeleccionado = respoSeleccionado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoD() {
        return estadoD;
    }

    public void setEstadoD(Boolean estadoD) {
        this.estadoD = estadoD;
    }

    public void asignarNivel() {
        nivSeleccionado = depSeleccionada.getCNivelId().getCNivelId();
    }

    public void asignarZona() {
        zonSeleccionada = deptoSeleccionado.getCZonaId().getCZonaId();
    }

    public void asignarDepto() {
        depSeleccionado = muniSeleccionado.getCDeptoId().getCDeptoId();
    }

    public void asignarDepen() {
        depenSeleccionada = jefeSeleccionado.getCDepenId().getCDepenId();
    }

    public void asignarDepenT() {
        depenSeleccionada = tecSeleccionado.getCDepenId().getCDepenId();
        jefSeleccionado = tecSeleccionado.getCJefesdId().getCJefesdId();
    }
    
    public void asignarEdif() {
        ediSeleccionado = areaSeleccionada.getCEdifId().getCEdifId();
        depenSeleccionada = areaSeleccionada.getCDepenId().getCDepenId();
    }

    public void municipioSeleccion() {
        munic = getDaoMunic().getListM(depSeleccionado);
    }

    
    public void asignarDeptoMuni() {
        munSeleccionado = edifSeleccionado.getCMuniId().getCMuniId();
        depSeleccionado = edifSeleccionado.getCDeptoId().getCDeptoId();
        munic = getDaoMunic().getListM(depSeleccionado);
    }

    public void areaSeleccion() {
        areas = getDaoArea().getListM(ediSeleccionado);
    }

    public void asignarEdifArea() {
        ediSeleccionado = ubicSeleccionada.getCEdifId().getCEdifId();
        areSeleccionada = ubicSeleccionada.getCAreaId().getCAreaId();
        areas = getDaoArea().getListM(ediSeleccionado);
    }

    public void asignarNivelDep() {
        nivSeleccionado = respSeleccionado.getCNivelId().getCNivelId();
        depenSeleccionada = respSeleccionado.getCDepenId().getCDepenId();
        depenf = getDaoDepen().getListM(nivSeleccionado);
    }

    public void dependenciaSeleccion() {
        depenf = getDaoDepen().getListM(nivSeleccionado);
    }

        public void buscarCodN() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoNivel.getCNivelCodigo();
        resul = getDaoNivel().busCodN(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }

     public void buscarCodD() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevaDep.getCDepenCodigo();
        resul = getDaoDepen().busCodD(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }        
    
}
