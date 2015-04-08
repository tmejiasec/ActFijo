/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TDescargDeta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TDescargDetaFacadeLocal {

    void create(TDescargDeta tDescargDeta);

    void edit(TDescargDeta tDescargDeta);

    void remove(TDescargDeta tDescargDeta);

    TDescargDeta find(Object id);

    List<TDescargDeta> findAll();

    List<TDescargDeta> findRange(int[] range);

    int count();
    
}
