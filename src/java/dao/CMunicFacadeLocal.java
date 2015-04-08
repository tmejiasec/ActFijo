/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CMunic;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CMunicFacadeLocal {

    void create(CMunic cMunic);

    void edit(CMunic cMunic);

    void remove(CMunic cMunic);

    CMunic find(Object id);
    
    public List getList();
       
    public List<CMunic> getListM(Integer depto);
    
    public CMunic getMuni(Integer muni);

    public List busqueda(String desc);

    List<CMunic> findAll();

    List<CMunic> findRange(int[] range);

    int count();
    
}
