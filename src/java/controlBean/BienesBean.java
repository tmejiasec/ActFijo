/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import dao.CAreasFacadeLocal;
import dao.CRubrosFacadeLocal;
import entidades.CRubros;
import dao.CEspecificosFacadeLocal;
import entidades.CEspecificos;
import dao.CEstadoBienFacadeLocal;
import entidades.CEstadoBien;
import dao.CCondBienFacadeLocal;
import entidades.CCondBien;
import dao.CEstadoProcFacadeLocal;
import dao.CFormasAdqFacadeLocal;
import dao.CFuentesFinFacadeLocal;
import dao.CMarcasBmFacadeLocal;
import dao.CProveedoresFacadeLocal;
import dao.CProyectosFacadeLocal;
import dao.CResponsablesFacadeLocal;
import entidades.CEstadoProc;
import dao.CTipDescargFacadeLocal;
import dao.CTipDocFacadeLocal;
import entidades.CAreas;
import dao.CDependenciasFacadeLocal;
import dao.CEdificiosFacadeLocal;
import entidades.CDependencias;
import entidades.CEdificios;
import entidades.CFormasAdq;
import entidades.CFuentesFin;
import entidades.CMarcasBm;
import dao.CNivelesFacadeLocal;
import dao.CUbicFacadeLocal;
import dao.TArchivosFacadeLocal;
import dao.TBienesFacadeLocal;
import dao.TTiempoFacadeLocal;
import entidades.CNiveles;
import entidades.CProveedores;
import entidades.CProyectos;
import entidades.CResponsables;
import entidades.CTipDescarg;
import entidades.CTipDoc;
import entidades.CUbic;
import entidades.TArchivos;
import entidades.TBienes;
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
public class BienesBean implements Serializable {

    protected Integer tabIndex = 1;
    private List<CResponsables> respons = new ArrayList<>();
    private List<CNiveles> niveles = new ArrayList<>();
    private List<CDependencias> depens = new ArrayList<>();
    private List<CEdificios> edificios = new ArrayList<>();
    private List<CAreas> areas = new ArrayList<>();
    private List<CUbic> ubics = new ArrayList<>();
    private List<CRubros> rubros = new ArrayList<>();
    private List<CEspecificos> especs = new ArrayList<>();
    private List<CMarcasBm> marcas = new ArrayList<>();
    private List<CFormasAdq> formas = new ArrayList<>();
    private List<CTipDoc> tipdocs = new ArrayList<>();
    private List<CFuentesFin> fuentes = new ArrayList<>();
    private List<CProveedores> provs = new ArrayList<>();
    private List<CProyectos> proys = new ArrayList<>();
    private List<CEstadoBien> estbiens = new ArrayList<>();
    private List<CCondBien> conbiens = new ArrayList<>();
    private List<CEstadoProc> estprocs = new ArrayList<>();
    private List<CTipDescarg> tipdes = new ArrayList<>();
    List<TArchivos> docums = new ArrayList<>();
    private TArchivos archSeleccionado = new TArchivos();
    private TArchivos nuevoArch = new TArchivos();

    private Integer respSeleccionado, nivSeleccionado, depSeleccionada, edifSeleccionado, areaSeleccionada, ubicSeleccionada;
    private Integer rubSeleccionado, espSeleccionado, marcaSeleccionada, formSeleccionada, tdocSeleccionado, ftefSeleccionada;
    private Integer provSeleccionado, proySeleccionado, estbSeleccionado, condbSeleccionado, estpSeleccionado, tdescSeleccionado;
    private Integer tiempoSeleccionado, idAdq, idReg, idDep, idGar, bienIng;

