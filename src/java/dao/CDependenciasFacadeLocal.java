/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CDependencias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CDependenciasFacadeLocal {

    void create(CDependencias cDependencias);

    void edit(CDependencias cDependencias);

    void remove(CDependencias cDependencias);
    
    public List getList();
   
    public List<CDependencias> getListM(Integer nivel);

    public List busqueda(String desc);
    
    public CDependencias getDepend(Integer dep);


    CDependencias find(Object id);

    List<CDependencias> findAll();

    List<CDependencias> findRange(int[] range);

    int count();
    
}
