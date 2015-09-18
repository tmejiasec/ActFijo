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
import dao.TAsigDetaFacadeLocal;
import dao.TAsigEncaFacadeLocal;
import dao.TBienesFacadeLocal;
import dao.TCorrOtrFacadeLocal;
import dao.TTiempoFacadeLocal;
import entidades.CDependencias;
import entidades.CResponsables;
import entidades.TAsigEnca;
import entidades.TCorrOtr;
import entidades.CJefesDep;
import entidades.CTecnicosAf;
import entidades.TAsigDeta;
import entidades.TBienes;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.naming.NamingException;
import util.FacesUtil;

/**
 *
 * @author Franklin
 */
@ManagedBean
@SessionScoped
public class AsignacionBienesBean implements Serializable {

    protected Integer tabIndex = 1;
    protected Boolean edit = false;

    //Asignacion Encabezado
    private List<TAsigEnca> encaAsig = new ArrayList<>();
    private TAsigEnca asignacion;
    private TAsigEnca nuevoEncaAsig = new TAsigEnca();
    private TAsigEnca encaAsigSeleccionado = new TAsigEnca();
    private TAsigEnca encaRel = new TAsigEnca();
    //Asignacion Detalle TAsigDeta
    private List<TAsigDeta> detaAsig = new ArrayList<>();
    private TAsigDeta detaAsignacion;
    private TAsigDeta nuevoDetaAsig = new TAsigDeta();
    private TAsigDeta detaAsigSeleccionado = new TAsigDeta();
    private List<TAsigDeta> detaSelectList = new ArrayList<>();
    private List<TAsigDeta> detaByEnca = new ArrayList<>();
    //De otras Tablas
    private List<TCorrOtr> correlativoAsig = new ArrayList<>();
    private List<CResponsables> reponAsig = new ArrayList<>();
    private List<CJefesDep> jefeAsig = new ArrayList<>();
    private List<CDependencias> depenAs = new ArrayList<>();
    private List<CTecnicosAf> tecAs = new ArrayList<>();
    private List<TBienes> bienes = new ArrayList<>();
    private TBienes[] selectBienes;
    private CResponsables responSel = new CResponsables();
    private CResponsables respTras = new CResponsables();
    private TBienes bienAsigN = new TBienes();
    private CJefesDep jefResp = new CJefesDep();
    //Fechas, Id_Fechas
    private Date fechaAs, FechaAsModif;
    private Date fechaAsCrea = new Date();
    private Integer fechAsId, fechaAsCreaId, FechaAsModifId;
    private Integer anio, nvoCorr, idFec, idFecha;
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    //Seleccionados
    private Integer responsableSeleccionado, jefSeleccionado, dependenciaSeleccionada,
            tecnocoSeleccionado, bienSeleccionado;
    private Integer responMod;
    private Integer  respon, idUs, depPer, jefPerId;
    private Integer m_id=0, idByEnca;
    private Integer dependenciaAsigna, personaAsigna, cargo, correlativoAg;
    private Boolean estado = false;
    private String nombreApellido, cod;
    //Session
    @ManagedProperty(value = "#{appSession}")
    private AppSession appSession;