    private CResponsablesFacadeLocal respFacade;
    private CNivelesFacadeLocal nivFacade;
    private CDependenciasFacadeLocal depeFacade;
    private CEdificiosFacadeLocal ediFacade;
    private CAreasFacadeLocal areaFacade;
    private CUbicFacadeLocal ubicFacade;
    private CRubrosFacadeLocal rubroFacade;
    private CEspecificosFacadeLocal especFacade;
    private CMarcasBmFacadeLocal marcaFacade;
    private CCondBienFacadeLocal condbFacade;
    private CEstadoBienFacadeLocal estbFacade;
    private CEstadoProcFacadeLocal estpFacade;
    private CFormasAdqFacadeLocal formadFacade;
    private CFuentesFinFacadeLocal ftefFacade;
    private CProveedoresFacadeLocal provFacade;
    private CProyectosFacadeLocal proyFacade;
    private CTipDocFacadeLocal tipdFacade;
    private CTipDescargFacadeLocal tdescarFacade;
    private Date fech = new Date();
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    private int cantLote = 0;
    private Boolean ingLote = false;
    private Boolean estado = false;
    private Boolean estadoI = false;
    private Boolean estadoIn = false;
    Date fecad, fecgar, fecreg, fecdep;

    private String nomNiv, nomDep, regBien;
    private String tipref = "REG";
    private String tipo = "F";
    private List<TBienes> bienes = new ArrayList<>();
    private List<TBienes> lotes = new ArrayList<>();
    private TBienes bien;
    private TBienes nuevoBien = new TBienes();
    private TBienes bienSeleccionado = new TBienes();
    private TBienes bienIngLote = new TBienes();
    private List datosIn;
    private List bienesIn = new ArrayList<>();
    //   private List bienesIn;
    private Object[] ingre;

    protected Boolean edit = false;
    private String desc, cod;
    private UploadedFile picture;
    private static final int BUFFER_SIZE = 1000000;
    private DefaultStreamedContent download;

    /**
     * Creates a new instance
     */
    public BienesBean() {
        rubros = getDaoRubro().getList();
        especs = getDaoEspec().getList();
        estbiens = getDaoEstBien().getList();
        conbiens = getDaoConBien().getList();
        estprocs = getDaoEstProc().getList();
        tipdes = getDaoTipDesc().getList();
        niveles = getDaoNivel().getList();
        depens = getDaoDepen().getList();
        edificios = getDaoEdif().getList();
        areas = getDaoArea().getList();
        ubics = getDaoUbic().getList();
        respons = getDaoResp().getList();
        fuentes = getDaoFuentes().getList();
        formas = getDaoFormas().getList();
        tipdocs = getDaoTipdoc().getList();
        proys = getDaoProyec().getList();
        provs = getDaoProvee().getList();
        marcas = getDaoMarcas().getList();
        bienes = getDaoBienes().getList();
        lotes = getDaoBienes().getListL();
        docums = getDaoArchiv().getList();
    }

    public String guardarB() throws NamingException, ParseException {
        Date fecha = new Date();
        // buscando id de fechas
        fecad = nuevoBien.getTBienFechadq();
        fecgar = nuevoBien.getTBienFechvgar();
        fecreg = nuevoBien.getTBienFechregb();
        fecdep = nuevoBien.getTBienFechinidep();
        if (fecad == null) {
        } else {
            idAdq = getDaoTiempo().getFecha(fecad).getTTmId();
            nuevoBien.setTBienFecadId(idAdq);
        }
        if (fecgar == null) {
        } else {
            idGar = getDaoTiempo().getFecha(fecgar).getTTmId();
            nuevoBien.setTBienFvgarId(idGar);
        }
        if (fecreg == null) {
        } else {
            idReg = getDaoTiempo().getFecha(fecreg).getTTmId();
            nuevoBien.setTBienFregId(idReg);
        }
        if (fecdep == null) {
        } else {
            idDep = getDaoTiempo().getFecha(fecdep).getTTmId();
            nuevoBien.setTBienFinidId(idDep);
        }
        nuevoBien.setTBienHoracrea(formatoHora.parse(formatoHora.format(fecha)));
        // creando registro y guardando datos
        getDaoBienes().create(nuevoBien);
        //        FacesUtil.addMensaje("Bien Guardado");
        bienes = getDaoBienes().getList();
        lotes = getDaoBienes().getListL();
        estado = true;
        return null;
    }

