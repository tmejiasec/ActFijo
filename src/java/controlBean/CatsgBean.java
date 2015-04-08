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
public class CatsgBean implements Serializable {
    protected Integer tabIndex = 1;
    protected Boolean edit = false;
    private String desc;	
   
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
    /**
    /**
    /**
    /**
     * Creates a new instance 
     */
    public CatsgBean() {
	roles  =  getDaoRol().getList();
        usuarios  =  getDaoUsuario().getList();
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
        roles  =  getDaoRol().getList();
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
        rol= new CRoles();
        return null;
    }

    public String guardarUs() throws NamingException {
        nuevoUsuario.setCRolId(getDaoRol().getRol(roleSeleccionado));
        nuevoUsuario.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
        getDaoUsuario().create(nuevoUsuario);
        FacesUtil.addMensaje("Dato Guardado");
        nuevoUsuario = new CUsuarios();
        usuarios  =  getDaoUsuario().getList();
        return null;
    }

    public String actualUs() throws NamingException {
        usuarioSeleccionado.setCRolId(getDaoRol().getRol(roleSeleccionado));
        usuarioSeleccionado.setCDepenId(getDaoDepen().getDepend(depSeleccionada));
        getDaoUsuario().edit(usuarioSeleccionado);
        FacesUtil.addMensaje("Dato Actualizado");
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
    
    public void asignarRolDep(){
        roleSeleccionado=usuarioSeleccionado.getCRolId().getCRolId();
        depSeleccionada=usuarioSeleccionado.getCDepenId().getCDepenId();
    }
    
    
}

