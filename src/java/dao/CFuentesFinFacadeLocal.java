/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CFuentesFin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CFuentesFinFacadeLocal {

    void create(CFuentesFin cFuentesFin);

    void edit(CFuentesFin cFuentesFin);

    void remove(CFuentesFin cFuentesFin);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CFuentesFin getFuentef(Integer fuente);

    CFuentesFin find(Object id);

    List<CFuentesFin> findAll();

    List<CFuentesFin> findRange(int[] range);

    int count();
    
}
