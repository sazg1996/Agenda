/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Telephone;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MitoCode
 */
@Local
public interface TelephoneFacadeLocal {

    void create(Telephone telefono);

    void edit(Telephone telefono);

    void remove(Telephone telefono);

    Telephone find(Object id);

    List<Telephone> findAll();

    List<Telephone> findRange(int[] range);

    int count();
    
    List<Telephone> LookforTelephone(int codigoPersona) throws Exception;
}
