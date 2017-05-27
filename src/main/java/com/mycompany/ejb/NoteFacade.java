/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ejb;

import com.mycompany.model.Note;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC
 */
@Stateless
public class NoteFacade extends AbstractFacade<Note> implements NoteFacadeLocal {

 
        @PersistenceContext(unitName = "PrimerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteFacade() {
        super(Note.class);
    }
    public List<Note> Lookfor(int codigoPersona, int codigoCategoria, Date fechaConsulta)
    {
        List<Note> Lista=null;
        try {
            
        } catch (Exception e) {
        }
        return  Lista;
    }
    
}
