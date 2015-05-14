
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;


import dao.CRubrosFacadeLocal;
import entidades.CRubros;
import dao.CEspecificosFacadeLocal;
import entidades.CEspecificos;
import dao.CEstadoBienFacadeLocal;
import entidades.CEstadoBien;
import dao.CCondBienFacadeLocal;
import dao.CEstadoMovFacadeLocal;
import entidades.CCondBien;
import dao.CEstadoProcFacadeLocal;
import entidades.CEstadoProc;
import dao.CTiposMovFacadeLocal;
import entidades.CTiposMov;
import dao.CTipDescargFacadeLocal;
import entidades.CEstadoMov;
import entidades.CTipDescarg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
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
public class CatbmBean implements Serializable {
    protected Integer tabIndex = 1;
    private List<CRubros> rubros = new ArrayList<>();
    private CRubros rubro;
    private CRubros nuevoRubro = new CRubros();
    private CRubros rubroSeleccionado = new CRubros();
    private List<CEspecificos> especs = new ArrayList<>();
    private CEspecificos espec;
    private Integer rubSeleccionado;
    private CEspecificos nuevoEspec = new CEspecificos();
    private CEspecificos especSeleccionado = new CEspecificos();
    private List<CEstadoBien> estbiens = new ArrayList<>();
    private CEstadoBien estbien;
    protected Boolean edit = false;
    protected Boolean estado = false;
    protected Boolean estadoE = false;
    private String desc;	
    private CEstadoBien nuevoEstbien = new CEstadoBien();
    private CEstadoBien estBienSeleccionado = new CEstadoBien();
    private List<CCondBien> conbiens = new ArrayList<>();
    private CCondBien conbien;
    private CCondBien nuevoConbien = new CCondBien();
    private CCondBien conBienSeleccionado = new CCondBien();
    private List<CEstadoProc> estprocs = new ArrayList<>();
    private CEstadoProc estproc;
    private CEstadoProc nuevoEstproc = new CEstadoProc();
    private CEstadoProc estProcSeleccionado = new CEstadoProc();
    private List<CTiposMov> tipmovs = new ArrayList<>();
    private CTiposMov tipmov;
    private CTiposMov nuevoTipmov = new CTiposMov();
    private CTiposMov tipMovSeleccionado = new CTiposMov();
    private List<CTipDescarg> tipdes = new ArrayList<>();
    private CTipDescarg tipde;
    private CTipDescarg nuevoTipdes = new CTipDescarg();
    private CTipDescarg tipDesSeleccionado = new CTipDescarg();
    private List<CEstadoMov> estmovs = new ArrayList<>();
    private CEstadoMov estmov;
    private CEstadoMov nuevoEstmov = new CEstadoMov();
    private CEstadoMov estMovSeleccionado = new CEstadoMov();

    /**
     * Creates a new instance 
     */
    public CatbmBean() {
        rubros = getDaoRubro().getList();
        especs = getDaoEspec().getList();
	estbiens  =  getDaoEstBien().getList();
        conbiens = getDaoConBien().getList();
        estprocs = getDaoEstProc().getList();
        tipmovs = getDaoTipMov().getList();
        tipdes = getDaoTipDesc().getList();
        estmovs = getDaoEstMov().getList();
                
    }
    
        public String guardarRb() throws NamingException {
        getDaoRubro().create(nuevoRubro);
        FacesUtil.addMensaje("Rubro Guardado");
        nuevoRubro = new CRubros();
        rubros  =  getDaoRubro().getList();
        return null;
    }

    public String actualRb() throws NamingException {
        getDaoRubro().edit(rubroSeleccionado);
        FacesUtil.addMensaje("Rubro Actualizado");
        return null;
    }

    public String borrarRb() throws NamingException {
        return null;
    }


    public String limpiarRb() {
        rubro = new CRubros();
        return null;
    }