    public String actualB() throws NamingException, ParseException {
// buscar id por si cambiaron o agregaron fechas
        Date fecha = new Date();
        fecad = bienSeleccionado.getTBienFechadq();
        fecgar = bienSeleccionado.getTBienFechvgar();
        fecreg = bienSeleccionado.getTBienFechregb();
        fecdep = bienSeleccionado.getTBienFechinidep();
        if (fecad == null) {
        } else {
            idAdq = getDaoTiempo().getFecha(fecad).getTTmId();
            bienSeleccionado.setTBienFecadId(idAdq);
        }
        if (fecgar == null) {
        } else {
            idGar = getDaoTiempo().getFecha(fecgar).getTTmId();
            bienSeleccionado.setTBienFvgarId(idGar);
        }
        if (fecreg == null) {
        } else {
            idReg = getDaoTiempo().getFecha(fecreg).getTTmId();
            bienSeleccionado.setTBienFregId(idReg);
        }
        if (fecdep == null) {
        } else {
            idDep = getDaoTiempo().getFecha(fecdep).getTTmId();
            bienSeleccionado.setTBienFinidId(idDep);
        }
        //actualizando cambios en la tabla
        bienSeleccionado.setTBienFechmod(fecha);
        bienSeleccionado.setTBienHoramod(formatoHora.parse(formatoHora.format(fecha)));
        getDaoBienes().edit(bienSeleccionado);
        //generando tabla de nuevo
        bienes = getDaoBienes().getList();
        lotes = getDaoBienes().getListL();
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos actualizados"));
//        bienSeleccionado = new TBienes();
        return null;

    }

    public String borrarB() throws NamingException {
        return null;
    }

    public String limpiarB() {
        bien = new TBienes();
        nuevoBien = new TBienes();
        bienes = getDaoBienes().getList();
        lotes = getDaoBienes().getListL();
        estado = false;
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
        docums = getDaoArchiv().getList();
        return null;
    }

    public String borrarA() throws NamingException {
        getDaoArchiv().remove(archSeleccionado);
        docums = getDaoArchiv().getList();
        return null;
    }

