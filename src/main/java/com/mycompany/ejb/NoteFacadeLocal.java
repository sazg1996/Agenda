/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ejb;

import com.mycompany.model.Note;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface NoteFacadeLocal {

    void create(Note nota);

    void edit(Note nota);

    void remove(Note nota);

    Note find(Object id);

    List<Note> findAll();

    List<Note> findRange(int[] range);

    int count();      
    
    List<Note> buscar(int codigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception;
}

