/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TSegMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TSegMovFacadeLocal {

    void create(TSegMov tSegMov);

    void edit(TSegMov tSegMov);

    void remove(TSegMov tSegMov);
    
    public List getList();
       
    public TSegMov getSegM(Integer segm);

    public List<TSegMov> getListM(Integer move);

    TSegMov find(Object id);

    List<TSegMov> findAll();

    List<TSegMov> findRange(int[] range);

    int count();
    
}
