/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CAreas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CAreasFacadeLocal {

    void create(CAreas cAreas);

    void edit(CAreas cAreas);

    void remove(CAreas cAreas);
    
    public List getList();
    
    public List<CAreas> getListM(Integer edif);
    
    public List<CAreas> getListD(Integer dep);
   
    public List busqueda(String desc);
    
    public CAreas getArea(Integer area);
    
    CAreas find(Object id);

    List<CAreas> findAll();

    List<CAreas> findRange(int[] range);

    int count();
    
}
