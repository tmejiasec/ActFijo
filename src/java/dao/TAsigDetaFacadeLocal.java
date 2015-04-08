/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TAsigDeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TAsigDetaFacadeLocal {

    void create(TAsigDeta tAsigDeta);

    void edit(TAsigDeta tAsigDeta);

    void remove(TAsigDeta tAsigDeta);

    TAsigDeta find(Object id);

    List<TAsigDeta> findAll();

    List<TAsigDeta> findRange(int[] range);

    int count();
    
}