    public AsignacionBienesBean() {
        encaAsig = getDaoEncaAs().getList();
        reponAsig = getDaoResp().getList();
        jefeAsig = getDaoJefes().getList();
        depenAs = getDaoDepen().getList();
        tecAs = getDaoTecnicos().getList();
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
    private TBienesFacadeLocal getDaoBien() {
        return (TBienesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TBienesFacade!dao.TBienesFacadeLocal");
    }

    private CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private TAsigEncaFacadeLocal getDaoEncaAs() {
        return (TAsigEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TAsigEncaFacade!dao.TAsigEncaFacadeLocal");
    }

    private TAsigDetaFacadeLocal getDaoDetaAs() {
        return (TAsigDetaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TAsigDetaFacade!dao.TAsigDetaFacadeLocal");
    }

    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CJefesDepFacadeLocal getDaoJefes() {
        return (CJefesDepFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CJefesDepFacade!dao.CJefesDepFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private TCorrOtrFacadeLocal getDaoCorrel() {
        return (TCorrOtrFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TCorrOtrFacade!dao.TCorrOtrFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private TTiempoFacadeLocal getDaoTiempo() {
        return (TTiempoFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TTiempoFacade!dao.TTiempoFacadeLocal");
    }

    private CTecnicosAfFacadeLocal getDaoTecnicos() {
        return (CTecnicosAfFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTecnicosAfFacade!dao.CTecnicosAfFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
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

    public List<TAsigEnca> getEncaAsig() {
        return encaAsig;
    }

    public void setEncaAsig(List<TAsigEnca> encaAsig) {
        this.encaAsig = encaAsig;
    }

    public TAsigEnca getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(TAsigEnca asignacion) {
        this.asignacion = asignacion;
    }

    public TAsigEnca getNuevoEncaAsig() {
        return nuevoEncaAsig;
    }

    public void setNuevoEncaAsig(TAsigEnca nuevoEncaAsig) {
        this.nuevoEncaAsig = nuevoEncaAsig;
    }

    public TAsigEnca getEncaAsigSeleccionado() {
        return encaAsigSeleccionado;
    }

    public void setEncaAsigSeleccionado(TAsigEnca encaAsigSeleccionado) {
        this.encaAsigSeleccionado = encaAsigSeleccionado;
    }

    public List<TAsigDeta> getDetaAsig() {
        return detaAsig;
    }

    public void setDetaAsig(List<TAsigDeta> detaAsig) {
        this.detaAsig = detaAsig;
    }

    public TAsigDeta getDetaAsignacion() {
        return detaAsignacion;
    }

    public void setDetaAsignacion(TAsigDeta detaAsignacion) {
        this.detaAsignacion = detaAsignacion;
    }

    public TAsigDeta getNuevoDetaAsig() {
        return nuevoDetaAsig;
    }

    public void setNuevoDetaAsig(TAsigDeta nuevoDetaAsig) {
        this.nuevoDetaAsig = nuevoDetaAsig;
    }

    public TAsigDeta getDetaAsigSeleccionado() {
        return detaAsigSeleccionado;
    }

    public void setDetaAsigSeleccionado(TAsigDeta detaAsigSeleccionado) {
        this.detaAsigSeleccionado = detaAsigSeleccionado;
    }

    public List<TCorrOtr> getCorrelativoAsig() {
        return correlativoAsig;
    }

    public void setCorrelativoAsig(List<TCorrOtr> correlativoAsig) {
        this.correlativoAsig = correlativoAsig;
    }

    public List<CResponsables> getReponAsig() {
        return reponAsig;
    }

    public void setReponAsig(List<CResponsables> reponAsig) {
        this.reponAsig = reponAsig;
    }

    public List<CJefesDep> getJefeAsig() {
        return jefeAsig;
    }

    public void setJefeAsig(List<CJefesDep> jefeAsig) {
        this.jefeAsig = jefeAsig;
    }

    public List<CDependencias> getDepenAs() {
        return depenAs;
    }

    public void setDepenAs(List<CDependencias> depenAs) {
        this.depenAs = depenAs;
    }

    public List<CTecnicosAf> getTecAs() {
        return tecAs;
    }

    public void setTecAs(List<CTecnicosAf> tecAs) {
        this.tecAs = tecAs;
    }

    public List<TBienes> getBienes() {
        return bienes;
    }

    public void setBienes(List<TBienes> bienes) {
        this.bienes = bienes;
    }

    public Integer getResponsableSeleccionado() {
        return responsableSeleccionado;
    }

    public void setResponsableSeleccionado(Integer responsableSeleccionado) {
        this.responsableSeleccionado = responsableSeleccionado;
    }

    public Integer getJefSeleccionado() {
        return jefSeleccionado;
    }

    public void setJefSeleccionado(Integer jefSeleccionado) {
        this.jefSeleccionado = jefSeleccionado;
    }

    public Integer getDependenciaSeleccionada() {
        return dependenciaSeleccionada;
    }

    public void setDependenciaSeleccionada(Integer dependenciaSeleccionada) {
        this.dependenciaSeleccionada = dependenciaSeleccionada;
    }

    public Integer getTecnocoSeleccionado() {
        return tecnocoSeleccionado;
    }

    public void setTecnocoSeleccionado(Integer tecnocoSeleccionado) {
        this.tecnocoSeleccionado = tecnocoSeleccionado;
    }

    public Integer getBienSeleccionado() {
        return bienSeleccionado;
    }

    public void setBienSeleccionado(Integer bienSeleccionado) {
        this.bienSeleccionado = bienSeleccionado;
    }

    public Integer getRespon() {
        return respon;
    }

    public void setRespon(Integer respon) {
        this.respon = respon;
    }

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    public Date getFechaAs() {
        return fechaAs;
    }

    public void setFechaAs(Date fechaAs) {
        this.fechaAs = fechaAs;
    }

    public Date getFechaAsCrea() {
        return fechaAsCrea;
    }

    public void setFechaAsCrea(Date fechaAsCrea) {
        this.fechaAsCrea = fechaAsCrea;
    }

    public Date getFechaAsModif() {
        return FechaAsModif;
    }

    public void setFechaAsModif(Date FechaAsModif) {
        this.FechaAsModif = FechaAsModif;
    }

    public Integer getFechAsId() {
        return fechAsId;
    }

    public void setFechAsId(Integer fechAsId) {
        this.fechAsId = fechAsId;
    }

    public Integer getFechaAsCreaId() {
        return fechaAsCreaId;
    }

    public void setFechaAsCreaId(Integer fechaAsCreaId) {
        this.fechaAsCreaId = fechaAsCreaId;
    }

    public Integer getFechaAsModifId() {
        return FechaAsModifId;
    }

    public void setFechaAsModifId(Integer FechaAsModifId) {
        this.FechaAsModifId = FechaAsModifId;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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

    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public Integer getIdFec() {
        return idFec;
    }

    public void setIdFec(Integer idFec) {
        this.idFec = idFec;
    }

    public Integer getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Integer idFecha) {
        this.idFecha = idFecha;
    }

    public SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(SimpleDateFormat formatoHora) {
        this.formatoHora = formatoHora;
    }

    public Integer getDependenciaAsigna() {
        return dependenciaAsigna;
    }

    public void setDependenciaAsigna(Integer dependenciaAsigna) {
        this.dependenciaAsigna = dependenciaAsigna;
    }

    public Integer getPersonaAsigna() {
        return personaAsigna;
    }

    public void setPersonaAsigna(Integer personaAsigna) {
        this.personaAsigna = personaAsigna;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public Integer getCorrelativoAg() {
        return correlativoAg;
    }

    public void setCorrelativoAg(Integer correlativoAg) {
        this.correlativoAg = correlativoAg;
    }

    public TBienes[] getSelectBienes() {
        return selectBienes;
    }

    public void setSelectBienes(TBienes[] selectBienes) {
        this.selectBienes = selectBienes;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Integer getDepPer() {
        return depPer;
    }

    public void setDepPer(Integer depPer) {
        this.depPer = depPer;
    }

    public CResponsables getResponSel() {
        return responSel;
    }

    public void setResponSel(CResponsables responSel) {
        this.responSel = responSel;
    }

    public CJefesDep getJefResp() {
        return jefResp;
    }

    public void setJefResp(CJefesDep jefResp) {
        this.jefResp = jefResp;
    }

    public Integer getJefPerId() {
        return jefPerId;
    }

    public void setJefPerId(Integer jefPerId) {
        this.jefPerId = jefPerId;
    }

    public CResponsables getRespTras() {
        return respTras;
    }

    public void setRespTras(CResponsables respTras) {
        this.respTras = respTras;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public TBienes getBienAsigN() {
        return bienAsigN;
    }

    public void setBienAsigN(TBienes bienAsigN) {
        this.bienAsigN = bienAsigN;
    }

    public TAsigEnca getEncaRel() {
        return encaRel;
    }

    public void setEncaRel(TAsigEnca encaRel) {
        this.encaRel = encaRel;
    }

    public List<TAsigDeta> getDetaSelectList() {
        return detaSelectList;
    }

    public void setDetaSelectList(TAsigDeta detaSelectList) {
        this.detaSelectList = (List<TAsigDeta>) detaSelectList;
    }

    public List<TAsigDeta> getDetaByEnca() {
        return detaByEnca;
    }

    public void setDetaByEnca(List<TAsigDeta> detaByEnca) {
        this.detaByEnca = detaByEnca;
    }

    public Integer getIdByEnca() {
        return idByEnca;
    }

    public void setIdByEnca(Integer idByEnca) {
        this.idByEnca = idByEnca;
    }

    public Integer getResponMod() {
        return responMod;
    }

    public void setResponMod(Integer responMod) {
        this.responMod = responMod;
    }
        
    //Para traer nombre completo del responsable    
    public String traerNombres() {
        
        nombreApellido = getDaoResp().getResp(responsableSeleccionado).getCRespNom1() + " " + getDaoResp().getResp(responsableSeleccionado).getCRespNom2() + " " + getDaoResp().getResp(responsableSeleccionado).getCRespApe1() + " " + getDaoResp().getResp(responsableSeleccionado).getCRespApe2() + " ";
        return nombreApellido;
    
    }

    //Buscar correlativo
    public void buscarCorr() throws NamingException {
        Integer resul;
        Integer annio;
        annio = nuevoEncaAsig.getTAsigeAnio();
        resul = getDaoCorrel().getTOtrocCorrel(1, annio).getTOtrocCorrel();
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede encontrar correlativo"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
            estado = true;
        }
        nuevoEncaAsig.setTAsigeCorr(resul);
        Integer correltas = nuevoEncaAsig.getTAsigeCorr();
        System.out.println("Correlativo traido " + correltas);
    }

    //Guardar Encabezado de asignacion 
    public String guardarEncaAsignacion() throws NamingException, ParseException {
        
        //Seteando fechas
        fechaAs = nuevoEncaAsig.getTAsigeFecha();
        FechaAsModif = nuevoEncaAsig.getTAsigeFechm();
        if (fechaAs == null) {
        } else {
            fechAsId = getDaoTiempo().getFecha(fechaAs).getTTmId();
//            nuevoEncaAsig.setTAsigeFechaId(fechAsId);
        }
        if (FechaAsModif == null) {
        } else {
            FechaAsModifId = getDaoTiempo().getFecha(FechaAsModif).getTTmId();
            nuevoEncaAsig.setTAsigeFechcId(FechaAsModifId);
        }
        nuevoEncaAsig.setTAsigeFechc(fechaAsCrea);
        idFec = getDaoTiempo().getFecha(fechaAsCrea).getTTmId();
        nuevoEncaAsig.setTTmId(getDaoTiempo().getTm(idFec));
        nuevoEncaAsig.setTAsigeFechcId(idFec);
        nuevoEncaAsig.setTAsigeHorac(formatoHora.parse(formatoHora.format(fechaAsCrea)));

        //Seteando datos de otras tablas
        System.out.println("Datos traidos");
        System.out.println(respTras.getCRespApe1());
        System.out.println("Asignar a "+traerNombres());
        System.out.println(depPer);
        System.out.println(jefPerId);
        nuevoEncaAsig.setCRespId(respTras);
        nuevoEncaAsig.setTAsigeCargo(respTras.getCRespCargo());
        nuevoEncaAsig.setTAsigePers(traerNombres());
        nuevoEncaAsig.setCJefesdId(getDaoJefes().getJefeDep(jefPerId));
        nuevoEncaAsig.setCDepenId(getDaoDepen().getDepend(depPer));
        nuevoEncaAsig.setTAsigeTec(tecnocoSeleccionado);
        nuevoEncaAsig.setTAsigeDep(nuevoEncaAsig.getCDepenId().getCDepenId());
        idUs = appSession.getUsuario().getCUserId();
        nuevoEncaAsig.setTAsigeUsec(idUs);
        

        //Actualizando correlativo
        anio = nuevoEncaAsig.getTAsigeAnio();
        System.out.println(anio);
        nvoCorr = nuevoEncaAsig.getTAsigeCorr();
        nvoCorr = nvoCorr + 1;
        getDaoCorrel().updateC(anio, nvoCorr, 1);
        getDaoEncaAs().create(nuevoEncaAsig);
        m_id = nuevoEncaAsig.getTAsigeId();
        Integer resss = getDaoCorrel().getTOtrocCorrel(1, anio).getTOtrocCorrel();
        System.out.println("El correlativo traido despues de actualizar es "+ resss);
        System.out.println("m_id "+ m_id);
        encaAsig = getDaoEncaAs().getList();
        estado = true;
        System.out.println("Tecnico seleccionado " + "Nº" + tecnocoSeleccionado);
        System.out.println("Se guardo");
        detaAsig = getDaoDetaAs().getListDet(m_id);        
        return null;
    }

    public String actualizarEncaAsig() throws NamingException, ParseException {
        fechaAs = encaAsigSeleccionado.getTAsigeFecha();
        if (fechaAs == null) {
        } else {
            idFecha = getDaoTiempo().getFecha(fechaAs).getTTmId();
            encaAsigSeleccionado.setTAsigeFecha(fechaAs);
        }
        idUs = appSession.getUsuario().getCUserId();
        FechaAsModifId = getDaoTiempo().getFecha(new Date()).getTTmId();
        encaAsigSeleccionado.setTTmId(getDaoTiempo().getTm(idFecha));
        encaAsigSeleccionado.setTAsigeFechmId(FechaAsModifId);
        encaAsigSeleccionado.setTAsigeFechm(new Date());
        try {
            encaAsigSeleccionado.setTAsigeHoram(formatoHora.parse(formatoHora.format(new Date())));
        } catch (ParseException ex) {
            Logger.getLogger(RoboHurtoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        idUs = appSession.getUsuario().getCUserId();
        encaAsigSeleccionado.setTAsigeUsem(idUs);
        getDaoEncaAs().edit(encaAsigSeleccionado);
        System.out.println("Se actualizo");
        return null;
    }

    public void generarTablaDetalle() throws NamingException {
        //Trayendo datos de responsable para mostrar
        responSel = getDaoResp().getResp(responsableSeleccionado);
        System.out.println("responsable "+responsableSeleccionado);
        depPer = responSel.getCDepenId().getCDepenId();
        System.out.println("Departamento "+depPer);
        jefResp = getDaoJefes().getDep(depPer);
        jefPerId = jefResp.getCJefesdId();
        System.out.println("jefe "+ jefPerId);
        //Generando tabla
        //bienes = getDaoBien().getListM(personaAsigna);
       // return bienes;
    }

    public List generarDetaAsig() throws NamingException {
        this.encaAsigSeleccionado = getEncaAsigSeleccionado();
        m_id = encaAsigSeleccionado.getTAsigeId();
        detaAsig = getDaoDetaAs().getListDet(m_id);

        return null;
    }

    public void limpiarAsigEnca() {
        responSel = new CResponsables();
        respTras = new CResponsables();
        nuevoEncaAsig = new TAsigEnca();
        jefResp = new CJefesDep ();
        depPer = 0;
        jefPerId = 0;
        tecnocoSeleccionado = 0;
        responsableSeleccionado = 0;
        personaAsigna = 0;
        m_id=0;
        detaAsig = getDaoDetaAs().getListDet(m_id);
    }
    
    public List traerDatosModal() throws NamingException {
        respTras = getDaoResp().getResp(personaAsigna);
        System.out.println("Personaa "+personaAsigna);
        System.out.println("Cargo: "+respTras.getCRespCargo());
        dependenciaAsigna = respTras.getCDepenId().getCDepenId();
        bienes = getDaoBien().getListM(personaAsigna);
        respTras.getCDepenId().getCDepenDesc();
        return bienes;
    }
    
    public TAsigDeta crearListaBienes(){
        System.out.println("id del encabezado "+m_id);
        encaRel = getDaoEncaAs().getEnca(m_id);
        nuevoDetaAsig.setTAsigeId(encaRel);
        nuevoDetaAsig.setTBienId(bienAsigN);
        nuevoDetaAsig.setTAsigdCodigo(bienAsigN.getTBienCodigo());
        getDaoDetaAs().create(nuevoDetaAsig);
        detaAsig = getDaoDetaAs().getList();
        detaAsig = getDaoDetaAs().getListDet(m_id);
        cod=" ";
        bienAsigN = new TBienes();
        estado = true;
        System.out.println("Se guardo el detalle");
        return null;
    }
    
    public TBienes datosCodigo() throws NamingException {
        bienAsigN = getDaoBien().getCodBien(cod);
        String desc = bienAsigN.getTBienDesc();
        System.out.println("cod " + desc);
        return bienAsigN;
    }
    
    public List detaFiltro ()throws NamingException {   
        encaAsigSeleccionado=this.encaAsigSeleccionado;
        idByEnca = encaAsigSeleccionado.getTAsigeId();
        System.out.println("id encabezado Seleccionado "+idByEnca);
        detaByEnca = getDaoDetaAs().getListDet(idByEnca);
        System.out.println("Correlativo del encabezado "+encaAsigSeleccionado.getTAsigeCorr());
        return null;
    }
    public void updateDeta() {
    }
    
    public void cambiodeHoraInicio(ValueChangeEvent e) {
    }

    public void cambiodeHorafin(ValueChangeEvent e) {
    }

}