    private CNivelesFacadeLocal getDaoNivel() {
        return (CNivelesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CNivelesFacade!dao.CNivelesFacadeLocal");
    }

    private CDependenciasFacadeLocal getDaoDepen() {
        return (CDependenciasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CDependenciasFacade!dao.CDependenciasFacadeLocal");
    }

    private CEdificiosFacadeLocal getDaoEdif() {
        return (CEdificiosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEdificiosFacade!dao.CEdificiosFacadeLocal");
    }

    private CAreasFacadeLocal getDaoArea() {
        return (CAreasFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CAreasFacade!dao.CAreasFacadeLocal");
    }

    private CUbicFacadeLocal getDaoUbic() {
        return (CUbicFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CUbicFacade!dao.CUbicFacadeLocal");
    }

    private CRubrosFacadeLocal getDaoRubro() {
        return (CRubrosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CRubrosFacade!dao.CRubrosFacadeLocal");
    }

    private CEspecificosFacadeLocal getDaoEspec() {
        return (CEspecificosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEspecificosFacade!dao.CEspecificosFacadeLocal");
    }

    private CEstadoBienFacadeLocal getDaoEstBien() {
        return (CEstadoBienFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoBienFacade!dao.CEstadoBienFacadeLocal");
    }

    private CCondBienFacadeLocal getDaoConBien() {
        return (CCondBienFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CCondBienFacade!dao.CCondBienFacadeLocal");
    }

    private CEstadoProcFacadeLocal getDaoEstProc() {
        return (CEstadoProcFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoProcFacade!dao.CEstadoProcFacadeLocal");
    }

    private CTipDescargFacadeLocal getDaoTipDesc() {
        return (CTipDescargFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTipDescargFacade!dao.CTipDescargFacadeLocal");
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

    public List<CEdificios> getEdificios() {
        return edificios;
    }

    public void setEdificios(List<CEdificios> edificios) {
        this.edificios = edificios;
    }

    public List<CAreas> getAreas() {
        return areas;
    }

    public void setAreas(List<CAreas> areas) {
        this.areas = areas;
    }

    public List<CUbic> getUbics() {
        return ubics;
    }

    public void setUbics(List<CUbic> ubics) {
        this.ubics = ubics;
    }

    public List<CRubros> getRubros() {
        return rubros;
    }

    public void setRubros(List<CRubros> rubros) {
        this.rubros = rubros;
    }

    public List<CEspecificos> getEspecs() {
        return especs;
    }

    public void setEspecs(List<CEspecificos> especs) {
        this.especs = especs;
    }

    public List<CMarcasBm> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<CMarcasBm> marcas) {
        this.marcas = marcas;
    }

    public List<CFormasAdq> getFormas() {
        return formas;
    }

    public void setFormas(List<CFormasAdq> formas) {
        this.formas = formas;
    }

    public List<CTipDoc> getTipdocs() {
        return tipdocs;
    }

    public void setTipdocs(List<CTipDoc> tipdocs) {
        this.tipdocs = tipdocs;
    }

    public List<CFuentesFin> getFuentes() {
        return fuentes;
    }

    public void setFuentes(List<CFuentesFin> fuentes) {
        this.fuentes = fuentes;
    }

    public List<CProveedores> getProvs() {
        return provs;
    }

    public void setProvs(List<CProveedores> provs) {
        this.provs = provs;
    }

    public List<CProyectos> getProys() {
        return proys;
    }

    public void setProys(List<CProyectos> proys) {
        this.proys = proys;
    }

    public List<CEstadoBien> getEstbiens() {
        return estbiens;
    }

    public void setEstbiens(List<CEstadoBien> estbiens) {
        this.estbiens = estbiens;
    }

    public List<CCondBien> getConbiens() {
        return conbiens;
    }

    public void setConbiens(List<CCondBien> conbiens) {
        this.conbiens = conbiens;
    }

    public List<CEstadoProc> getEstprocs() {
        return estprocs;
    }

    public void setEstprocs(List<CEstadoProc> estprocs) {
        this.estprocs = estprocs;
    }

    public List<CTipDescarg> getTipdes() {
        return tipdes;
    }

    public void setTipdes(List<CTipDescarg> tipdes) {
        this.tipdes = tipdes;
    }

    public List<TBienes> getBienes() {
        return bienes;
    }

    public void setBienes(List<TBienes> bienes) {
        this.bienes = bienes;
    }

    public List<TBienes> getLotes() {
        return lotes;
    }

    public void setLotes(List<TBienes> lotes) {
        this.lotes = lotes;
    }

    public TBienes getBien() {
        return bien;
    }

    public void setBien(TBienes bien) {
        this.bien = bien;
    }

    public TBienes getNuevoBien() {
        return nuevoBien;
    }

    public void setNuevoBien(TBienes nuevoBien) {
        this.nuevoBien = nuevoBien;
    }

    public TBienes getBienSeleccionado() {
        return bienSeleccionado;
    }

    public void setBienSeleccionado(TBienes bienSeleccionado) {
        this.bienSeleccionado = bienSeleccionado;
    }

    public Integer getRespSeleccionado() {
        return respSeleccionado;
    }

    public void setRespSeleccionado(Integer respSeleccionado) {
        this.respSeleccionado = respSeleccionado;
    }

    public Integer getNivSeleccionado() {
        return nivSeleccionado;
    }

    public void setNivSeleccionado(Integer nivSeleccionado) {
        this.nivSeleccionado = nivSeleccionado;
    }

    public Integer getDepSeleccionada() {
        return depSeleccionada;
    }

    public void setDepSeleccionada(Integer depSeleccionada) {
        this.depSeleccionada = depSeleccionada;
    }

    public Integer getEdifSeleccionado() {
        return edifSeleccionado;
    }

    public void setEdifSeleccionado(Integer edifSeleccionado) {
        this.edifSeleccionado = edifSeleccionado;
    }

    public Integer getAreaSeleccionada() {
        return areaSeleccionada;
    }

    public void setAreaSeleccionada(Integer areaSeleccionada) {
        this.areaSeleccionada = areaSeleccionada;
    }

    public Integer getUbicSeleccionada() {
        return ubicSeleccionada;
    }

    public void setUbicSeleccionada(Integer ubicSeleccionada) {
        this.ubicSeleccionada = ubicSeleccionada;
    }

    public Integer getRubSeleccionado() {
        return rubSeleccionado;
    }

    public void setRubSeleccionado(Integer rubSeleccionado) {
        this.rubSeleccionado = rubSeleccionado;
    }

    public Integer getEspSeleccionado() {
        return espSeleccionado;
    }

    public void setEspSeleccionado(Integer espSeleccionado) {
        this.espSeleccionado = espSeleccionado;
    }

    public Integer getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Integer marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public Integer getFormSeleccionada() {
        return formSeleccionada;
    }

    public void setFormSeleccionada(Integer formSeleccionada) {
        this.formSeleccionada = formSeleccionada;
    }

    public Integer getTdocSeleccionado() {
        return tdocSeleccionado;
    }

    public void setTdocSeleccionado(Integer tdocSeleccionado) {
        this.tdocSeleccionado = tdocSeleccionado;
    }

    public Integer getFtefSeleccionada() {
        return ftefSeleccionada;
    }

    public void setFtefSeleccionada(Integer ftefSeleccionada) {
        this.ftefSeleccionada = ftefSeleccionada;
    }

    public Integer getProvSeleccionado() {
        return provSeleccionado;
    }

    public void setProvSeleccionado(Integer provSeleccionado) {
        this.provSeleccionado = provSeleccionado;
    }

    public Integer getProySeleccionado() {
        return proySeleccionado;
    }

    public void setProySeleccionado(Integer proySeleccionado) {
        this.proySeleccionado = proySeleccionado;
    }

    public Integer getEstbSeleccionado() {
        return estbSeleccionado;
    }

    public void setEstbSeleccionado(Integer estbSeleccionado) {
        this.estbSeleccionado = estbSeleccionado;
    }

    public Integer getCondbSeleccionado() {
        return condbSeleccionado;
    }

    public void setCondbSeleccionado(Integer condbSeleccionado) {
        this.condbSeleccionado = condbSeleccionado;
    }

    public Integer getEstpSeleccionado() {
        return estpSeleccionado;
    }

    public void setEstpSeleccionado(Integer estpSeleccionado) {
        this.estpSeleccionado = estpSeleccionado;
    }

    public Integer getTdescSeleccionado() {
        return tdescSeleccionado;
    }

    public void setTdescSeleccionado(Integer tdescSeleccionado) {
        this.tdescSeleccionado = tdescSeleccionado;
    }

    public int getCantLote() {
        return cantLote;
    }

    public void setCantLote(int cantLote) {
        this.cantLote = cantLote;
    }

    public Boolean getIngLote() {
        return ingLote;
    }

    public void setIngLote(Boolean ingLote) {
        this.ingLote = ingLote;
    }

    public Date getFecad() {
        return fecad;
    }

    public void setFecad(Date fecad) {
        this.fecad = fecad;
    }

    public Date getFecgar() {
        return fecgar;
    }

    public void setFecgar(Date fecgar) {
        this.fecgar = fecgar;
    }

    public Date getFecreg() {
        return fecreg;
    }

    public void setFecreg(Date fecreg) {
        this.fecreg = fecreg;
    }

    public Date getFecdep() {
        return fecdep;
    }

    public void setFecdep(Date fecdep) {
        this.fecdep = fecdep;
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

    public String getNomNiv() {
        return nomNiv;
    }

    public void setNomNiv(String nomNiv) {
        this.nomNiv = nomNiv;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public Integer getTiempoSeleccionado() {
        return tiempoSeleccionado;
    }

    public void setTiempoSeleccionado(Integer tiempoSeleccionado) {
        this.tiempoSeleccionado = tiempoSeleccionado;
    }

    public Integer getIdAdq() {
        return idAdq;
    }

    public void setIdAdq(Integer idAdq) {
        this.idAdq = idAdq;
    }

    public Integer getIdReg() {
        return idReg;
    }

    public void setIdReg(Integer idReg) {
        this.idReg = idReg;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Integer getIdGar() {
        return idGar;
    }

    public void setIdGar(Integer idGar) {
        this.idGar = idGar;
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

    public Boolean getEstadoIn() {
        return estadoIn;
    }

    public void setEstadoIn(Boolean estadoIn) {
        this.estadoIn = estadoIn;
    }

    public Integer getBienIng() {
        return bienIng;
    }

    public void setBienIng(Integer bienIng) {
        this.bienIng = bienIng;
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

    public CResponsablesFacadeLocal getRespFacade() {
        return respFacade;
    }

    public void setRespFacade(CResponsablesFacadeLocal respFacade) {
        this.respFacade = respFacade;
    }

    public CNivelesFacadeLocal getNivFacade() {
        return nivFacade;
    }

    public void setNivFacade(CNivelesFacadeLocal nivFacade) {
        this.nivFacade = nivFacade;
    }

    public CDependenciasFacadeLocal getDepeFacade() {
        return depeFacade;
    }

    public void setDepeFacade(CDependenciasFacadeLocal depeFacade) {
        this.depeFacade = depeFacade;
    }

    public CEdificiosFacadeLocal getEdiFacade() {
        return ediFacade;
    }

    public void setEdiFacade(CEdificiosFacadeLocal ediFacade) {
        this.ediFacade = ediFacade;
    }

    public CAreasFacadeLocal getAreaFacade() {
        return areaFacade;
    }

    public void setAreaFacade(CAreasFacadeLocal areaFacade) {
        this.areaFacade = areaFacade;
    }

    public CUbicFacadeLocal getUbicFacade() {
        return ubicFacade;
    }

    public void setUbicFacade(CUbicFacadeLocal ubicFacade) {
        this.ubicFacade = ubicFacade;
    }

    public CRubrosFacadeLocal getRubroFacade() {
        return rubroFacade;
    }

    public void setRubroFacade(CRubrosFacadeLocal rubroFacade) {
        this.rubroFacade = rubroFacade;
    }

    public CEspecificosFacadeLocal getEspecFacade() {
        return especFacade;
    }

    public void setEspecFacade(CEspecificosFacadeLocal especFacade) {
        this.especFacade = especFacade;
    }

    public CMarcasBmFacadeLocal getMarcaFacade() {
        return marcaFacade;
    }

    public void setMarcaFacade(CMarcasBmFacadeLocal marcaFacade) {
        this.marcaFacade = marcaFacade;
    }

    public CCondBienFacadeLocal getCondbFacade() {
        return condbFacade;
    }

    public void setCondbFacade(CCondBienFacadeLocal condbFacade) {
        this.condbFacade = condbFacade;
    }

    public CEstadoBienFacadeLocal getEstbFacade() {
        return estbFacade;
    }

    public void setEstbFacade(CEstadoBienFacadeLocal estbFacade) {
        this.estbFacade = estbFacade;
    }

    public CEstadoProcFacadeLocal getEstpFacade() {
        return estpFacade;
    }

    public void setEstpFacade(CEstadoProcFacadeLocal estpFacade) {
        this.estpFacade = estpFacade;
    }

    public CFormasAdqFacadeLocal getFormadFacade() {
        return formadFacade;
    }

    public void setFormadFacade(CFormasAdqFacadeLocal formadFacade) {
        this.formadFacade = formadFacade;
    }

    public CFuentesFinFacadeLocal getFtefFacade() {
        return ftefFacade;
    }

    public void setFtefFacade(CFuentesFinFacadeLocal ftefFacade) {
        this.ftefFacade = ftefFacade;
    }

    public CProveedoresFacadeLocal getProvFacade() {
        return provFacade;
    }

    public void setProvFacade(CProveedoresFacadeLocal provFacade) {
        this.provFacade = provFacade;
    }

    public CProyectosFacadeLocal getProyFacade() {
        return proyFacade;
    }

    public void setProyFacade(CProyectosFacadeLocal proyFacade) {
        this.proyFacade = proyFacade;
    }

    public CTipDocFacadeLocal getTipdFacade() {
        return tipdFacade;
    }

    public void setTipdFacade(CTipDocFacadeLocal tipdFacade) {
        this.tipdFacade = tipdFacade;
    }

    public CTipDescargFacadeLocal getTdescarFacade() {
        return tdescarFacade;
    }

    public void setTdescarFacade(CTipDescargFacadeLocal tdescarFacade) {
        this.tdescarFacade = tdescarFacade;
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

    public String getRegBien() {
        return regBien;
    }

    public void setRegBien(String regBien) {
        this.regBien = regBien;
    }

    public Object[] getIngre() {
        return ingre;
    }

    public void setIngre(String[] ingre) {
        this.ingre = ingre;
    }

    public TBienes getBienIngLote() {
        return bienIngLote;
    }

    public void setBienIngLote(TBienes bienIngLote) {
        this.bienIngLote = bienIngLote;
    }

    public void nivDepSeleccion() {
//        nuevoBien.setCRespId(getDaoResp().getResp(respSeleccionado));
//        nivSeleccionado=nuevoBien.getCRespId().getCNivelId().getCNivelId();
//        depSeleccionada=nuevoBien.getCRespId().getCDepenId().getCDepenId();
//        nuevoBien.setCNivelId(getDaoNivel().getNivel(nivSeleccionado));
//        nuevoBien.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
    }

    public void depSeleccion() {
        nivSeleccionado = bienSeleccionado.getCNivelId().getCNivelId();
        depens = getDaoDepen().getListM(nivSeleccionado);
    }

    public void depSeleccionA() {
        nivSeleccionado = nuevoBien.getCNivelId().getCNivelId();
        depens = getDaoDepen().getListM(nivSeleccionado);
    }

    public void areaSeleccion() {
        edifSeleccionado = bienSeleccionado.getCEdifId().getCEdifId();
        areas = getDaoArea().getListM(edifSeleccionado);
    }

    public void areaSeleccionA() {
        edifSeleccionado = nuevoBien.getCEdifId().getCEdifId();
        areas = getDaoArea().getListM(edifSeleccionado);
    }

    public void ubicSeleccion() {
        areaSeleccionada = bienSeleccionado.getCAreaId().getCAreaId();
        ubics = getDaoUbic().getListA(areaSeleccionada);
    }

    public void ubicSeleccionA() {
        areaSeleccionada = nuevoBien.getCAreaId().getCAreaId();
        ubics = getDaoUbic().getListA(areaSeleccionada);
    }

    public void espSeleccion() {
        rubSeleccionado = bienSeleccionado.getCRubroId().getCRubroId();
        especs = getDaoEspec().getListM(rubSeleccionado);
    }

    public void espSeleccionA() {
        rubSeleccionado = nuevoBien.getCRubroId().getCRubroId();
        especs = getDaoEspec().getListM(rubSeleccionado);
    }

    public void asignarEdifArea() {
//        areas = getDaoArea().getListM(edifSeleccionado);
    }

    public void asignarNivDep() {
        nuevoBien.setCRespId(getDaoResp().getResp(respSeleccionado));
        nivSeleccionado = nuevoBien.getCRespId().getCNivelId().getCNivelId();
        depSeleccionada = nuevoBien.getCRespId().getCDepenId().getCDepenId();
    }

    public void buscarCod() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoBien.getTBienCodigo();
        resul = getDaoBienes().busCod(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }

    public void buscarCodI() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoArch.getTArchCodref();
        resul = getDaoBienes().busCod(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código no Existe....no puede adicionar imagen"));
            estadoI = true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok."));
            estadoI = false;
        }
    }

    public void buscarCodIn() throws NamingException {
        int resul = 0;
//        String cod;
        cod = bienIngLote.getTBienCodigo();
//        bienIngLote=getDaoBienes().busCod(cod);
        System.out.println("código: " + cod);
        resul = getDaoBienes().busCod(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código no Existe....no puede ingresar por lote"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok.Datos encontrados"));
            datosIn = getDaoBienes().datosI(cod);
            System.out.println("lista generada:");
        }

    }

    public List generarI() throws NamingException {
        cod = bienIngLote.getTBienCodigo();
        datosIn = getDaoBienes().datosI(cod);
        int cant;
        cant = bienIngLote.getTBienCantxlote();
        // agregando cantidad total a la lista
//        System.out.println(datosIn + " :datos: ");
        for (int i = 0; i < cant; i++) {
            bienesIn.add(datosIn.get(0));
  //          System.out.println("dat " + i + " " + bienesIn.get(i));
        }
//        System.out.println("total generados: " + bienesIn.size());

        return bienesIn;
    }

    public List generarI2() throws NamingException {
        Integer iniCorr = bienIngLote.getCEspecId().getCEspecCorr();
        cod = bienIngLote.getTBienCodigo();
        int cant;
        cant = bienIngLote.getTBienCantxlote();
//        System.out.println("cod sel: " + cod);
        String prefC = cod.substring(0, 8);
        String nvoCod = "";
        List copiaIn = new ArrayList<>();
        for (int i = 0; i < cant; i++) {
            // Determinando código
            iniCorr = iniCorr + 1;
            String nvoCorr = Integer.toString(iniCorr);
            if (iniCorr < 10) {
                nvoCod = (prefC + "000" + nvoCorr);
            }
            if (iniCorr > 9 && iniCorr < 100) {
                nvoCod = (prefC + "00" + nvoCorr);
            }
            if (iniCorr > 99 && iniCorr < 1000) {
                nvoCod = (prefC + "0" + nvoCorr);
            } else {
                if (iniCorr >= 1000) {
                    nvoCod = (prefC + nvoCorr);
                }
            }
//          Estableciendo codigo inicial y final
            if (i == 0) {
                bienIngLote.setTBienCodinilot(nvoCod);
            }
            if (i == cant - 1) {
                bienIngLote.setTBienCodfinlot(nvoCod);
            }

            ingre = (Object[]) bienesIn.get(i);
            ingre[15]=nvoCod;
  //          System.out.println(ingre[15]+" cod act.");
  //        pasando dato a copia de la lista
            copiaIn.add(ingre.clone());
        }
//        limpiando bienesIn (lista que es mostrada en pantalla)
        bienesIn.clear();
//      pasando datos de copia a lista original
         for (int k = 0; k < cant; k++) {
             bienesIn.add(copiaIn.get(k));
 //            System.out.println("nuevo In"+bienesIn.get(k));
         }
         
//        System.out.println("total actualizados: " + bienesIn.size());
//        System.out.println("códigos determinados");
        return bienesIn;

    }

    public void guardarI() {

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
            docums = getDaoArchiv().getList();

        } catch (IOException e) {
            System.out.println(e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No puede cargarse archivo"));

        }

    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String picture_directory = ctx.getExternalContext().getInitParameter("pictures_directory_path");
        //If directory exists ? do nothing : make directory
        File storage_folder = new File(picture_directory + nuevoBien.getTBienCodigo());
    }

}
