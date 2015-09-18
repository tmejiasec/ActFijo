/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRecepDeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TRecepDetaFacadeLocal {

    void create(TRecepDeta tRecepDeta);

    void edit(TRecepDeta tRecepDeta);

    void remove(TRecepDeta tRecepDeta);

    TRecepDeta find(Object id);

    List<TRecepDeta> findAll();

    List<TRecepDeta> findRange(int[] range);
    
    public List<TRecepDeta> getListDet(Integer move);
    
    public List getList();

    int count();
    
}
