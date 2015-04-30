/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CTiposMovFacadeLocal;
import entidades.CTiposMov;
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
@Named(value = "tiposMovConverter")
@ManagedBean
@ViewScoped
public class TiposMovConverter implements Converter {
    
 public TiposMovConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione una...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CTiposMov tiposm = getDaoTiposM().find(id);
                return tiposm;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CTiposMov)) {
            return null;
        }
        return String.valueOf(((CTiposMov) value).getCTipmId());
    }
     private CTiposMovFacadeLocal getDaoTiposM() {
        return (CTiposMovFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTiposMovFacade!dao.CTiposMovFacadeLocal");
    }
    
}
