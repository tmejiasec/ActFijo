/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TMovimEnca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TMovimEncaFacadeLocal {

    void create(TMovimEnca tMovimEnca);

    void edit(TMovimEnca tMovimEnca);

    void remove(TMovimEnca tMovimEnca);

    TMovimEnca find(Object id);

    List<TMovimEnca> findAll();

    List<TMovimEnca> findRange(int[] range);

    int count();
    
    public List getList();
       
    public List<TMovimEnca> getListM(Short correl, Short anio);
    
    public TMovimEnca getMove(Integer move);

    
}
