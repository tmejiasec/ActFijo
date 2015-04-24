package controlBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.CUsuarios;

@ManagedBean
@SessionScoped
public class AppSession implements Serializable {
	
	
private CUsuarios usuarioLogeado;

public CUsuarios getUsuario() {
	return usuarioLogeado;
}

public void setUsuario(CUsuarios usuario) {
	this.usuarioLogeado = usuario;
}

}
