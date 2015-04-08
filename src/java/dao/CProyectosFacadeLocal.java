/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CProyectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CProyectosFacadeLocal {

    void create(CProyectos cProyectos);

    void edit(CProyectos cProyectos);

    void remove(CProyectos cProyectos);

    public List getList();
       
    public List busqueda(String desc);
   
    public CProyectos getProy(Integer proy);

    CProyectos find(Object id);

    List<CProyectos> findAll();

    List<CProyectos> findRange(int[] range);

    int count();
    
}
