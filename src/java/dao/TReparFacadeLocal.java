/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRepar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TReparFacadeLocal {

    void create(TRepar tRepar);

    void edit(TRepar tRepar);

    void remove(TRepar tRepar);

    TRepar find(Object id);

    List<TRepar> findAll();

    List<TRepar> findRange(int[] range);

    int count();
    
}
