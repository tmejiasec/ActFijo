/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTecnicosAf;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CTecnicosAfFacadeLocal {

    void create(CTecnicosAf cTecnicosAf);

    void edit(CTecnicosAf cTecnicosAf);

    void remove(CTecnicosAf cTecnicosAf);
    
    public List getList();
   
    public List busqueda(String nombre);
    
    public CTecnicosAf getTecAf(Integer tec);
    

    CTecnicosAf find(Object id);

    List<CTecnicosAf> findAll();

    List<CTecnicosAf> findRange(int[] range);

    int count();
    
}
