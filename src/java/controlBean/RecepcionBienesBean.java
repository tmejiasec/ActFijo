/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import dao.CDependenciasFacadeLocal;
import dao.CJefesDepFacadeLocal;
import dao.CResponsablesFacadeLocal;
import dao.CTecnicosAfFacadeLocal;
import dao.TBienesFacadeLocal;
import dao.TCorrOtrFacadeLocal;
import dao.TRecepEncaFacadeLocal;
import dao.TRecepDetaFacadeLocal;
import dao.TTiempoFacadeLocal;
import entidades.CDependencias;
import entidades.CResponsables;
import entidades.TCorrOtr;
import entidades.CJefesDep;
import entidades.CTecnicosAf;
import entidades.TBienes;
import entidades.TRecepDeta;
import entidades.TRecepEnca;
import java.io.Serializable;
import java.text.ParseException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import util.FacesUtil;

/**
 *
 * @author Franklin
 */
@ManagedBean
@SessionScoped
public class RecepcionBienesBean implements Serializable {

    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    //Encabezado de recepcion
    private List<TRecepEnca> encaRecep = new ArrayList<>();
    private TRecepEnca recepcion;
    private TRecepEnca nuevoEncaResep = new TRecepEnca();
    private TRecepEnca encaResepSeleccionado = new TRecepEnca();
    private TRecepEnca encaRela = new TRecepEnca();
    //Detalle de recepcion
    private TRecepDeta detallerecep;
    private List<TRecepDeta> detaList = new ArrayList<>();
    private List<TRecepDeta> listaCompleta = new ArrayList<>();
    private TRecepDeta recepDetaNew = new TRecepDeta();
    private TRecepDeta recepDetaSel = new TRecepDeta(); 
    private List<TRecepDeta> detaByEnca = new ArrayList<>();
    
    //De otras tablas
    private List<TCorrOtr> correlativoRecep = new ArrayList<>();
    private List<CResponsables> reponRecep = new ArrayList<>();
    private List<CJefesDep> jefeRecep = new ArrayList<>();
    private List<CDependencias> depenRecep = new ArrayList<>();
    private List<CTecnicosAf> tecRecep = new ArrayList<>();
    private List<TBienes> bienes = new ArrayList<>();
    private TBienes[] selectBienes;
    private TBienes bienRecep = new TBienes();
    private CResponsables responRes = new CResponsables();
    private CJefesDep jefeDpendencia = new CJefesDep();
    //Para Modificar
    private CResponsables responToMod = new CResponsables();
    private CJefesDep jefeToMod = new CJefesDep();
    
    //Fechas, Id_Fechas
    private Date fechaRe, fechaReModif;
    private Date fechaReCrea = new Date();
    private Integer idFecha, fechaReCreaId, fechaReModifId;
    private Integer anio, nvoCorr, idFec;
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    //Selccionados
    private Integer depenSeleccionada, tecnicoSeleccionado, jefeSeleccionado,responAsidId , idUs,responSeleccionado;
    private Integer depPer, jefDep; 
    private Integer m_id, idByEnca;
    private String nombreApellido, miNombre, cod;
    private Integer responMod, depenMod, tecMod, jefeMod;
    private Boolean estado = false;
    //Secion
    @ManagedProperty(value = "#{appSession}")
    private AppSession appSession;

    public RecepcionBienesBean() {
        encaRecep = getDaoEncaResep().getList();
        reponRecep = getDaoResp().getList();
        jefeRecep = getDaoJefes().getList();
        depenRecep = getDaoDepen().getList();
        tecRecep = getDaoTecnicos().getList();
        bienes = getDaoBien().getList();
    }

