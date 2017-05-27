/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.controller;

import com.mycompany.ejb.UserFacadeLocal;
import com.mycompany.model.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class IndexController implements Serializable{
    @EJB
    private  UserFacadeLocal userEJB;
    private User user;
    
    @PostConstruct
    public void init()
    {
        user=new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String IniciarSesion() throws Exception
    {
        User us=null;
        String redirect="";
        try {
            us=userEJB.IniciarSesion(user);
            if(us!=null)
            {
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",us);
                redirect="/Folder/Main?faces-redirect=true";
             

            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Datos invalidos"));
            }
            
            
        } catch (Exception e) {
            
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Falló"));
             throw  e;
        }
        return  redirect;
    }
    
}
