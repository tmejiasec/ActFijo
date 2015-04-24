/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import java.io.Serializable;
import util.FacesUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import contex.AppContext;
import dao.CRolesFacadeLocal;
import dao.CUsuariosFacadeLocal;
import entidades.CRoles;
import entidades.CUsuarios;


@ManagedBean
@SessionScoped
//@ViewScoped
public class UsuarioBean implements Serializable {

    /**
     *
     */
    protected Integer tabIndex = 1;
    private static final long serialVersionUID = 1L;
    private String usuario;
    private String password;
    private List<CUsuarios> usuarios;
    private List<CRoles> lroles;
    private CUsuarios usuar;
    protected Boolean edit = false;
    private int rolSeleccionado;
    private CUsuarios nuevoUsuario = new CUsuarios();
    private CUsuarios usuarioSeleccionado = new CUsuarios();

    private String urlActual;
    private String usuarioSH;
    private List roles;

//	private List usuarios;
//    private Usuario usuarioE = new Usuario();
//    private AppSession appSession=new AppSession();
    @ManagedProperty(value = "#{appSession}")
    private AppSession appSession;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuar = new CUsuarios();
    }

    public String logiAction() {
        String accion = null;
        System.out.println("usuario: "+usuario);
        System.out.println("pass: "+password);
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(usuario, password);
            System.out.println("req "+request);
            Authentication result = getAuthenticationManager().authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            String rol = postLogin();
            if (rol != null) {
                if (rol.equals("TECNICO")) {
                    accion = "contenido/bm_registro.xhtml?faces-redirect=true";
                }
                else{
                    accion = "contenido/inicio.xhtml?faces-redirect=true";
                }
            }

        } catch (AuthenticationException e) {
            util.FacesUtil.addMensaje("Credenciales incorrectas. Verifique...");
            e.printStackTrace();
        }

        return accion;

    }

    private String postLogin() {

//      forma uno 
//     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//     name = auth.getName(); 
//     obtenemos el usuario logueado
        //   forma dos
        String rol = null;

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        String name = user.getUsername(); //obtenemos el usuario logueado    
        System.out.println("nomus "+name);

     //guardar el nombre de la session del usuario
        try {
            CUsuarios usuarioL = getDaoUsuario().traeUsuarioLogeado(name);
            System.out.println("new us "+usuarioL);
            appSession.setUsuario(usuarioL);
            System.out.println("nombre: "+usuarioL.getCUserNombre());
            System.out.println("nombre: "+name);
            System.out.println("nombre app: "+appSession.getUsuario().getCUserNombre());
//    appSession.setUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (appSession.getUsuario().getCUserId() != null) {
            rol = appSession.getUsuario().getCRolId().getCRolNombre();
     System.out.println("rol:"+rol);
//     System.out.println("rol app:"+appSession.getUsuario().getRol().getRolNombre());
        }
        usuarios = getDaoUsuario().getList();
        lroles = getDaoRol().getList();

        return rol;

    }

    public String limpiar() {
        usuar = new CUsuarios();
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
   

//    protected AuthenticationManager getAuthenticationManager() {
//        return (AuthenticationManager) FacesUtil.getSpringBean("authenticationManager");
//    }

    protected AuthenticationManager getAuthenticationManager() {
        return (AuthenticationManager) AppContext.getBeanSpring("authenticationManager");
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlActual
     */
    public String getUrlActual() {
        return urlActual;
    }

    /**
     * @param urlActual the urlActual to set
     */
    public void setUrlActual(String urlActual) {
        this.urlActual = urlActual;
    }

    /**
     * @return the usuarioSH
     */
    public String getUsuarioSH() {
        return usuarioSH;
    }

    /**
     * @param usuarioSH the usuarioSH to set
     */
    public void setUsuarioSH(String usuarioSH) {
        this.usuarioSH = usuarioSH;
    }

    /**
     * @return the roles
     */
    public List getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List roles) {
        this.roles = roles;
    }

   

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }

    

   

    public int getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(int rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public List<CUsuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<CUsuarios> usuarios) {
        this.usuarios = usuarios;
    }

    public List<CRoles> getLroles() {
        return lroles;
    }

    public void setLroles(List<CRoles> lroles) {
        this.lroles = lroles;
    }

    public CUsuarios getUsuar() {
        return usuar;
    }

    public void setUsuar(CUsuarios usuar) {
        this.usuar = usuar;
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

    
    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    public void asignarRol() {
        rolSeleccionado = usuarioSeleccionado.getCRolId().getCRolId();
    }

    @Override
    public String toString() {
        return "UsuarioBean [usuario=" + usuario + ", password=" + password
                + ", usuarios=" + usuarios + ", lroles=" + lroles + ", usuar="
                + usuar + ", edit=" + edit + ", rolSeleccionado="
                + rolSeleccionado + ", nuevoUsuario=" + nuevoUsuario
                + ", usuarioSeleccionado=" + usuarioSeleccionado
                + ", urlActual=" + urlActual + ", usuarioSH=" + usuarioSH
                + ", roles=" + roles + ", appSession=" + appSession + "]";
    }

}
