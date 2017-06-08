package com.mycompany.controller;


import com.mycompany.ejb.TelephoneFacadeLocal;
import com.mycompany.model.Telephone;
import com.mycompany.model.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class TelephoneController implements Serializable {

    @EJB
    private TelephoneFacadeLocal telephonoEJB;
    @Inject
    private Telephone telephone;
    private List<Telephone> telephones;
    private String action;

    public String getAccion() {
        return action;
    }

    public void setAccion(String action) {        
        this.action = action;
    }

    public List<Telephone> getTelefonos() {
        return telephones;
    }

    public void settelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    @PostConstruct
    public void init() {
        telephones = telephonoEJB.findAll();
    }

    public void registrar() {
        User us = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        telephone.setCode(us.getCodeU());
        telephonoEJB.create(telephone);
        telephones = telephonoEJB.findAll();        
    }

    public void leer(Telephone telfSeleccion) {
        telephone = telfSeleccion;
        this.setAccion("M");
    }
    
    public void modificar(Telephone tel){
        telephonoEJB.edit(tel);        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se modificó"));
    }
    
    public void mostrarDialogo(){
        //logica
        this.setAccion("R");
        
        RequestContext req = RequestContext.getCurrentInstance();
        req.execute("PF('wdialogo').show();");
    }
}
