/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import dao.CTipDescargFacadeLocal;
import entidades.CTipDescarg;
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
@Named(value = "tdescargConverter")
@ManagedBean
@ViewScoped
public class TdescargConverter implements Converter {
    
 public TdescargConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                CTipDescarg tdesca = getDaoTdesca().find(id);
                return tdesca;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un registro válido"));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CTipDescarg)) {
            return null;
        }
        return String.valueOf(((CTipDescarg) value).getCTipdescId());
    }
     private CTipDescargFacadeLocal getDaoTdesca() {
        return (CTipDescargFacadeLocal) FacesUtil.getEjb("java:global/ActFijo/CTipDescargFacade!dao.CTipDescargFacadeLocal");
    }
    
}
