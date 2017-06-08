/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.ejb.NoteFacadeLocal;
import com.mycompany.model.Note;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class EvaluateController implements Serializable{

    @Inject
    private Note note;
    @Inject
    private LookupController noteC;
    @EJB
    private NoteFacadeLocal noteEJB;

    @PostConstruct
    public void init() {
        note = noteC.getNote();
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void editar(Note nota) {
        try {
            noteEJB.edit(note);
        } catch (Exception e) {
        }
    }
}
