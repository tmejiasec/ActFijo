/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;


import dao.CResponsablesFacadeLocal;
import dao.CDependenciasFacadeLocal;
import dao.CEstadoMovFacadeLocal;
import dao.CNivelesFacadeLocal;
import dao.CTiposMovFacadeLocal;
import entidades.CDependencias;
import dao.TArchivosFacadeLocal;
import dao.TBienesFacadeLocal;
import dao.TMovimDetaFacadeLocal;
import dao.TMovimEncaFacadeLocal;
import dao.TTiempoFacadeLocal;
import dao.TCorrMovFacadeLocal;
import dao.TPrestFacadeLocal;
import dao.TReparFacadeLocal;
import entidades.CEstadoMov;
import entidades.CNiveles;
import entidades.CResponsables;
import entidades.CTiposMov;
import entidades.TArchivos;
import entidades.TBienes;
import entidades.TMovimEnca;
import entidades.TMovimDeta;
import entidades.TCorrMov;
import entidades.TPrest;
import entidades.TRepar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import util.FacesUtil;

/**
 *
 * @author Teo de Renderos
 */
@ManagedBean
@SessionScoped
public class MovBienesBean implements Serializable {

    protected Integer tabIndex = 1;
    private List<CResponsables> respons = new ArrayList<>();
    private List<CDependencias> depens = new ArrayList<>();
    private List<CDependencias> depense = new ArrayList<>();
    private CDependencias depeSeleccionada = new CDependencias();
    private List<CNiveles> niveles = new ArrayList<>();
    private CNiveles nivelSeleccionado = new CNiveles();
    private List<CEstadoMov> estmovs = new ArrayList<>();

    List<TArchivos> docums = new ArrayList<>();
    private TArchivos archSeleccionado = new TArchivos();
    private TArchivos nuevoArch = new TArchivos();

    private Integer respSeleccionado, depSeleccionada, nivSeleccionado,nivSeleccionadoE,estmoSeleccionado,estmo,tipmSeleccionado;
    private Integer tiempoSeleccionado, idFecs, idFecr, idFeci, idFeca, idFecc, idFecaf, idUs;

    private CResponsablesFacadeLocal respFacade;
    private CDependenciasFacadeLocal depeFacade;
    private Date fech = new Date();
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    private Boolean estado = false;
    private Boolean estadoI = false;
    private Boolean estadoC = true;
    private Boolean estadoR = true;
    
    Date fecs, fecr, feci, feca;
    private Integer iniCorr=0;
    private Integer espec,m_id=0;
    private String tipref = "MOV";
    private String tipo = "D";
    private String tipom = "I";

    
    private List<TBienes> bienes = new ArrayList<>();
    private List<TBienes> lotes = new ArrayList<>();
    private TBienes[] selectedBienes;
    private List<TCorrMov> correls = new ArrayList<>();
    private int tipmo;
//    private CTiposMov tipmSeleccionado = new CTiposMov();
    private TMovimEnca enca;
    private TMovimEnca nuevoEnca = new TMovimEnca();
    private TMovimEnca encaSeleccionado = new TMovimEnca();
    private Integer encSeleccionado;
    private List<TMovimEnca> movenca;
    private TMovimDeta deta;
    private TMovimDeta nuevoDeta = new TMovimDeta();
    private TMovimDeta detaSeleccionado = new TMovimDeta();
    private Integer detSeleccionado;
    private List<TMovimDeta> movdeta;
    private TPrest nuevoPrest = new TPrest();
    private TPrest prestSeleccionado = new TPrest();
    private Integer prestSelec;
    private List<TPrest> prestamos;
    private TRepar nuevaRepar = new TRepar();
    private TRepar reparSeleccionada = new TRepar();
    private Integer reparSelec, codSelec, marca;
    private List<TRepar> repars;
    
    private List<CTiposMov> tiposm;    
                                                                                                          
    private List datosIn;
    private List bienesIn = new ArrayList<>();
    private TBienes codSeleccionado = new TBienes();
    //   private List bienesIn;
    private Object[] ingre;

