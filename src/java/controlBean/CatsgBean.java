/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import dao.CDependenciasFacadeLocal;
import dao.CRolesFacadeLocal;
import dao.CUsuariosFacadeLocal;
import entidades.CDependencias;
import entidades.CRoles;
import entidades.CUsuarios;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class CatsgBean implements Serializable {

    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    private String desc;
    private Boolean estado = false;


    private List<CRoles> roles = new ArrayList<>();
    private CRoles rol;
    private CRoles nuevoRol = new CRoles();
    private CRoles rolSeleccionado = new CRoles();
    private List<CUsuarios> usuarios = new ArrayList<>();
    private CUsuarios usuario;
    private CUsuarios nuevoUsuario = new CUsuarios();
    private CUsuarios usuarioSeleccionado = new CUsuarios();
    private Integer roleSeleccionado;
    private List<CDependencias> depens = new ArrayList<>();
    private Integer depSeleccionada;
    private Date fech = new Date();
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    /**
     * /**
     * /**
     * /**
     * Creates a new instance
     */
    public CatsgBean() {
        roles = getDaoRol().getList();
        usuarios = getDaoUsuario().getList();
        depens = getDaoDepen().getList();
    }

    public String buscarRl() throws NamingException {

        roles = getDaoRol().busqueda(desc);
        return null;
    }

    public String guardarRl() throws NamingException {
        getDaoRol().create(nuevoRol);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoRol = new CRoles();
        roles = getDaoRol().getList();
        return null;
    }

    public String actualRl() throws NamingException {
        getDaoRol().edit(rolSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
        return null;
    }

    public String borrarRl() throws NamingException {
        return null;
    }

    public String limpiarRl() {
        rol = new CRoles();
        return null;
    }

    public String guardarUs() throws NamingException, ParseException {
        nuevoUsuario.setCRolId(getDaoRol().getRol(roleSeleccionado));
        nuevoUsuario.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
//        System.out.println("nom " + nuevoUsuario.getCUserNombre());
//        System.out.println("pass " + nuevoUsuario.getCUserPass());
//        System.out.println("log " + nuevoUsuario.getCUserLogin());
//        System.out.println("est " + nuevoUsuario.getCUserEstado());
//        System.out.println("rol " + nuevoUsuario.getCRolId());
//        System.out.println("dep " + nuevoUsuario.getCDepenId());
        nuevoUsuario.setCUserFeca(fech);
        nuevoUsuario.setCUserHora(formatoHora.parse(formatoHora.format(fech)));

        try {
            getDaoUsuario().create(nuevoUsuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario Agregado correctamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario NO se agregó"));

        }
//        FacesUtil.addMensaje("Dato Guardado");
        nuevoUsuario = new CUsuarios();
        usuarios = getDaoUsuario().getList();
        return null;
    }

    public String actualUs() throws NamingException, ParseException {
        System.out.println("entrando a actualizar");
        usuarioSeleccionado.setCRolId(getDaoRol().getRol(roleSeleccionado));
        usuarioSeleccionado.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
        usuarioSeleccionado.setCUserFecm(fech);
        usuarioSeleccionado.setCUserHorm(formatoHora.parse(formatoHora.format(fech)));
        try {
            getDaoUsuario().edit(usuarioSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario modificado correctamente"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario NO se modificó"));

        }
        usuarioSeleccionado = new CUsuarios();
        usuarios = getDaoUsuario().getList();
        return null;
    }

    public String borrarUs() throws NamingException {
        return null;
    }

    public String limpiarUs() {
        usuario = new CUsuarios();
        return null;
    }

    public String setEditAction() {
        edit = true;
        tabIndex = 0;

        return null;
    }

    private CRolesFacadeLocal getDaoRol() {
        return (CRolesFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CRolesFacade!dao.CRolesFacadeLocal");
    }

    private CUsuariosFacadeLocal getDaoUsuario() {
        return (CUsuariosFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CUsuariosFacade!dao.CUsuariosFacadeLocal");
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFech() {
        return fech;
    }

    public void setFech(Date fech) {
        this.fech = fech;
    }

    public List<CRoles> getRoles() {
        return roles;
    }

    public void setRoles(List<CRoles> roles) {
        this.roles = roles;
    }

    public CRoles getRol() {
        return rol;
    }

    public void setRol(CRoles rol) {
        this.rol = rol;
    }

    public CRoles getNuevoRol() {
        return nuevoRol;
    }

    public void setNuevoRol(CRoles nuevoRol) {
        this.nuevoRol = nuevoRol;
    }

    public CRoles getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(CRoles rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public List<CUsuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<CUsuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public CUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(CUsuarios usuario) {
        this.usuario = usuario;
    }

    public CUsuarios getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(CUsuarios nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public CUsuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(CUsuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public Integer getRoleSeleccionado() {
        return roleSeleccionado;
    }

    public void setRoleSeleccionado(Integer roleSeleccionado) {
        this.roleSeleccionado = roleSeleccionado;
    }

    public List<CDependencias> getDepens() {
        return depens;
    }

    public void setDepens(List<CDependencias> depens) {
        this.depens = depens;
    }

    public Integer getDepSeleccionada() {
        return depSeleccionada;
    }

    public void setDepSeleccionada(Integer depSeleccionada) {
        this.depSeleccionada = depSeleccionada;
    }

    public void asignarRolDep() {
        roleSeleccionado = usuarioSeleccionado.getCRolId().getCRolId();
        depSeleccionada = usuarioSeleccionado.getCDepenId().getCDepenId();
    }
    
      public Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;}
      
    public void buscarLogin() throws NamingException {
        int resul = 0;
        String cod;
        cod = nuevoUsuario.getCUserLogin();
        resul = getDaoUsuario().busLogin(cod);
        if (resul == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ok"));
            estado = false;
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Código ya existe. No puede adicionarlo: "));
            estado = true;
        }
    }
      

}
