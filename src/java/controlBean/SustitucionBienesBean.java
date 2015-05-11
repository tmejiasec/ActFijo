/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;


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
import dao.CEstadoBienFacade;
import dao.CEstadoBienFacadeLocal;
import entidades.TArchivos;
import dao.TArchivosFacade;
import dao.TArchivosFacadeLocal;
import dao.TTiempoFacadeLocal;

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
 * @author Portillo
 */
@ManagedBean
@RequestScoped
public class SustitucionBienesBean implements Serializable {

    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    private String desc;
    private List<TSustit> sutit = new ArrayList<>();
    private TSustit sustituc;
    private TSustit nuevaSustit = new TSustit();
    private List<CResponsables> respon = new ArrayList<>(); 
    private List<CEspecificos> espec = new ArrayList<>(); 
    private List<CRubros> rub = new ArrayList<>();
    private List<CDependencias> depen = new ArrayList<>();
    private List<CEstadoBien> estad = new ArrayList<>();
    private List<TBienes> bien = new ArrayList<>();
    private List<TArchivos> docums = new ArrayList<>();
    private TArchivos archSeleccionado = new TArchivos();
    private TArchivos nuevoArch = new TArchivos();
    private TBienes codSeleccionado = new TBienes();
    
    private Integer respoSeleccionado, especSeleccionada,rubSeleccionado, depenSeleccionado,sustitSeleccionada;
    private Integer estadSeleccionado, bienseleccionado, ducumseleccionado;
    private short marcaAnterior;
    private short tipoSustit;
    
    private TSustitFacadeLocal sutitu;
    private CResponsablesFacadeLocal responFacade;
    private CEspecificosFacadeLocal especFacade;
    private CRubrosFacadeLocal rubFacade;
    private CDependenciasFacadeLocal depenFacadeLocal;
    private CEstadoBienFacadeLocal estadFacade;
    private TBienesFacadeLocal bienFacade;
    private Date fech = new Date();
    private SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    
    
    
    private Boolean estado = false;
    private Boolean estadoI = false;
    private Boolean estadoIn = false;
    private Integer iniCorr = 0;
    private Integer especif;
    private String serieAnt;
    private Date fechres, fechdic, fechsut;
    
     
    private String nomResp, nomDep, regBien, especi;
    private String cod, modelo, serie;
    private Integer reparSelec, codSelec, marca;
    /**
     * Creates a new instance of SustitucionBienes  
     * Beanprivate FacadeLocal ;
     */
    public SustitucionBienesBean() {
        
        
        respon = getDaoResp().getList();
        depen = getDaoDepen().getList();
        rub = getDaoRubro().getList();
        espec = getDaoEspec().getList();
        estad = getDaoEstBien().getList();
        bien = getDaoBienes().getList();
        docums = getDaoArchiv().getList();
        
        
        
        
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
    
    private TSustitFacadeLocal getDaoSustit() {
        return (TSustitFacadeLocal)FacesUtil.getEjb("java:global/ActFijo/TSustitFacade!dao.TSustitFacadeLocal"); //To change body of generated methods, choose Tools | Templates.
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

     public List<TSustit> getSustituc() {
        return sutit;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TBienes getCodSeleccionado() {
        return codSeleccionado;
    }

    public void setCodSeleccionado(TBienes codSeleccionado) {
        this.codSeleccionado = codSeleccionado;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }
     
  
//    public String buscarSusti() throws NamingException {
//
//        sutit = getDaoSustit().busqueda(desc);
//
//        return null;
//    }
    
     public String borrarSustit() throws NamingException {
        return null;
    }
     
    public TSustit getNuevaSustit() {
        return nuevaSustit;
    }
    
    public void setNuevasustit(){
    
        this.nuevaSustit = nuevaSustit;
        
    }
    
    public TSustit getSustitSeleccionada() {
        return sustituc;
    }

    public void setSustitSeleccionada(TBienes bienSeleccionado) {
        this.sustituc = sustituc;
    }
    
    public String limpiarTSutit() {
        sustituc = new TSustit();
        return null;
    }
    
    public TBienes datosCodigo() throws NamingException {
        this.cod=cod;
        System.out.println("cod dig: "+cod);
//        cod = detaSeleccionado.getTMovdCodigo();
    	codSeleccionado = getDaoBienes().getCodBien(cod);
        System.out.println("despues de query"+codSeleccionado);
//        desc=codSeleccionado.getTBienDesc();
//	modelo =codSeleccionado.getTBienModelo();
//	marca=codSeleccionado.getCMarcaId().getCMarcaId();
//	serie=codSeleccionado.getTBienSerie();
        System.out.println("codsel: "+codSeleccionado);
	return codSeleccionado;
    }
    
   
    
    public String guardarSustit() throws NamingException, ParseException{
         Date fecha = new Date();
         fechres = nuevaSustit.getTSustFechres();
         fechdic = nuevaSustit.getTSustFechdict();
         
         if (fechres == null){
         }else {
         
             
             
         }
         
         
       
        
        return null;
    }
}
