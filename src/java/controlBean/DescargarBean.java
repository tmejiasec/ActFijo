/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author Teo de Renderos
 */
@ManagedBean
@ViewScoped
public class DescargarBean {

    /**
     * Creates a new instance of DescargarBean
     */
    private DefaultStreamedContent download;

    public DescargarBean() {
    }
    
    public void setDownload(DefaultStreamedContent download) {
    this.download = download;
}

public DefaultStreamedContent getDownload() throws Exception {
    return download;
}

public void prepDownload(String date) throws Exception {
    System.out.println("ruta: "+date);
  File file = new File(date);
  InputStream input = new FileInputStream(file);
  ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
  setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
}    
    
}