    protected Boolean edit = false;
    private String desc, cod, modelo, serie;
    private UploadedFile picture;
    private static final int BUFFER_SIZE = 1000000;
    private DefaultStreamedContent download;
    private Integer respo;
    @ManagedProperty(value = "#{appSession}")
    private AppSession appSession;
    /**
     * Creates a new instance
     */
    public MovBienesBean() {
        depens = getDaoDepen().getList();
        depense = getDaoDepen().getList();
        respons = getDaoResp().getList();
        docums = getDaoArchiv().getListT(tipref);
        movenca = getDaoEnca().getList(); 
        movdeta = getDaoDeta().getListM(m_id);       
        tiposm = getDaoTipMov().getList();
        correls = getDaoCorrel().getList();
        niveles = getDaoNivel().getList();
        estmovs = getDaoEstmo().getList();
    }

    public String guardarE() throws NamingException, ParseException {
        Date fecha = new Date();
        // buscando id de fechas
        System.out.println("entrando a guardar datos");
        fecs = nuevoEnca.getTMoveFecsal();
        fecr = nuevoEnca.getTMoveFecret();
        feci = nuevoEnca.getTMoveFecretr();
        feca = nuevoEnca.getTMoveFechaut();
        if (fecs == null) {
        } else {
            idFecs = getDaoTiempo().getFecha(fecs).getTTmId();
            nuevoEnca.setTMoveFecsId(idFecs);
        }
        if (fecr == null) {
        } else {
            idFecr = getDaoTiempo().getFecha(fecr).getTTmId();
            nuevoEnca.setTMoveFecrId(idFecr);
        }
        if (feci == null) {
        } else {
            idFeci = getDaoTiempo().getFecha(feci).getTTmId();
            nuevoEnca.setTMoveFeciId(idFeci);
        }
        if (feca == null) {
        } else {
            idFeca = getDaoTiempo().getFecha(feca).getTTmId();
            nuevoEnca.setTMoveFecafId(idFecaf);
        }
        idUs = appSession.getUsuario().getCUserId();
        nuevoEnca.setTMoveUsec(idUs);
        nuevoEnca.setTMoveFechc(fecha);
        nuevoEnca.setTMoveHorac(formatoHora.parse(formatoHora.format(fecha)));
        tipo=nuevoEnca.getTMoveTipt();
        System.out.println("est mov: "+estmoSeleccionado);
        System.out.println("tipo "+tipo);
        nuevoEnca.setCTipmId(getDaoTipMov().getTipmov(tipmo));
        nuevoEnca.setCEstmovId(getDaoEstmo().getEstMov(estmoSeleccionado));
        try {
             getDaoEnca().create(nuevoEnca);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Encabezado Agregado correctamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Encabezado NO se agregó"));

        }
        //actualizando correlativo en t_corr_mov
        int anio=nuevoEnca.getTMoveAnio();
	int nvoCorr=nuevoEnca.getTMoveCorr();
        nvoCorr=nvoCorr+1;
        System.out.println("nuevo corr: "+nvoCorr);
        getDaoCorrel().updateC(tipmo,anio,nvoCorr);
        System.out.println("corr actualizado");
        // habilitando para datos complementarios si aplica.
        m_id=nuevoEnca.getTMoveId();
        String tiper=" ";
         if (nuevoEnca.getTMoveTipt().equals(" ")) {}
             else{
             tiper=nuevoEnca.getTMoveTipt();
         }
        if (tiper.equals(" ")) {}
        else{
            tiper=nuevoEnca.getTMoveTipt();
            System.out.println("tiper");
            if (tiper.equals("E") && tipmo == 2){
                encSeleccionado=m_id;
                estadoC = false;
            }
            if (tiper.equals("E") && tipmo == 3){
                encSeleccionado=m_id;
                estadoR = false;
            }
        }
        respo=nuevoEnca.getTMovePere();
        //        FacesUtil.addMensaje("Bien Guardado");
        System.out.println("resp: "+respo);
        bienes = getDaoBienes().getListM(respo);
        System.out.println("lista vacía: "+bienes.isEmpty());
//        movenca = getDaoEnca().getList();
        movdeta = getDaoDeta().getListM(m_id);
        estado = true;
        return null;
    }

