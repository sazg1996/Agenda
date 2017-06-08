package com.mycompany.controller;

import com.mycompany.ejb.PersonFacadeLocal;
import com.mycompany.ejb.TelephoneFacadeLocal;
import com.mycompany.model.Person;
import com.mycompany.model.Telephone;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LookforTelephoneController implements Serializable {

    @EJB
    private PersonFacadeLocal personEJB;
    @EJB
    private TelephoneFacadeLocal telephoneEJB;

    private List<Person> personas;
    private List<Telephone> telephones;
    private int codigoPersona;

    public List<Telephone> getTelefonos() {
        return telephones;
    }

    public void setTelefonos(List<Telephone> telephones) {
        this.telephones = telephones;
    }   
    
    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public List<Person> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Person> personas) {
        this.personas = personas;
    }

    @PostConstruct
    public void init() {
        personas = personEJB.findAll();
    }

    public void buscarTelefonos() throws Exception {
        try {
            telephones = telephoneEJB.LookforTelephone(codigoPersona);
        } catch (Exception e) {
            throw e;
        }
    }
}