    public String guardarEs() throws NamingException {
        nuevoEspec.setCRubroId(getDaoRubro().getRubro(rubSeleccionado));
        getDaoEspec().create(nuevoEspec);
        FacesUtil.addMensaje("Específico Guardado");
        nuevoEspec = new CEspecificos();
        especs  =  getDaoEspec().getList();
        return null;
    }

    public String actualEs() throws NamingException {
        especSeleccionado.setCRubroId(getDaoRubro().getRubro(rubSeleccionado));
        getDaoEspec().edit(especSeleccionado);
        FacesUtil.addMensaje("Específico Actualizado");
        return null;
    }

    public String borrarEs() throws NamingException {
        return null;
    }


    public String limpiarEs() {
        espec = new CEspecificos();
        return null;
    }

    
    
    public String buscarEb() throws NamingException {

        estbiens = getDaoEstBien().busqueda(desc);

        return null;
    }

    public String guardarEb() throws NamingException {
        getDaoEstBien().create(nuevoEstbien);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoEstbien = new CEstadoBien();
        estbiens  =  getDaoEstBien().getList();
        return null;
    }

    public String actualEb() throws NamingException {
        getDaoEstBien().edit(estBienSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarEb() throws NamingException {
//        Integer resultado = getDaoNivel().remove(nivelSeleccionado);
//        if (resultado == -1) {
//            FacesUtil.addMensaje("Nivel tiene movimientos");
//        } else {
//            FacesUtil.addMensaje("Nivel Borrado");
//            niveles.remove(nivelSeleccionado);
//            nivel = new CNiveles();
//        }
        return null;
    }


    public String limpiarEb() {
        estbien = new CEstadoBien();
        return null;
    }

    public String guardarCb() throws NamingException {
        getDaoConBien().create(nuevoConbien);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoConbien = new CCondBien();
        conbiens  =  getDaoConBien().getList();
        return null;
    }

    public String actualCb() throws NamingException {
        getDaoConBien().edit(conBienSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String limpiarCb() {
        conbien = new CCondBien();
        return null;
    }
    
    public String borrarCb() throws NamingException {
        return null;
    }



    public String guardarEp() throws NamingException {
        getDaoEstProc().create(nuevoEstproc);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoEstproc = new CEstadoProc();
        estprocs  =  getDaoEstProc().getList();
        return null;
    }

    public String actualEp() throws NamingException {
        getDaoEstProc().edit(estProcSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String limpiarEp() {
        estproc = new CEstadoProc();
        return null;
    }
    
    public String borrarEp() throws NamingException {
        return null;
    }

    
    public String guardarTm() throws NamingException {
        getDaoTipMov().create(nuevoTipmov);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoTipmov = new CTiposMov();
        tipmovs  =  getDaoTipMov().getList();
        return null;
    }

    public String actualTm() throws NamingException {
        getDaoTipMov().edit(tipMovSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String limpiarTm() {
        tipmov = new CTiposMov();
        return null;
    }
    
    public String borrarTm() throws NamingException {
        return null;
    }
    
     public String guardarEm() throws NamingException {
        getDaoEstMov().create(nuevoEstmov);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoEstmov = new CEstadoMov();
        estmovs  =  getDaoEstMov().getList();
        return null;
    }

    public String actualEm() throws NamingException {
        getDaoEstMov().edit(estMovSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String limpiarEm() {
        estmov = new CEstadoMov();
        return null;
    }
    
    public String borrarEm() throws NamingException {
        return null;
    }
   
    
    public String guardarTd() throws NamingException {
        getDaoTipDesc().create(nuevoTipdes);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoTipdes = new CTipDescarg();
        tipdes  =  getDaoTipDesc().getList();
        return null;
    }

    public String actualTd() throws NamingException {
        getDaoTipDesc().edit(tipDesSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String limpiarTd() {
        tipde = new CTipDescarg();
        return null;
    }

    public String borrarTd() throws NamingException {
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
   
    private CTiposMovFacadeLocal getDaoTipMov() {
        return (CTiposMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTiposMovFacade!dao.CTiposMovFacadeLocal");
    }
   
    private CEstadoMovFacadeLocal getDaoEstMov() {
        return (CEstadoMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CEstadoMovFacade!dao.CEstadoMovFacadeLocal");
    }
   
    private CTipDescargFacadeLocal getDaoTipDesc() {
        return (CTipDescargFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTipDescargFacade!dao.CTipDescargFacadeLocal");
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

    public List<CRubros> getRubros() {
        return rubros;
    }

    public void setRubros(List<CRubros> rubros) {
        this.rubros = rubros;
    }

    public CRubros getRubro() {
        return rubro;
    }

    public void setRubro(CRubros rubro) {
        this.rubro = rubro;
    }

    public CRubros getNuevoRubro() {
        return nuevoRubro;
    }

    public void setNuevoRubro(CRubros nuevoRubro) {
        this.nuevoRubro = nuevoRubro;
    }

    public CRubros getRubroSeleccionado() {
        return rubroSeleccionado;
    }

    public void setRubroSeleccionado(CRubros rubroSeleccionado) {
        this.rubroSeleccionado = rubroSeleccionado;
    }

    public List<CEspecificos> getEspecs() {
        return especs;
    }

    public void setEspecs(List<CEspecificos> especs) {
        this.especs = especs;
    }

    public CEspecificos getEspec() {
        return espec;
    }

    public void setEspec(CEspecificos espec) {
        this.espec = espec;
    }

    public Integer getRubSeleccionado() {
        return rubSeleccionado;
    }

    public void setRubSeleccionado(Integer rubSeleccionado) {
        this.rubSeleccionado = rubSeleccionado;
    }

    public CEspecificos getNuevoEspec() {
        return nuevoEspec;
    }

    public void setNuevoEspec(CEspecificos nuevoEspec) {
        this.nuevoEspec = nuevoEspec;
    }

    public CEspecificos getEspecSeleccionado() {
        return especSeleccionado;
    }

    public void setEspecSeleccionado(CEspecificos especSeleccionado) {
        this.especSeleccionado = especSeleccionado;
    }

    public List<CEstadoBien> getEstbiens() {
        return estbiens;
    }

    public void setEstbiens(List<CEstadoBien> estbiens) {
        this.estbiens = estbiens;
    }

    public CEstadoBien getEstbien() {
        return estbien;
    }

    public void setEstbien(CEstadoBien estbien) {
        this.estbien = estbien;
    }

    public CEstadoBien getNuevoEstbien() {
        return nuevoEstbien;
    }

    public void setNuevoEstbien(CEstadoBien nuevoEstbien) {
        this.nuevoEstbien = nuevoEstbien;
    }

    public CEstadoBien getEstBienSeleccionado() {
        return estBienSeleccionado;
    }

    public void setEstBienSeleccionado(CEstadoBien estBienSeleccionado) {
        this.estBienSeleccionado = estBienSeleccionado;
    }

    public List<CCondBien> getConbiens() {
        return conbiens;
    }

    public void setConbiens(List<CCondBien> conbiens) {
        this.conbiens = conbiens;
    }

    public CCondBien getConbien() {
        return conbien;
    }

    public void setConbien(CCondBien conbien) {
        this.conbien = conbien;
    }

    public CCondBien getNuevoConbien() {
        return nuevoConbien;
    }

    public void setNuevoConbien(CCondBien nuevoConbien) {
        this.nuevoConbien = nuevoConbien;
    }

    public CCondBien getConBienSeleccionado() {
        return conBienSeleccionado;
    }

    public void setConBienSeleccionado(CCondBien conBienSeleccionado) {
        this.conBienSeleccionado = conBienSeleccionado;
    }

    public List<CEstadoProc> getEstprocs() {
        return estprocs;
    }

    public void setEstprocs(List<CEstadoProc> estprocs) {
        this.estprocs = estprocs;
    }

    public CEstadoProc getEstproc() {
        return estproc;
    }

    public void setEstproc(CEstadoProc estproc) {
        this.estproc = estproc;
    }

    public CEstadoProc getNuevoEstproc() {
        return nuevoEstproc;
    }

    public void setNuevoEstproc(CEstadoProc nuevoEstproc) {
        this.nuevoEstproc = nuevoEstproc;
    }

    public CEstadoProc getEstProcSeleccionado() {
        return estProcSeleccionado;
    }

    public void setEstProcSeleccionado(CEstadoProc estProcSeleccionado) {
        this.estProcSeleccionado = estProcSeleccionado;
    }

    public List<CTiposMov> getTipmovs() {
        return tipmovs;
    }

    public void setTipmovs(List<CTiposMov> tipmovs) {
        this.tipmovs = tipmovs;
    }

    public CTiposMov getTipmov() {
        return tipmov;
    }

    public void setTipmov(CTiposMov tipmov) {
        this.tipmov = tipmov;
    }

    public CTiposMov getNuevoTipmov() {
        return nuevoTipmov;
    }

    public void setNuevoTipmov(CTiposMov nuevoTipmov) {
        this.nuevoTipmov = nuevoTipmov;
    }

    public CTiposMov getTipMovSeleccionado() {
        return tipMovSeleccionado;
    }

    public void setTipMovSeleccionado(CTiposMov tipMovSeleccionado) {
        this.tipMovSeleccionado = tipMovSeleccionado;
    }

    public List<CTipDescarg> getTipdes() {
        return tipdes;
    }

    public void setTipdes(List<CTipDescarg> tipdes) {
        this.tipdes = tipdes;
    }

    public CTipDescarg getTipde() {
        return tipde;
    }

    public void setTipde(CTipDescarg tipde) {
        this.tipde = tipde;
    }

    public CTipDescarg getNuevoTipdes() {
        return nuevoTipdes;
    }

    public void setNuevoTipdes(CTipDescarg nuevoTipdes) {
        this.nuevoTipdes = nuevoTipdes;
    }

    public CTipDescarg getTipDesSeleccionado() {
        return tipDesSeleccionado;
    }

    public void setTipDesSeleccionado(CTipDescarg tipDesSeleccionado) {
        this.tipDesSeleccionado = tipDesSeleccionado;
    }

    public List<CEstadoMov> getEstmovs() {
        return estmovs;
    }

    public void setEstmovs(List<CEstadoMov> estmovs) {
        this.estmovs = estmovs;
    }

    public CEstadoMov getEstmov() {
        return estmov;
    }

    public void setEstmov(CEstadoMov estmov) {
        this.estmov = estmov;
    }

    public CEstadoMov getNuevoEstmov() {
        return nuevoEstmov;
    }

    public void setNuevoEstmov(CEstadoMov nuevoEstmov) {
        this.nuevoEstmov = nuevoEstmov;
    }

    public CEstadoMov getEstMovSeleccionado() {
        return estMovSeleccionado;
    }

    public void setEstMovSeleccionado(CEstadoMov estMovSeleccionado) {
        this.estMovSeleccionado = estMovSeleccionado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstadoE() {
        return estadoE;
    }

    public void setEstadoE(Boolean estadoE) {
        this.estadoE = estadoE;
    }

    
    
    public void asignarRubro(){
        rubSeleccionado=especSeleccionado.getCRubroId().getCRubroId();
    }    
    
    public void buscarCodR() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoRubro.getCRubroCodigo();
        resul = getDaoRubro().busCodR(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }    
    
        public void buscarCodE() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoEspec.getCEspecCodigo();
        resul = getDaoEspec().busCodE(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estadoE = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estadoE = true;
        }
    }        
 
    
}

