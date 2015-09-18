/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import dao.CAreasFacadeLocal;
import entidades.TBienes;
import entidades.TSustit;
import entidades.CEspecificos;
import entidades.CRubros;
import entidades.CResponsables;
import entidades.CDependencias;
import entidades.CEstadoBien;
import dao.TBienesFacade;
import dao.TBienesFacadeLocal;
import dao.TSustitFacade;
import dao.TSustitFacadeLocal;
import dao.CEspecificosFacade;
import dao.CEspecificosFacadeLocal;
import dao.CRubrosFacade;
import dao.CRubrosFacadeLocal;
import dao.CResponsablesFacade;
import dao.CResponsablesFacadeLocal;
import dao.CDependenciasFacade;
import dao.CDependenciasFacadeLocal;
import dao.CEdificiosFacadeLocal;
import dao.CEstadoBienFacade;
import dao.CEstadoBienFacadeLocal;
import dao.CJefesDepFacadeLocal;
import dao.CMarcasBmFacadeLocal;
import dao.CUbicFacadeLocal;
import entidades.TArchivos;
import dao.TArchivosFacade;
import dao.TArchivosFacadeLocal;
import dao.TCorrOtrFacadeLocal;
import dao.TRobHurFacadeLocal;
import dao.TTiempoFacadeLocal;
import entidades.CAreas;
import entidades.CEdificios;
import entidades.CJefesDep;
import entidades.CMarcasBm;
import entidades.CUbic;
import entidades.TTiempo;
import entidades.TCorrOtr;
import entidades.TRobHur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Soporte
 */
@ManagedBean
@SessionScoped
public class RoboHurtoBean implements Serializable {

    //private List<>  = new ArrayList<>();
    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    private List<TRobHur> robHur = new ArrayList<>();
    private TRobHur roboHur;
    private TRobHur nuevoRobo = new TRobHur();
    private TRobHur roboHurtoSeleccionada = new TRobHur();
    private List<TCorrOtr> correlativoRobo = new ArrayList<>();
    private List<CResponsables> responsableRobo = new ArrayList<>();
    private List<CUbic> ubicacionRobo = new ArrayList<>();
    private List<CJefesDep> jefeRobo = new ArrayList<>();
    private CJefesDep jefSelec = new CJefesDep();
    private List<CAreas> areasRobo = new ArrayList<>();
    private List<CEdificios> edificioRobo = new ArrayList<>();
    private List<CEspecificos> especificosRobo = new ArrayList<>();
    private List<CMarcasBm> marcaRobo = new ArrayList<>();
    private List<CRubros> rubroRobo = new ArrayList<>();
    private List<CDependencias> depenRobo = new ArrayList<>();
    private List<TBienes> bien = new ArrayList<>();
    private TBienes codSeleccionado = new TBienes();
    private List<CEstadoBien> estadoBien = new ArrayList<>();
    @ManagedProperty(value = "#{appSession}")
    private AppSession appSession;
    //private Integer claMov;
    private int idFec;
    private Integer idCod, claMov;
    private Integer respoSeleccionado, especSeleccionada, rubSeleccionado, depenSeleccionado, sustitSeleccionada, correlativo, idUs;
    private Integer estadSeleccionado, bienseleccionado, ducumseleccionado, ubicacionSeleccionada, jefeSeleccionado, areaSeleccionada, edificioSeleccionado, marcaSeleccionada;
    private double valBien;
    private String cod, modelo, serie;
    private Date fech = new Date();
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    private int anio, nvoCorr, idMovim;
    private Boolean estado = false;
    private Integer claseRH;
    private String clasRH;
    private Integer idFechDenun, idFechInf, idFechProces, claseM;
    private Date fechDenun, fechInf, fechProces;
    private String stringTipo;
    private String stringClase;
    private String stringEstadoFin;

    public RoboHurtoBean() {

        robHur = getDaoRoboHurto().getList();
        responsableRobo = getDaoResp().getList();
        depenRobo = getDaoDepen().getList();
        rubroRobo = getDaoRubro().getList();
        especificosRobo = getDaoEspec().getList();
        estadoBien = getDaoEstBien().getList();
        bien = getDaoBienes().getList();
        marcaRobo = getDaoMarcas().getList();
        ubicacionRobo = getDaoUbica().getList();
        jefeRobo = getDaoJefes().getList();
        edificioRobo = getDaoEdificio().getList();
        areasRobo = getDaoAreas().getList();

    }