    public String actualE() throws NamingException, ParseException {
// buscar id por si cambiaron o agregaron fechas
        Date fecha = new Date();
        feca = encaSeleccionado.getTMoveFechaut();
        fecs = encaSeleccionado.getTMoveFecsal();
        fecr = encaSeleccionado.getTMoveFecret();
        feci = encaSeleccionado.getTMoveFecretr();
        if (feca == null) {
        } else {
            idFeca = getDaoTiempo().getFecha(feca).getTTmId();
            encaSeleccionado.setTMoveFecaId(idFeca);
        }
        if (fecr == null) {
        } else {
            idFecr = getDaoTiempo().getFecha(fecr).getTTmId();
            encaSeleccionado.setTMoveFecrId(idFecr);
        }
        if (feci == null) {
        } else {
            idFeci = getDaoTiempo().getFecha(feci).getTTmId();
            encaSeleccionado.setTMoveFeciId(idFeci);
        }
        if (fecs == null) {
        } else {
            idFecs = getDaoTiempo().getFecha(fecs).getTTmId();
            encaSeleccionado.setTMoveFecsId(idFecs);
        }
        //actualizando cambios en la tabla
        encaSeleccionado.setTMoveFechm(fecha);
        encaSeleccionado.setTMoveHoram(formatoHora.parse(formatoHora.format(fecha)));
        idUs = appSession.getUsuario().getCUserId();
        encaSeleccionado.setTMoveUsem(idUs);        
        getDaoEnca().edit(encaSeleccionado);
        respo=encaSeleccionado.getTMovePere();
        //generando tabla de nuevo
        bienes = getDaoBienes().getListM(respo);
        movenca = getDaoEnca().getList();
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos actualizados"));
//        bienSeleccionado = new TBienes();
        return null;

    }

    public List genTabla() throws NamingException {
        System.out.println("entrando a generar tabla");
        System.out.println("resp_"+respo);
        bienes = getDaoBienes().getListM(respo);
        System.out.println("lista vacía 2: "+bienes.isEmpty());        
        return bienes;
    }
    
    
    public String borrarE() throws NamingException {
        return null;
    }

    public String limpiarE() {
        enca = new TMovimEnca();
        deta = new TMovimDeta();
        nuevoEnca = new TMovimEnca();
        nuevoDeta = new TMovimDeta();
        estado = false;
        estadoC = true;
        estadoR = true;
        m_id=0;
        movenca = getDaoEnca().getList();
        movdeta = getDaoDeta().getListM(m_id);
        return null;
    }
    
