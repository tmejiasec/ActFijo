/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CCondBienFacadeLocal;
import entidades.CCondBien;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import util.FacesUtil;
/**
 *
 * @author Teo de Renderos
 */
@Named(value = "condbConverter")
@ManagedBean
@ViewScoped
public class CondbConverter implements Converter {
    
 public CondbConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CCondBien condb = getDaoCondb().find(id);
                return condb;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CCondBien)) {
            return null;
        }
        return String.valueOf(((CCondBien) value).getCCondbId());
    }
     private CCondBienFacadeLocal getDaoCondb() {
        return (CCondBienFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CCondBienFacade!dao.CCondBienFacadeLocal");
    }
    
}