    public String borrarB() throws NamingException {
        return null;
    }

    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    //Daos
    private TRecepEncaFacadeLocal getDaoEncaResep() {
        return (TRecepEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TRecepEncaFacade!dao.TRecepEncaFacadeLocal");
    }
    
    private TRecepDetaFacadeLocal getDaoDetaRecep(){
        return (TRecepDetaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TRecepDetaFacade!dao.TRecepDetaFacadeLocal");
    }
    
    private TBienesFacadeLocal getDaoBien() {
        return (TBienesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TBienesFacade!dao.TBienesFacadeLocal");
    }

    private CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CJefesDepFacadeLocal getDaoJefes() {
        return (CJefesDepFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CJefesDepFacade!dao.CJefesDepFacadeLocal");
    }

    private TTiempoFacadeLocal getDaoTiempo() {
        return (TTiempoFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TTiempoFacade!dao.TTiempoFacadeLocal");
    }

    private CTecnicosAfFacadeLocal getDaoTecnicos() {
        return (CTecnicosAfFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTecnicosAfFacade!dao.CTecnicosAfFacadeLocal");
    }

    private TCorrOtrFacadeLocal getDaoCorrel() {
        return (TCorrOtrFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TCorrOtrFacade!dao.TCorrOtrFacadeLocal");
    }

    //Getters y Setters
    public Integer getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public List<TRecepEnca> getEncaRecep() {
        return encaRecep;
    }

    public void setEncaRecep(List<TRecepEnca> encaRecep) {
        this.encaRecep = encaRecep;
    }

    public TRecepEnca getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(TRecepEnca recepcion) {
        this.recepcion = recepcion;
    }

    public TRecepEnca getNuevoEncaResep() {
        return nuevoEncaResep;
    }

    public void setNuevoEncaResep(TRecepEnca nuevoEncaResep) {
        this.nuevoEncaResep = nuevoEncaResep;
    }

    public TRecepEnca getEncaResepSeleccionado() {
        return encaResepSeleccionado;
    }

    public void setEncaResepSeleccionado(TRecepEnca encaResepSeleccionado) {
        this.encaResepSeleccionado = encaResepSeleccionado;
    }

    public List<TCorrOtr> getCorrelativoRecep() {
        return correlativoRecep;
    }

    public void setCorrelativoRecep(List<TCorrOtr> correlativoRecep) {
        this.correlativoRecep = correlativoRecep;
    }

    public List<CResponsables> getReponRecep() {
        return reponRecep;
    }

    public void setReponRecep(List<CResponsables> reponRecep) {
        this.reponRecep = reponRecep;
    }

    public List<CJefesDep> getJefeRecep() {
        return jefeRecep;
    }

    public void setJefeRecep(List<CJefesDep> jefeRecep) {
        this.jefeRecep = jefeRecep;
    }

    public List<CDependencias> getDepenRecep() {
        return depenRecep;
    }

    public void setDepenRecep(List<CDependencias> depenRecep) {
        this.depenRecep = depenRecep;
    }

    public List<CTecnicosAf> getTecRecep() {
        return tecRecep;
    }

    public void setTecRecep(List<CTecnicosAf> tecRecep) {
        this.tecRecep = tecRecep;
    }

    public List<TBienes> getBienes() {
        return bienes;
    }

    public void setBienes(List<TBienes> bienes) {
        this.bienes = bienes;
    }

    public TBienes[] getSelectBienes() {
        return selectBienes;
    }

    public void setSelectBienes(TBienes[] selectBienes) {
        this.selectBienes = selectBienes;
    }

    public Date getFechaRe() {
        return fechaRe;
    }

    public void setFechaRe(Date fechaRe) {
        this.fechaRe = fechaRe;
    }

    public Date getfechaReModif() {
        return fechaReModif;
    }

    public void setfechaReModif(Date fechaReModif) {
        this.fechaReModif = fechaReModif;
    }

    public Date getFechaReCrea() {
        return fechaReCrea;
    }

    public void setFechaReCrea(Date fechaReCrea) {
        this.fechaReCrea = fechaReCrea;
    }

    public Integer getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public Integer getFechaReCreaId() {
        return fechaReCreaId;
    }

    public void setFechaReCreaId(Integer fechaReCreaId) {
        this.fechaReCreaId = fechaReCreaId;
    }

    public Integer getfechaReModifId() {
        return fechaReModifId;
    }

    public void setfechaReModifId(Integer fechaReModifId) {
        this.fechaReModifId = fechaReModifId;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNvoCorr() {
        return nvoCorr;
    }

    public void setNvoCorr(Integer nvoCorr) {
        this.nvoCorr = nvoCorr;
    }

    public Integer getIdFec() {
        return idFec;
    }

    public void setIdFec(Integer idFec) {
        this.idFec = idFec;
    }

    public SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(SimpleDateFormat formatoHora) {
        this.formatoHora = formatoHora;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getResponSeleccionado() {
        return responSeleccionado;
    }

    public void setResponSeleccionado(Integer responSeleccionado) {
        this.responSeleccionado = responSeleccionado;
    }

    public Integer getDepenSeleccionada() {
        return depenSeleccionada;
    }

    public void setDepenSeleccionada(Integer depenSeleccionada) {
        this.depenSeleccionada = depenSeleccionada;
    }

    public Integer getTecnicoSeleccionado() {
        return tecnicoSeleccionado;
    }

    public void setTecnicoSeleccionado(Integer tecnicoSeleccionado) {
        this.tecnicoSeleccionado = tecnicoSeleccionado;
    }

    public Integer getJefeSeleccionado() {
        return jefeSeleccionado;
    }

    public void setJefeSeleccionado(Integer jefeSeleccionado) {
        this.jefeSeleccionado = jefeSeleccionado;
    }

    public Date getFechaReModif() {
        return fechaReModif;
    }

    public void setFechaReModif(Date fechaReModif) {
        this.fechaReModif = fechaReModif;
    }

    public Integer getFechaReModifId() {
        return fechaReModifId;
    }

    public void setFechaReModifId(Integer fechaReModifId) {
        this.fechaReModifId = fechaReModifId;
    }

    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getMiNombre() {
        return miNombre;
    }

    public void setMiNombre(String miNombre) {
        this.miNombre = miNombre;
    }

    public Integer getResponAsidId() {
        return responAsidId;
    }

    public void setResponAsidId(Integer responAsidId) {
        this.responAsidId = responAsidId;
    }   

    public CResponsables getResponRes() {
        return responRes;
    }

    public void setResponRes(CResponsables responRes) {
        this.responRes = responRes;
    }

    public CJefesDep getJefeDpendencia() {
        return jefeDpendencia;
    }

    public void setJefeDpendencia(CJefesDep jefeDpendencia) {
        this.jefeDpendencia = jefeDpendencia;
    }

    public Integer getDepPer() {
        return depPer;
    }

    public void setDepPer(Integer depPer) {
        this.depPer = depPer;
    }

    public Integer getJefDep() {
        return jefDep;
    }

    public void setJefDep(Integer jefDep) {
        this.jefDep = jefDep;
    }

    public TRecepDeta getDetallerecep() {
        return detallerecep;
    }

    public void setDetallerecep(TRecepDeta detallerecep) {
        this.detallerecep = detallerecep;
    }

    public List<TRecepDeta> getDetaList() {
        return detaList;
    }

    public void setDetaList(List<TRecepDeta> detaList) {
        this.detaList = detaList;
    }

    public TRecepDeta getRecepDetaNew() {
        return recepDetaNew;
    }

    public void setRecepDetaNew(TRecepDeta recepDetaNew) {
        this.recepDetaNew = recepDetaNew;
    }

    public TRecepDeta getRecepDetaSel() {
        return recepDetaSel;
    }

    public void setRecepDetaSel(TRecepDeta recepDetaSel) {
        this.recepDetaSel = recepDetaSel;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public TBienes getBienRecep() {
        return bienRecep;
    }

    public void setBienRecep(TBienes bienRecep) {
        this.bienRecep = bienRecep;
    }

    public TRecepEnca getEncaRela() {
        return encaRela;
    }

    public void setEncaRela(TRecepEnca encaRela) {
        this.encaRela = encaRela;
    }

    public List<TRecepDeta> getListaCompleta() {
        return listaCompleta;
    }

    public void setListaCompleta(List<TRecepDeta> listaCompleta) {
        this.listaCompleta = listaCompleta;
    }

    public List<TRecepDeta> getDetaByEnca() {
        return detaByEnca;
    }

    public void setDetaByEnca(List<TRecepDeta> detaByEnca) {
        this.detaByEnca = detaByEnca;
    }

    public Integer getIdByEnca() {
        return idByEnca;
    }

    public void setIdByEnca(Integer idByEnca) {
        this.idByEnca = idByEnca;
    }

    public CResponsables getResponToMod() {
        return responToMod;
    }

    public void setResponToMod(CResponsables responToMod) {
        this.responToMod = responToMod;
    }

    public CJefesDep getJefeToMod() {
        return jefeToMod;
    }

    public void setJefeToMod(CJefesDep jefeToMod) {
        this.jefeToMod = jefeToMod;
    }
    
    public Integer getResponMod() {
        return responMod;
    }

    public void setResponMod(Integer responMod) {
        this.responMod = responMod;
    }

    public Integer getDepenMod() {
        return depenMod;
    }

    public void setDepenMod(Integer depenMod) {
        this.depenMod = depenMod;
    }

    public Integer getTecMod() {
        return tecMod;
    }

    public void setTecMod(Integer tecMod) {
        this.tecMod = tecMod;
    }

    public Integer getJefeMod() {
        return jefeMod;
    }

    public void setJefeMod(Integer jefeMod) {
        this.jefeMod = jefeMod;
    }
              
    public void buscarCorr() throws NamingException {
        Integer resul;
        Integer annio;
        annio = nuevoEncaResep.getTReceAnio();
        resul = getDaoCorrel().getTOtrocCorrel(2, annio).getTOtrocCorrel();
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede encontrar correlativo"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
            estado = true;
        }
        nuevoEncaResep.setTReceCorr(resul);
    }

    //Guardar Encabezado de asignacion 
    public String guardarRecepEnca() throws NamingException, ParseException {
        //Fechas y hora
        fechaRe = nuevoEncaResep.getTReceFecha();
        
        if (fechaRe == null) {
        } else {
            idFecha = getDaoTiempo().getFecha(fechaRe).getTTmId();
            nuevoEncaResep.setTReceFecha(fechaRe);
        }
        nuevoEncaResep.setTReceFechc(fechaReCrea);
        idFec = getDaoTiempo().getFecha(fechaReCrea).getTTmId();
        nuevoEncaResep.setTTmId(getDaoTiempo().getTm(idFec));
        nuevoEncaResep.setTReceFechcId(idFec);
        nuevoEncaResep.setTReceHorac(formatoHora.parse(formatoHora.format(fechaReCrea)));
        
        //De otras tablas
        System.out.println("Datos traidos");
        System.out.println("Respon "+responSeleccionado);
        System.out.println("Depen "+depPer);
        System.out.println("Jef "+jefDep);
        System.out.println("Tec "+tecnicoSeleccionado);
        
        
        nuevoEncaResep.setCRespId(getDaoResp().getResp(responSeleccionado));
        nuevoEncaResep.setCDepenId(getDaoDepen().getDepend(depPer));
        nuevoEncaResep.setCJefesdId(getDaoJefes().getJefeDep(jefDep));
        nuevoEncaResep.setTReceTec(tecnicoSeleccionado);
        idUs = appSession.getUsuario().getCUserId();
        nuevoEncaResep.setTReceUsec(idUs);
        anio = nuevoEncaResep.getTReceAnio();
        nvoCorr = nuevoEncaResep.getTReceCorr();
        nvoCorr = nvoCorr + 1;
        getDaoCorrel().updateC(anio, nvoCorr, 2);
        getDaoEncaResep().create(nuevoEncaResep);
        m_id = nuevoEncaResep.getTReceId();
        System.out.println("Id del encabezado "+m_id);
        encaRecep = getDaoEncaResep().getList();
        estado = true;
        System.out.println("Se guardo" + " " + nvoCorr);
        return null;
    }
        
    //Actualizacion de la tabla de Encabezado de Recepcion
    public List respToMod() throws NamingException{
        responToMod = getDaoResp().getResp(responMod);
        depenMod = responToMod.getCDepenId().getCDepenId();
        jefeToMod = getDaoJefes().getDep(depenMod);
        jefeMod = jefeDpendencia.getCJefesdId();
        System.out.println(responMod);
        return null;
    } 
    
    public String actualizarEncaRecep() throws NamingException, ParseException {
        //Actualizando Fechas y Horas
        fechaRe = encaResepSeleccionado.getTReceFecha();
        if (fechaRe == null) {
        } else {
            idFecha = getDaoTiempo().getFecha(fechaRe).getTTmId();
            encaResepSeleccionado.setTReceFecha(fechaRe);
        }
        encaResepSeleccionado.setTReceFechm(new Date());
        idFec = getDaoTiempo().getFecha(new Date()).getTTmId();
        encaResepSeleccionado.setTTmId(getDaoTiempo().getTm(idFec));
        encaResepSeleccionado.setTReceFechmId(idFec);
        try {
            encaResepSeleccionado.setTReceHoram(formatoHora.parse(formatoHora.format(new Date())));
        } catch (ParseException ex) {
            Logger.getLogger(RoboHurtoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
//        /************Actualizando de otras Tablas*****************************/
//        encaResepSeleccionado.setCRespId(getDaoResp().getResp(responMod));
//        encaResepSeleccionado.setCDepenId(getDaoDepen().getDepend(depenMod));
//        encaResepSeleccionado.setCJefesdId(getDaoJefes().getJefeDep(jefeMod));
//        encaResepSeleccionado.setTReceTec(tecMod);
//        /*********************************************************************/
        
        idUs = appSession.getUsuario().getCUserId();
        encaResepSeleccionado.setTReceUsem(idUs);
        getDaoEncaResep().edit(encaResepSeleccionado);
        System.out.println("Se actualizo");
        return null;
    }

    public String traerNombres() {
        nombreApellido = getDaoResp().getResp(responSeleccionado).getCRespNom1() + " " + getDaoResp().getResp(responSeleccionado).getCRespNom2() + " " + getDaoResp().getResp(responSeleccionado).getCRespApe1() + " " + getDaoResp().getResp(responSeleccionado).getCRespApe2() + " ";
        return nombreApellido;
    }
    
    public List generarDetaRecep() throws NamingException {
        this.encaResepSeleccionado = getEncaResepSeleccionado();
        idByEnca = encaResepSeleccionado.getTReceId();
        System.out.println("id encabezado Seleccionado " + idByEnca);
        detaByEnca = getDaoDetaRecep().getListDet(idByEnca);
        System.out.println("Correlativo del encabezado " + encaResepSeleccionado.getTReceCorr());
        return null;
    }
    
    public List generarTablaDetalle() throws NamingException{
        responRes = getDaoResp().getResp(responSeleccionado);
        depPer = responRes.getCDepenId().getCDepenId();
        jefeDpendencia = getDaoJefes().getDep(depPer);
        jefDep = jefeDpendencia.getCJefesdId();
        System.out.println(responSeleccionado);
        bienes = getDaoBien().getListM(responSeleccionado);
        return bienes;
    }
    
    public void limpiarRecEnca() {
        nuevoEncaResep = new TRecepEnca();
        responRes = new CResponsables();
        jefeDpendencia = new CJefesDep();
        detaList = getDaoDetaRecep().getListDet(m_id);
        responSeleccionado = 0;
        depenSeleccionada = 0;
        jefeSeleccionado = 0;
        tecnicoSeleccionado = 0;
        bienRecep = new TBienes();
    }
    
     public TBienes datosCodigo() throws NamingException {
        bienRecep = getDaoBien().getCodBien(cod);
        String desc = bienRecep.getTBienDesc();
        System.out.println("cod " + desc);
        return bienRecep;
    }
    
    public TRecepDeta generarDetalle(){
        System.out.println("id del encabezado "+m_id);
        encaRela = getDaoEncaResep().getEnca(m_id);
        recepDetaNew.setTReceId(encaRela);
        recepDetaNew.setTRecdCodigo(cod);
        recepDetaNew.setTBienId(bienRecep);
        getDaoDetaRecep().create(recepDetaNew);
        detaList = getDaoDetaRecep().getListDet(m_id);
        cod=" ";
        estado = true;
        System.out.println("Se guardo el detalle");
        return null;
    }

}