        public void updateDetalle() {
        try {
            System.out.println("longi: "+selectedBienes.length);
            for (int i = 0; i < selectedBienes.length; i++) {
                 Integer idAct =  selectedBienes[i].getTBienId();
                 System.out.println("id sel"+idAct);
                 String codAct = selectedBienes[i].getTBienCodigo();
                 nuevoDeta.setTBienId(getDaoBienes().getIdCod(idAct));
                 nuevoDeta.setTMovdCodigo(codAct);
                 System.out.println("codigo: "+codAct);
                 System.out.println("m_id: "+m_id);
                 nuevoDeta.setTMoveId(getDaoEnca().getMove(m_id));
                 System.out.println("id enc_deta: "+nuevoDeta.getTMoveId());
                 getDaoDeta().create(nuevoDeta);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienes Agregados correctamente"));
            movdeta = getDaoDeta().getListM(m_id);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienes NO se agregaron"));

        }
    }
    public String actualD() throws NamingException {
        getDaoDeta().create(nuevoDeta);
        movdeta = getDaoDeta().getListM(m_id);
        return null;
    }    

    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    public String actualA() {
        //actualizando cambios en la tabla
//        System.out.println("actualizando");
//        System.out.println("id: "+archSeleccionado.getTArchId());
//        System.out.println("url: "+archSeleccionado.getTArchUrl());
        System.out.println("nom: " + archSeleccionado.getTArchNombre());
        getDaoArchiv().edit(archSeleccionado);
        FacesUtil.addMensaje("Datos Actualizados");
        docums = getDaoArchiv().getListT(tipref);
        return null;
    }

    public String borrarA() throws NamingException {
        getDaoArchiv().remove(archSeleccionado);
        docums = getDaoArchiv().getListT(tipref);
        return null;
    }


    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CNivelesFacadeLocal getDaoNivel() {
        return (CNivelesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CNivelesFacade!dao.CNivelesFacadeLocal");
    }
    
    private CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private TBienesFacadeLocal getDaoBienes() {
        return (TBienesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TBienesFacade!dao.TBienesFacadeLocal");
    }

    private TTiempoFacadeLocal getDaoTiempo() {
        return (TTiempoFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TTiempoFacade!dao.TTiempoFacadeLocal");
    }

    private TArchivosFacadeLocal getDaoArchiv() {
        return (TArchivosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TArchivosFacade!dao.TArchivosFacadeLocal");
    }

    private TMovimEncaFacadeLocal getDaoEnca() {
        return (TMovimEncaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TMovimEncaFacade!dao.TMovimEncaFacadeLocal");
    }    
    
    private TMovimDetaFacadeLocal getDaoDeta() {
        return (TMovimDetaFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TMovimDetaFacade!dao.TMovimDetaFacadeLocal");
    }    
    
    private CTiposMovFacadeLocal getDaoTipMov() {
        return (CTiposMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTiposMovFacade!dao.CTiposMovFacadeLocal");
    }    
    
    private TCorrMovFacadeLocal getDaoCorrel() {
        return (TCorrMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TCorrMovFacade!dao.TCorrMovFacadeLocal");
    }    
    
    private CEstadoMovFacadeLocal getDaoEstmo() {
        return (CEstadoMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoMovFacade!dao.CEstadoMovFacadeLocal");
    }

    private TPrestFacadeLocal getDaoPrest() {
        return (TPrestFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TPrestFacade!dao.TPrestFacadeLocal");
    }

    private TReparFacadeLocal getDaoRepar() {
        return (TReparFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TReparFacade!dao.TReparFacadeLocal");
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

    public List<CResponsables> getRespons() {
        return respons;
    }

    public void setRespons(List<CResponsables> respons) {
        this.respons = respons;
    }

    public List<CDependencias> getDepens() {
        return depens;
    }

    public void setDepens(List<CDependencias> depens) {
        this.depens = depens;
    }

    public List<CDependencias> getDepense() {
        return depense;
    }

    public void setDepense(List<CDependencias> depense) {
        this.depense = depense;
    }

    
    public List<CNiveles> getNiveles() {
        return niveles;
    }

    public void setNiveles(List<CNiveles> niveles) {
        this.niveles = niveles;
    }

    public CNiveles getNivelSeleccionado() {
        return nivelSeleccionado;
    }

    public void setNivelSeleccionado(CNiveles nivelSeleccionado) {
        this.nivelSeleccionado = nivelSeleccionado;
    }

    public Integer getNivSeleccionado() {
        return nivSeleccionado;
    }

    public void setNivSeleccionado(Integer nivSeleccionado) {
        this.nivSeleccionado = nivSeleccionado;
    }

    public Integer getNivSeleccionadoE() {
        return nivSeleccionadoE;
    }

    public void setNivSeleccionadoE(Integer nivSeleccionadoE) {
        this.nivSeleccionadoE = nivSeleccionadoE;
    }

    public List<CEstadoMov> getEstmovs() {
        return estmovs;
    }

    public void setEstmovs(List<CEstadoMov> estmovs) {
        this.estmovs = estmovs;
    }

    public Integer getEstmoSeleccionado() {
        return estmoSeleccionado;
    }

    public void setEstmoSeleccionado(Integer estmoSeleccionado) {
        this.estmoSeleccionado = estmoSeleccionado;
    }


    public List<TBienes> getBienes() {
        return bienes;
    }

    public void setBienes(List<TBienes> bienes) {
        this.bienes = bienes;
    }

    
    
   
    public Integer getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(Integer respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    public Integer getDepSeleccionada() {
        return depSeleccionada;
    }

    public void setDepSeleccionada(Integer depSeleccionada) {
        this.depSeleccionada = depSeleccionada;
    }

    public UploadedFile getPicture() {
        return picture;
    }

    public void setPicture(UploadedFile picture) {
        this.picture = picture;
    }

    public TArchivos getArchSeleccionado() {
        return archSeleccionado;
    }

    public void setArchSeleccionado(TArchivos archSeleccionado) {
        this.archSeleccionado = archSeleccionado;
    }

    public TArchivos getNuevoArch() {
        return nuevoArch;
    }

    public void setNuevoArch(TArchivos nuevoArch) {
        this.nuevoArch = nuevoArch;
    }

    public List<TArchivos> getDocums() {
        return docums;
    }

    public void setDocums(List<TArchivos> docums) {
        this.docums = docums;
    }

    public List<CTiposMov> getTiposm() {
        return tiposm;
    }

    public void setTiposm(List<CTiposMov> tiposm) {
        this.tiposm = tiposm;
    }

    public int getTipmo() {
        return tipmo;
    }

    public void setTipmo(int tipmo) {
        this.tipmo = tipmo;
    }

    public Integer getTipmSeleccionado() {
        return tipmSeleccionado;
    }

    public void setTipmSeleccionado(Integer tipmSeleccionado) {
        this.tipmSeleccionado = tipmSeleccionado;
    }


    public Integer getTiempoSeleccionado() {
        return tiempoSeleccionado;
    }

    public void setTiempoSeleccionado(Integer tiempoSeleccionado) {
        this.tiempoSeleccionado = tiempoSeleccionado;
    }

    public Integer getIdFecs() {
        return idFecs;
    }

    public void setIdFecs(Integer idFecs) {
        this.idFecs = idFecs;
    }

    public Integer getIdFecr() {
        return idFecr;
    }

    public void setIdFecr(Integer idFecr) {
        this.idFecr = idFecr;
    }

    public Integer getIdFeca() {
        return idFeca;
    }

    public void setIdFeca(Integer idFeca) {
        this.idFeca = idFeca;
    }

    public Integer getIdFeci() {
        return idFeci;
    }

    public void setIdFeci(Integer idFeci) {
        this.idFeci = idFeci;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoI() {
        return estadoI;
    }

    public void setEstadoI(Boolean estadoI) {
        this.estadoI = estadoI;
    }

    public Boolean getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(Boolean estadoC) {
        this.estadoC = estadoC;
    }

    public Boolean getEstadoR() {
        return estadoR;
    }

    public void setEstadoR(Boolean estadoR) {
        this.estadoR = estadoR;
    }

    
    public Integer getIdFecc() {
        return idFecc;
    }

    public void setIdFecc(Integer idFecc) {
        this.idFecc = idFecc;
    }

    public Integer getIdFecaf() {
        return idFecaf;
    }

    public void setIdFecaf(Integer idFecaf) {
        this.idFecaf = idFecaf;
    }

    public Date getFecs() {
        return fecs;
    }

    public void setFecs(Date fecs) {
        this.fecs = fecs;
    }

    public Date getFecr() {
        return fecr;
    }

    public void setFecr(Date fecr) {
        this.fecr = fecr;
    }

    public Date getFeci() {
        return feci;
    }

    public void setFeci(Date feci) {
        this.feci = feci;
    }

    public Date getFeca() {
        return feca;
    }

    public void setFeca(Date feca) {
        this.feca = feca;
    }

    public String getTipref() {
        return tipref;
    }

    public void setTipref(String tipref) {
        this.tipref = tipref;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipom() {
        return tipom;
    }

    public void setTipom(String tipom) {
        this.tipom = tipom;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    
    public TMovimEnca getEnca() {
        return enca;
    }

    public void setEnca(TMovimEnca enca) {
        this.enca = enca;
    }

    public TMovimEnca getNuevoEnca() {
        return nuevoEnca;
    }

    public void setNuevoEnca(TMovimEnca nuevoEnca) {
        this.nuevoEnca = nuevoEnca;
    }

    public TMovimEnca getEncaSeleccionado() {
        return encaSeleccionado;
    }

    public void setEncaSeleccionado(TMovimEnca encaSeleccionado) {
        this.encaSeleccionado = encaSeleccionado;
    }

    public Integer getEncSeleccionado() {
        return encSeleccionado;
    }

    public void setEncSeleccionado(Integer encSeleccionado) {
        this.encSeleccionado = encSeleccionado;
    }

    public List<TMovimEnca> getMovenca() {
        return movenca;
    }

    public void setMovenca(List<TMovimEnca> movenca) {
        this.movenca = movenca;
    }

    public List<TMovimDeta> getMovdeta() {
        return movdeta;
    }

    public void setMovdeta(List<TMovimDeta> movdeta) {
        this.movdeta = movdeta;
    }

    public TMovimDeta getNuevoDeta() {
        return nuevoDeta;
    }

    public void setNuevoDeta(TMovimDeta nuevoDeta) {
        this.nuevoDeta = nuevoDeta;
    }

    public TMovimDeta getDetaSeleccionado() {
        return detaSeleccionado;
    }

    public void setDetaSeleccionado(TMovimDeta detaSeleccionado) {
        this.detaSeleccionado = detaSeleccionado;
    }

    public Integer getDetSeleccionado() {
        return detSeleccionado;
    }

    public void setDetSeleccionado(Integer detSeleccionado) {
        this.detSeleccionado = detSeleccionado;
    }


    public CResponsablesFacadeLocal getRespFacade() {
        return respFacade;
    }

    public void setRespFacade(CResponsablesFacadeLocal respFacade) {
        this.respFacade = respFacade;
    }


    public CDependenciasFacadeLocal getDepeFacade() {
        return depeFacade;
    }

    public void setDepeFacade(CDependenciasFacadeLocal depeFacade) {
        this.depeFacade = depeFacade;
    }

    public DefaultStreamedContent getDownload() {
        return download;
    }

    public void setDownload(DefaultStreamedContent download) {
        this.download = download;
    }

    public Date getFech() {
        return fech;
    }

    public void setFech(Date fech) {
        this.fech = fech;
    }

    public List<TBienes> getDatosIn() {
        return datosIn;
    }

    public void setDatosIn(List<TBienes> datosIn) {
        this.datosIn = datosIn;
    }

    public List<TBienes> getBienesIn() {
        return bienesIn;
    }

    public void setBienesIn(List<TBienes> bienesIn) {
        this.bienesIn = bienesIn;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Object[] getIngre() {
        return ingre;
    }

    public void setIngre(String[] ingre) {
        this.ingre = ingre;
    }


    public Integer getIniCorr() {
        return iniCorr;
    }

    public void setIniCorr(Integer iniCorr) {
        this.iniCorr = iniCorr;
    }

    public Integer getEspec() {
        return espec;
    }

    public void setEspec(Integer espec) {
        this.espec = espec;
    }

    public TPrest getNuevoPrest() {
        return nuevoPrest;
    }

    public void setNuevoPrest(TPrest nuevoPrest) {
        this.nuevoPrest = nuevoPrest;
    }

    public TPrest getPrestSeleccionado() {
        return prestSeleccionado;
    }

    public void setPrestSeleccionado(TPrest prestSeleccionado) {
        this.prestSeleccionado = prestSeleccionado;
    }

    public Integer getPrestSelec() {
        return prestSelec;
    }

    public void setPrestSelec(Integer prestSelec) {
        this.prestSelec = prestSelec;
    }

    public List<TPrest> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<TPrest> prestamos) {
        this.prestamos = prestamos;
    }

    public TRepar getNuevaRepar() {
        return nuevaRepar;
    }

    public void setNuevaRepar(TRepar nuevaRepar) {
        this.nuevaRepar = nuevaRepar;
    }

    public TRepar getReparSeleccionada() {
        return reparSeleccionada;
    }

    public void setReparSeleccionada(TRepar reparSeleccionada) {
        this.reparSeleccionada = reparSeleccionada;
    }

    public Integer getReparSelec() {
        return reparSelec;
    }

    public void setReparSelec(Integer reparSelec) {
        this.reparSelec = reparSelec;
    }

    public List<TRepar> getRepars() {
        return repars;
    }

    public void setRepars(List<TRepar> repars) {
        this.repars = repars;
    }

    public TBienes getCodSeleccionado() {
        return codSeleccionado;
    }

    public void setCodSeleccionado(TBienes codSeleccionado) {
        this.codSeleccionado = codSeleccionado;
    }

    public Integer getCodSelec() {
        return codSelec;
    }

    public void setCodSelec(Integer codSelec) {
        this.codSelec = codSelec;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getRespo() {
        return respo;
    }

    public void setRespo(Integer respo) {
        this.respo = respo;
    }

    public TBienes[] getSelectedBienes() {
        return selectedBienes;
    }

    public void setSelectedBienes(TBienes[] selectedBienes) {
        this.selectedBienes = selectedBienes;
    }

    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    
    public void depSeleccionA() {
        nivSeleccionado = nuevoEnca.getTMoveNivs();
        depens = getDaoDepen().getListM(nivSeleccionado);
    }
    
    public void depSeleccionE() {
        nivSeleccionadoE = nuevoEnca.getTMoveNive();
        depense = getDaoDepen().getListM(nivSeleccionadoE);
    }
    
    public void nivDepSeleccion() {
//        nuevoBien.setCRespId(getDaoResp().getResp(respSeleccionado));
//        nivSeleccionado=nuevoBien.getCRespId().getCNivelId().getCNivelId();
//        depSeleccionada=nuevoBien.getCRespId().getCDepenId().getCDepenId();
//        nuevoBien.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
//        nuevoBien.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
    }



    public void asignarEdifArea() {
//        areas = getDaoArea().getListM(edifSeleccionado);
    }
    
    public void buscarCod() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoDeta.getTMovdCodigo();
        resul = getDaoBienes().busCod(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }
    
    
    
    
    public void buscarCorr() throws NamingException {
        
        int resul = 0;
        int anio;
//        String cod;
//        cod = nuevoDeta.getTMovdCodigo();
        tipmo=tipmSeleccionado;
        anio = nuevoEnca.getTMoveAnio();
//        System.out.println("tipmo: "+tipmo);
//        System.out.println("anio: "+anio);
        resul = getDaoCorrel().getCorrel(tipmo, anio).getTCorrCorrel();
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede encontrar correlativo"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
            estado = true;
        }
//        System.out.println("resul "+resul);
        nuevoEnca.setTMoveCorr(resul);
//        System.out.println("correl: "+nuevoEnca.getTMoveCorr());
    }
    
    public void tipSelec() {
        tipmo=tipmSeleccionado;
        System.out.println("tip "+tipmo);
    }

    public void tipSelecM() {
        estmo=estmoSeleccionado;
        System.out.println("estmov "+estmo);
    }
    public void tipoSel() {
        tipom=nuevoEnca.getTMoveTipt();
        System.out.println("tipo "+tipom);
    }
    
    
    public void buscarCodI() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoArch.getTArchCodref();
        resul = getDaoBienes().busCod(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código no Existe....no puede adicionar imagen"));
            estado = true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
            estado = false;
        }
    }
    
    public TBienes datosCodigo() throws NamingException {
        this.cod=cod;
        System.out.println("cod dig: "+cod);
//        cod = detaSeleccionado.getTMovdCodigo();
    	codSeleccionado = getDaoBienes().getCodBien(cod);
        System.out.println("despues de query"+codSeleccionado);
        desc=codSeleccionado.getTBienDesc();
	modelo=codSeleccionado.getTBienModelo();
	marca=codSeleccionado.getCMarcaId().getCMarcaId();
	serie=codSeleccionado.getTBienSerie();
	return codSeleccionado;
		}

    
 
    
    public Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public void guardarImagen() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String picture_directory = ctx.getExternalContext().getInitParameter("pictures_directory_path");
        //If directory exists ? do nothing : make directory
        File storage_folder = new File(picture_directory + nuevoArch.getTArchCodref());
        if (!storage_folder.exists()) {
            storage_folder.mkdir();
        }

        String nomAr = picture.getFileName();
        File archivoImagen = new File(picture_directory + nuevoArch.getTArchCodref() + "/" + nomAr);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = picture.getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            nuevoArch.setTArchNombre(picture.getFileName());
            nuevoArch.setTArchTipref(tipref);
            nuevoArch.setTArchUrl("/adjuntos/" + nuevoArch.getTArchCodref() + "/" + picture.getFileName());
            getDaoArchiv().create(nuevoArch);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Archivo cargado"));
            nuevoArch = new TArchivos();
            docums = getDaoArchiv().getListT(tipref);

        } catch (IOException e) {
            System.out.println(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede cargarse archivo"));

        }

    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String picture_directory = ctx.getExternalContext().getInitParameter("pictures_directory_path");
        //If directory exists ? do nothing : make directory
        File storage_folder = new File(picture_directory + nuevoDeta.getTMovdCodigo());
    }

}
