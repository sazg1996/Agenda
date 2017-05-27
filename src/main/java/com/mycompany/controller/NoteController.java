package com.mycompany.controller;

import com.mycompany.ejb.CategoryFacadeLocal;
import com.mycompany.ejb.NoteFacadeLocal;
import com.mycompany.model.Category;
import com.mycompany.model.Note;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class NoteController {

    private List<Category> categories;
    @EJB
    private NoteFacadeLocal noteEJB;
    @EJB
    private CategoryFacadeLocal CategoryEJB;
    @Inject
    private Category category;
    @Inject
    private Note note;

    @PostConstruct
    public void init() {
        categories = CategoryEJB.findAll();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void registrar() {

        try {
            noteEJB.create(note);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}
