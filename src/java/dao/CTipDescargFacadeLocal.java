/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CTipDescarg;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CTipDescargFacadeLocal {

    void create(CTipDescarg cTipDescarg);

    void edit(CTipDescarg cTipDescarg);

    void remove(CTipDescarg cTipDescarg);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CTipDescarg getTipd(Integer tipdes);
 
    CTipDescarg find(Object id);

    List<CTipDescarg> findAll();

    List<CTipDescarg> findRange(int[] range);

    int count();
    
}
