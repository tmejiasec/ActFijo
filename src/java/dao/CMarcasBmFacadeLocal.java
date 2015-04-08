/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CMarcasBm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CMarcasBmFacadeLocal {

    void create(CMarcasBm cMarcasBm);

    void edit(CMarcasBm cMarcasBm);

    void remove(CMarcasBm cMarcasBm);

    CMarcasBm find(Object id);

    public List getList();
       
    public List busqueda(String desc);
   
    public CMarcasBm getMarca(Integer marca);
 
    List<CMarcasBm> findAll();

    List<CMarcasBm> findRange(int[] range);

    int count();
    
}
