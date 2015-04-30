/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TArchivos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TArchivosFacadeLocal {

    void create(TArchivos tArchivos);

    void edit(TArchivos tArchivos);

    void remove(TArchivos tArchivos);
    
    public List getList();
       
    public List<TArchivos> getListM(String codbien);
    
    public List<TArchivos> getListT(String tipar);
    
    public TArchivos getArch(Integer arch);

    public List busqueda(String desc);
    
    TArchivos find(Object id);

    List<TArchivos> findAll();

    List<TArchivos> findRange(int[] range);

    int count();
    
}
