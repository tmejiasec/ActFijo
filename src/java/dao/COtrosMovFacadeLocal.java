/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.COtrosMov;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface COtrosMovFacadeLocal {

    void create(COtrosMov cOtrosMov);

    void edit(COtrosMov cOtrosMov);

    void remove(COtrosMov cOtrosMov);

    COtrosMov find(Object id);

    List<COtrosMov> findAll();

    List<COtrosMov> findRange(int[] range);

    int count();
    
}
