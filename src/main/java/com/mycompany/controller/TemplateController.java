/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.controller;

import com.mycompany.model.User;
import javax.enterprise.context.spi.Context;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class TemplateController {
    
    public void VerifySession()
    {
        try {
            FacesContext Context=FacesContext.getCurrentInstance();
            User us=(User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if(us==null)
            {
                Context.getExternalContext().redirect("../permission");
            }
        } catch (Exception e) {
        }
    }
}
