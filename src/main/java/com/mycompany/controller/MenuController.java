/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@SessionScoped
public class MenuController implements Serializable{
 
    public void CerrarSesion()
    {
        try {
             FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        } catch (Exception e) {
            throw e;
        }
       
    }
}
