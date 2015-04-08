/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TPrest;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TPrestFacadeLocal {

    void create(TPrest tPrest);

    void edit(TPrest tPrest);

    void remove(TPrest tPrest);

    TPrest find(Object id);

    List<TPrest> findAll();

    List<TPrest> findRange(int[] range);

    int count();
    
}
