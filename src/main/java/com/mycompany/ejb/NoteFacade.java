/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.Note;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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

    @Override
    public List<Note> Lookfor(int codigoPersona, int codigoCategoria, Date fechaConsulta) {
        List<Note> Lista = null;
        try {
            String jpql = "FROM Note n WHERE n.person.codeP = ?1 and n.category.code = ?2 and n.dates between ?3 and ?4";
            Query query = em.createQuery(jpql);
            query.setParameter(1, codigoPersona);
            query.setParameter(2, codigoCategoria);
            query.setParameter(3, fechaConsulta, TemporalType.DATE);
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaConsulta);
            cal.add(Calendar.DATE, 1);
            query.setParameter(4, cal, TemporalType.DATE);
          
                Lista = query.getResultList();
            
        } catch (Exception e) {
            System.out.println(e);
            throw e;

        }
        return Lista;
    }

}
