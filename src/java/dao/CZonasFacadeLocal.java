/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CZonas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CZonasFacadeLocal {

    void create(CZonas cZonas);

    void edit(CZonas cZonas);

    void remove(CZonas cZonas);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CZonas getZona(Integer zona);
 
    CZonas find(Object id);

    List<CZonas> findAll();

    List<CZonas> findRange(int[] range);

    int count();
    
}
