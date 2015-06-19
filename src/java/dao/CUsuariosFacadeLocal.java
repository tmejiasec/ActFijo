/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.CUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Teo de Renderos
 */
@Local
public interface CUsuariosFacadeLocal {

    void create(CUsuarios cUsuarios);

    void edit(CUsuarios cUsuarios);

    void remove(CUsuarios cUsuarios);
    
    public List getList();
       
    public List busqueda(String desc);
   
    public CUsuarios getUsuario(Integer usuario);
    
    public CUsuarios traeUsuarioLogeado(String usuario);
    
    public Integer busLogin(String cod);

    CUsuarios find(Object id);

    List<CUsuarios> findAll();

    List<CUsuarios> findRange(int[] range);

    int count();
    
}
