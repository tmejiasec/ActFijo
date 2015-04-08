/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CNiveles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CNivelesFacadeLocal {

    void create(CNiveles cNiveles);

    void edit(CNiveles cNiveles);

    void remove(CNiveles cNiveles);
    
    public List getList();
       
    public List busqueda(String desc);
    
    public CNiveles getNivel(Integer niv);

    CNiveles find(Object id);

    List<CNiveles> findAll();

    List<CNiveles> findRange(int[] range);

    int count();
    
}
