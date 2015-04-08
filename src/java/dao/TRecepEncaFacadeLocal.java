/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TRecepEnca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TRecepEncaFacadeLocal {

    void create(TRecepEnca tRecepEnca);

    void edit(TRecepEnca tRecepEnca);

    void remove(TRecepEnca tRecepEnca);

    TRecepEnca find(Object id);

    List<TRecepEnca> findAll();

    List<TRecepEnca> findRange(int[] range);

    int count();
    
}
