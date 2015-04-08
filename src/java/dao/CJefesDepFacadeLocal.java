/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CJefesDep;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CJefesDepFacadeLocal {

    void create(CJefesDep cJefesDep);

    void edit(CJefesDep cJefesDep);

    void remove(CJefesDep cJefesDep);
    
    public List getList();
   
    public List busqueda(String nombre);
    
    public CJefesDep getJefeDep(Integer jef);
    

    CJefesDep find(Object id);

    List<CJefesDep> findAll();

    List<CJefesDep> findRange(int[] range);

    int count();
    
}
