/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.ejb.CategoryFacadeLocal;
import com.mycompany.ejb.NoteFacadeLocal;
import com.mycompany.model.Category;
import com.mycompany.model.Note;
import com.mycompany.model.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@SessionScoped
public class LookupController implements Serializable {

    private List<Category> categories;
    private List<Note> notesN;
    @Inject
    transient private Note note;

    @EJB
    private NoteFacadeLocal noteEJB;
    @EJB
    private CategoryFacadeLocal CategoryEJB;
    private int CodCat;
    private Date DateConsult;

    @PostConstruct
    public void init() {
        try {
            if (!FacesContext.getCurrentInstance().isPostback()) {
                categories = CategoryEJB.findAll();
                notesN = noteEJB.findAll();
            }
            
               
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Note> getNotesN() {
        return notesN;
    }

    public void setNotesN(List<Note> notesN) {
        this.notesN = notesN;
    }

    public int getCodCat() {
        return CodCat;
    }

    public void setCodCat(int CodCat) {
        this.CodCat = CodCat;
    }

    public Date getDateConsult() {
        return DateConsult;
    }

    public void setDateConsult(Date DateConsult) {
        this.DateConsult = DateConsult;
    }

    public void asignar(Note nota) {
        this.note = nota;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void LookUP() {
        try {
            User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
             notesN = noteEJB.Lookfor(us.getCodeU().getCodeP(), CodCat, DateConsult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
        public void editar() {
        try {
            noteEJB.edit(note);
        } catch (Exception e) {
        }
    }
}
