/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TTiempo;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TTiempoFacadeLocal {

    void create(TTiempo tTiempo);

    void edit(TTiempo tTiempo);

    void remove(TTiempo tTiempo);

    TTiempo find(Object id);

    List<TTiempo> findAll();

    List<TTiempo> findRange(int[] range);

    int count();
    
    public TTiempo getFecha(Date fech);
	
    public TTiempo getTm(Integer tm);
    
    public List getList();
	
}