    public String borrarB() throws NamingException {
        return null;
    }

    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    private CRubrosFacadeLocal getDaoRubro() {
        return (CRubrosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CRubrosFacade!dao.CRubrosFacadeLocal");
    }

    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CResponsablesFacadeLocal getDaoResp() {
        return (CResponsablesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CResponsablesFacade!dao.CResponsablesFacadeLocal");
    }

    private CEspecificosFacadeLocal getDaoEspec() {
        return (CEspecificosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEspecificosFacade!dao.CEspecificosFacadeLocal");
    }

    private CEstadoBienFacadeLocal getDaoEstBien() {
        return (CEstadoBienFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoBienFacade!dao.CEstadoBienFacadeLocal");
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

    private TRobHurFacadeLocal getDaoRoboHurto() {
        return (TRobHurFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TRobHurFacade!dao.TRobHurFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private CMarcasBmFacadeLocal getDaoMarcas() {
        return (CMarcasBmFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CMarcasBmFacade!dao.CMarcasBmFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private CUbicFacadeLocal getDaoUbica() {
        return (CUbicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CUbicFacade!dao.CUbicFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private CJefesDepFacadeLocal getDaoJefes() {
        return (CJefesDepFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CJefesDepFacade!dao.CJefesDepFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private CEdificiosFacadeLocal getDaoEdificio() {
        return (CEdificiosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEdificiosFacade!dao.CEdificiosFacadeLocal");//To change body of generated methods, choose Tools | Templates.
    }

    private CAreasFacadeLocal getDaoAreas() {
        return (CAreasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CAreasFacade!dao.CAreasFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

    private TCorrOtrFacadeLocal getDaoCorrel() {
        return (TCorrOtrFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/TCorrOtrFacade!dao.TCorrOtrFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
    }

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

    public List<TRobHur> getRobHur() {
        return robHur;
    }

    public void setRobHur(List<TRobHur> robHur) {
        this.robHur = robHur;
    }

    public TRobHur getRoboHur() {
        return roboHur;
    }

    public void setRoboHur(TRobHur roboHur) {
        this.roboHur = roboHur;
    }

    public TRobHur getNuevoRobo() {
        return nuevoRobo;
    }

    public void setNuevoRobo(TRobHur nuevoRobo) {
        this.nuevoRobo = nuevoRobo;
    }

    public TRobHur getRoboHurtoSeleccionada() {
        return roboHurtoSeleccionada;
    }

    public void setRoboHurtoSeleccionada(TRobHur roboHurtoSeleccionada) {
        this.roboHurtoSeleccionada = roboHurtoSeleccionada;
    }

    public List<TCorrOtr> getCorrelativoRobo() {
        return correlativoRobo;
    }

    public void setCorrelativoRobo(List<TCorrOtr> correlativoRobo) {
        this.correlativoRobo = correlativoRobo;
    }

    public List<CResponsables> getResponsableRobo() {
        return responsableRobo;
    }

    public void setResponsableRobo(List<CResponsables> responsableRobo) {
        this.responsableRobo = responsableRobo;
    }

    public List<CUbic> getUbicacionRobo() {
        return ubicacionRobo;
    }

    public void setUbicacionRobo(List<CUbic> ubicacionRobo) {
        this.ubicacionRobo = ubicacionRobo;
    }

    public List<CJefesDep> getJefeRobo() {
        return jefeRobo;
    }

    public void setJefeRobo(List<CJefesDep> jefeRobo) {
        this.jefeRobo = jefeRobo;
    }

    public List<CAreas> getAreasRobo() {
        return areasRobo;
    }

    public void setAreasRobo(List<CAreas> areasRobo) {
        this.areasRobo = areasRobo;
    }

    public List<CEdificios> getEdificioRobo() {
        return edificioRobo;
    }

    public void setEdificioRobo(List<CEdificios> edificioRobo) {
        this.edificioRobo = edificioRobo;
    }

    public List<CEspecificos> getEspecificosRobo() {
        return especificosRobo;
    }

    public void setEspecificosRobo(List<CEspecificos> especificosRobo) {
        this.especificosRobo = especificosRobo;
    }

    public List<CMarcasBm> getMarcaRobo() {
        return marcaRobo;
    }

    public void setMarcaRobo(List<CMarcasBm> marcaRobo) {
        this.marcaRobo = marcaRobo;
    }

    public List<CRubros> getRubroRobo() {
        return rubroRobo;
    }

    public void setRubroRobo(List<CRubros> rubroRobo) {
        this.rubroRobo = rubroRobo;
    }

    public List<CDependencias> getDepenRobo() {
        return depenRobo;
    }

    public void setDepenRobo(List<CDependencias> depenRobo) {
        this.depenRobo = depenRobo;
    }

    public List<TBienes> getBien() {
        return bien;
    }

    public void setBien(List<TBienes> bien) {
        this.bien = bien;
    }

    public TBienes getCodSeleccionado() {
        return codSeleccionado;
    }

    public void setCodSeleccionado(TBienes codSeleccionado) {
        this.codSeleccionado = codSeleccionado;
    }

    public List<CEstadoBien> getEstadoBien() {
        return estadoBien;
    }

    public void setEstadoBien(List<CEstadoBien> estadoBien) {
        this.estadoBien = estadoBien;
    }

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    public int getIdFec() {
        return idFec;
    }

    public void setIdFec(int idFec) {
        this.idFec = idFec;
    }

    public Integer getRespoSeleccionado() {
        return respoSeleccionado;
    }

    public void setRespoSeleccionado(Integer respoSeleccionado) {
        this.respoSeleccionado = respoSeleccionado;
    }

    public Integer getEspecSeleccionada() {
        return especSeleccionada;
    }

    public void setEspecSeleccionada(Integer especSeleccionada) {
        this.especSeleccionada = especSeleccionada;
    }

    public Integer getRubSeleccionado() {
        return rubSeleccionado;
    }

    public void setRubSeleccionado(Integer rubSeleccionado) {
        this.rubSeleccionado = rubSeleccionado;
    }

    public Integer getDepenSeleccionado() {
        return depenSeleccionado;
    }

    public void setDepenSeleccionado(Integer depenSeleccionado) {
        this.depenSeleccionado = depenSeleccionado;
    }

    public Integer getSustitSeleccionada() {
        return sustitSeleccionada;
    }

    public void setSustitSeleccionada(Integer sustitSeleccionada) {
        this.sustitSeleccionada = sustitSeleccionada;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public Integer getEstadSeleccionado() {
        return estadSeleccionado;
    }

    public void setEstadSeleccionado(Integer estadSeleccionado) {
        this.estadSeleccionado = estadSeleccionado;
    }

    public Integer getBienseleccionado() {
        return bienseleccionado;
    }

    public void setBienseleccionado(Integer bienseleccionado) {
        this.bienseleccionado = bienseleccionado;
    }

    public Integer getDucumseleccionado() {
        return ducumseleccionado;
    }

    public void setDucumseleccionado(Integer ducumseleccionado) {
        this.ducumseleccionado = ducumseleccionado;
    }

    public Integer getUbicacionSeleccionada() {
        return ubicacionSeleccionada;
    }

    public void setUbicacionSeleccionada(Integer ubicacionSeleccionada) {
        this.ubicacionSeleccionada = ubicacionSeleccionada;
    }

    public Integer getJefeSeleccionado() {
        return jefeSeleccionado;
    }

    public void setJefeSeleccionado(Integer jefeSeleccionado) {
        this.jefeSeleccionado = jefeSeleccionado;
    }

    public Integer getAreaSeleccionada() {
        return areaSeleccionada;
    }

    public void setAreaSeleccionada(Integer areaSeleccionada) {
        this.areaSeleccionada = areaSeleccionada;
    }

    public Integer getEdificioSeleccionado() {
        return edificioSeleccionado;
    }

    public void setEdificioSeleccionado(Integer edificioSeleccionado) {
        this.edificioSeleccionado = edificioSeleccionado;
    }

    public Integer getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Integer marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public double getValBien() {
        return valBien;
    }

    public void setValBien(double valBien) {
        this.valBien = valBien;
    }

    public Date getFech() {
        return fech;
    }

    public void setFech(Date fech) {
        this.fech = fech;
    }

    public SimpleDateFormat getFormatoHora() {
        return formatoHora;
    }

    public void setFormatoHora(SimpleDateFormat formatoHora) {
        this.formatoHora = formatoHora;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getNvoCorr() {
        return nvoCorr;
    }

    public void setNvoCorr(int nvoCorr) {
        this.nvoCorr = nvoCorr;
    }

    public CJefesDep getJefSelec() {
        return jefSelec;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setJefSelec(CJefesDep jefSelec) {
        this.jefSelec = jefSelec;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerie() {
        return serie;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getClaseRH() {
        return claseRH;
    }

    public void setClaseRH(Integer claseRH) {
        this.claseRH = claseRH;
    }

    public String getClasRH() {
        return clasRH;
    }

    public void setClasRH(String clasRH) {
        this.clasRH = clasRH;
    }

    public Integer getIdFechDenun() {
        return idFechDenun;
    }

    public void setIdFechDenun(Integer idFechDenun) {
        this.idFechDenun = idFechDenun;
    }

    public Integer getIdFechInf() {
        return idFechInf;
    }

    public void setIdFechInf(Integer idFechInf) {
        this.idFechInf = idFechInf;
    }

    public Integer getIdFechProces() {
        return idFechProces;
    }

    public void setIdFechProces(Integer idFechProces) {
        this.idFechProces = idFechProces;
    }

    public int getIdMovim() {
        return idMovim;
    }

    public void setIdMovim(int idMovim) {
        this.idMovim = idMovim;
    }

    public Date getFechDenun() {
        return fechDenun;
    }

    public void setFechDenun(Date fechDenun) {
        this.fechDenun = fechDenun;
    }

    public Date getFechInf() {
        return fechInf;
    }

    public void setFechInf(Date fechInf) {
        this.fechInf = fechInf;
    }

    public Date getFechProces() {
        return fechProces;
    }

    public void setFechProces(Date fechProces) {
        this.fechProces = fechProces;
    }

    public Integer getIdCod() {
        return idCod;
    }

    public void setIdCod(Integer idCod) {
        this.idCod = idCod;
    }

    public Integer getIdUs() {
        return idUs;
    }

    public void setIdUs(Integer idUs) {
        this.idUs = idUs;
    }

    public String getStringTipo() {
        return stringTipo;
    }

    public void setStringTipo(String stringTipo) {
        this.stringTipo = stringTipo;
    }

    
    public String getStringClase() {
        return stringClase;
    }

    public void setStringClase(String stringClase) {
        this.stringClase = stringClase;
    }

    public String getStringEstadoFin() {
        return stringEstadoFin;
    }

    public void setStringEstadoFin(String stringEstadoFin) {
        this.stringEstadoFin = stringEstadoFin;
    }

    public Integer getClaMov() {
        return claMov;
    }

    public void setClaMov(Integer claMov) {
        this.claMov = claMov;
    }
    
    
    public TBienes datosCodigo() throws NamingException {
        this.cod = cod;
        System.out.println("cod dig: " + cod);
//        cod = detaSeleccionado.getTMovdCodigo();
        codSeleccionado = getDaoBienes().getCodBien(cod);
//        System.out.println("despues de query" + codSeleccionado);
        if (codSeleccionado.getCDepenId() != null) {
            depenSeleccionado = codSeleccionado.getCDepenId().getCDepenId();

            System.out.println("cod dig: " + cod);
            jefSelec = getDaoJefes().getDep(depenSeleccionado);
            jefeSeleccionado = jefSelec.getCJefesdId();
            nuevoRobo.setCDepenId(getDaoDepen().getDepend(depenSeleccionado));
            nuevoRobo.setCJefesdId(getDaoJefes().getJefeDep(jefeSeleccionado));
        } else {
            depenSeleccionado = 0;
        }
        if (codSeleccionado.getCUbicId() != null) {
            ubicacionSeleccionada = codSeleccionado.getCUbicId().getCUbicId();
            nuevoRobo.setCUbicId(getDaoUbica().getUbic(ubicacionSeleccionada));
        } else {
            ubicacionSeleccionada = 0;
        }
        if (codSeleccionado.getCAreaId() != null) {
            areaSeleccionada = codSeleccionado.getCAreaId().getCAreaId();
        } else {
            areaSeleccionada = 0;
        }
        if (codSeleccionado.getCEdifId() != null) {
            edificioSeleccionado = codSeleccionado.getCEdifId().getCEdifId();
        } else {
            edificioSeleccionado = 0;
        }
        if (codSeleccionado.getCEstadbId() != null) {
            estadSeleccionado = codSeleccionado.getCEstadbId().getCEstadbId();
        } else {
            estadSeleccionado = 0;
        }
        if (codSeleccionado.getCRespId() != null) {
            respoSeleccionado = codSeleccionado.getCRespId().getCRespId();
            nuevoRobo.setCRespId(getDaoResp().getResp(respoSeleccionado));
        } else {
            respoSeleccionado = 0;
        }

        if (codSeleccionado.getCMarcaId() != null) {
            marcaSeleccionada = codSeleccionado.getCMarcaId().getCMarcaId();
        } else {
            marcaSeleccionada = 0;
        }

        if (codSeleccionado.getTBienValoradq() != null) {
            valBien = codSeleccionado.getTBienValoradq();
        } else {
            valBien = 0;
        }

        System.out.println("codsel: " + codSeleccionado);
        return codSeleccionado;
    }

    public String guardarRoboHurto() throws NamingException, ParseException {
        fechDenun = nuevoRobo.getTRhFecdenun();
        fechInf = nuevoRobo.getTRhFecinfor();
        fechProces = nuevoRobo.getTRhFecfin();
        if (fechDenun == null) {
        } else {
            idFechDenun = getDaoTiempo().getFecha(fechDenun).getTTmId();
            nuevoRobo.setTRhFecdenunId(idFechDenun);
        }
        if (fechInf == null) {
        } else {
            idFechInf = getDaoTiempo().getFecha(fechInf).getTTmId();
            nuevoRobo.setTRhFecinforId(idFechInf);
        }
        if (fechProces == null) {
        } else {
            idFechProces = getDaoTiempo().getFecha(fechProces).getTTmId();
            nuevoRobo.setTRhFecfinId(idFechProces);
        }
        nuevoRobo.setTRhFechc(fech);
        idFec = getDaoTiempo().getFecha(fech).getTTmId();
        nuevoRobo.setTTmId(getDaoTiempo().getTm(idFec));

        if (codSeleccionado.getCDepenId() != null) {
            depenSeleccionado = codSeleccionado.getCDepenId().getCDepenId();
            jefSelec = getDaoJefes().getDep(depenSeleccionado);
            if ((jefeSeleccionado = jefSelec.getCJefesdId()) != null) {
                nuevoRobo.setCJefesdId(getDaoJefes().getJefeDep(jefeSeleccionado));
            } else {
                jefeSeleccionado = 0;
            }
            nuevoRobo.setCDepenId(getDaoDepen().getDepend(depenSeleccionado));
        } else {
            depenSeleccionado = 0;
        }

        if (codSeleccionado.getCUbicId() != null) {
            ubicacionSeleccionada = codSeleccionado.getCUbicId().getCUbicId();
            nuevoRobo.setCUbicId(getDaoUbica().getUbic(ubicacionSeleccionada));
        } else {
            ubicacionSeleccionada = 0;
        }

        if (codSeleccionado.getCAreaId() != null) {
            areaSeleccionada = codSeleccionado.getCAreaId().getCAreaId();
            nuevoRobo.setCAreaId(getDaoAreas().getArea(areaSeleccionada));
        } else {
            areaSeleccionada = 0;
        }
        if (codSeleccionado.getCEdifId() != null) {
            edificioSeleccionado = codSeleccionado.getCEdifId().getCEdifId();
            nuevoRobo.setCEdifId(getDaoEdificio().getEdif(edificioSeleccionado));
        } else {
            edificioSeleccionado = 0;
        }

        if (codSeleccionado.getCRespId() != null) {
            respoSeleccionado = codSeleccionado.getCRespId().getCRespId();
            nuevoRobo.setCRespId(getDaoResp().getResp(respoSeleccionado));
        } else {
            respoSeleccionado = 0;
        }
        
        if(claseSel() == 1){
            idMovim = 3;
        }else {
            idMovim = 4;
        }
        System.out.println("id del movimiento" +idMovim);
        nuevoRobo.setTRhCodigo(codSeleccionado.getTBienCodigo());
        idCod = codSeleccionado.getTBienId();
        nuevoRobo.setTBienId(getDaoBienes().getBien(idCod));
        idUs = appSession.getUsuario().getCUserId();
        nuevoRobo.setTRhUsec(idUs);
        nuevoRobo.setTRhHorac(formatoHora.parse(formatoHora.format(fech)));
        anio = nuevoRobo.getTRhAnio();
        nvoCorr = nuevoRobo.getTRhCorr();
        nvoCorr = nvoCorr + 1;
        System.out.println("nuevo corr: " + nvoCorr);
        getDaoCorrel().updateC(anio, nvoCorr, idMovim);
        System.out.println("corr actualizado");

        getDaoRoboHurto().create(nuevoRobo);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos agregados correctamente"));

        estado = true;
        System.out.println("Se guardo");
        return null;

    }

    public void buscarCorr() throws NamingException {

        int resul = 0;
        int annio;

        if (claseSel() == 1) {

            annio = nuevoRobo.getTRhAnio();
            resul = getDaoCorrel().getTOtrocCorrel(3, annio).getTOtrocCorrel();
            if (resul == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede encontrar correlativo"));
                estado = false;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
                estado = true;
            }
            nuevoRobo.setTRhCorr(resul);

        } else if(claseSel() == 2){
            annio = nuevoRobo.getTRhAnio();
            resul = getDaoCorrel().getTOtrocCorrel(4, annio).getTOtrocCorrel();
            if (resul == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede encontrar correlativo"));
                estado = false;
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
                estado = true;
            }
            nuevoRobo.setTRhCorr(resul);

        }else{
    }
    }

    public Integer claseSel() {
        claseM = nuevoRobo.getTRhClase();
        System.out.println("clase "+claseM);
        return claseM;
    }
    
    public String verClase(){
        Integer aux1 = roboHurtoSeleccionada.getTRhClase();
        if (aux1 == 1){
            stringClase = "Robo";
        }else{
            stringClase = "Hurto"; 
        }
        return stringClase;
    }
    
    
//    public void verClase(){
//        claMov = nuevoRobo.getTRhClase();
//    }
    
    public String actualizarRoboHurto(){
        
        fechDenun = nuevoRobo.getTRhFecdenun();
        fechInf = nuevoRobo.getTRhFecinfor();
        fechProces = nuevoRobo.getTRhFecfin();
        if (fechDenun == null) {
        } else {
            idFechDenun = getDaoTiempo().getFecha(fechDenun).getTTmId();
            nuevoRobo.setTRhFecdenunId(idFechDenun);
        }
        if (fechInf == null) {
        } else {
            idFechInf = getDaoTiempo().getFecha(fechInf).getTTmId();
            nuevoRobo.setTRhFecinforId(idFechInf);
        }
        if (fechProces == null) {
        } else {
            idFechProces = getDaoTiempo().getFecha(fechProces).getTTmId();
            nuevoRobo.setTRhFecfinId(idFechProces);
        }
        
        //Usuario que actualiza
        idUs = appSession.getUsuario().getCUserId();
        roboHurtoSeleccionada.setTRhUsem(idUs);
        System.out.println("Usuario que modifica"+ idUs);
        //Actualizando Tabla de fechas
        roboHurtoSeleccionada.setTRhFechm(new Date());
        idFec = getDaoTiempo().getFecha(new Date()).getTTmId();
        roboHurtoSeleccionada.setTTmId(getDaoTiempo().getTm(idFec));
        try {
            roboHurtoSeleccionada.setTRhHoram(formatoHora.parse(formatoHora.format(new Date())));
        } catch (ParseException ex) {
            Logger.getLogger(RoboHurtoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Se Actualizo");
        getDaoRoboHurto().edit(roboHurtoSeleccionada);
        robHur = getDaoRoboHurto().getList();
        return null;
    }

     public String limpiarRH() {
        codSeleccionado = new TBienes();
        nuevoRobo = new TRobHur();
        robHur = getDaoRoboHurto().getList();
        cod=" ";
        modelo=" ";
        serie=" ";
        jefSelec = new CJefesDep();
        valBien= 0.00;
//        estado = false;
        return null;
    }
}
