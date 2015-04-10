/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.TBienes;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface TBienesFacadeLocal {

    void create(TBienes tBienes);

    void edit(TBienes tBienes);

    void remove(TBienes tBienes);

    public List getList();
       
    public List<TBienes> getListM(Integer respo);
    
    public List<TBienes> getListL();
    
    public Integer busCod(String cod);
	
    public TBienes getBien(Integer bien);

    public List busqueda(String desc);
    
    public List datosI(String cod);
    
    public Integer updateL(Integer idcod,Date fecinl,String codini,String codfin);    

    TBienes find(Object id);

    List<TBienes> findAll();

    List<TBienes> findRange(int[] range);

    int count();
    
}
