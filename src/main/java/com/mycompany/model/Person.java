/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
@Table(name="Person")
public class Person implements Serializable{

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = 6;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CodeP")
    private int codeP;
    
    @Column(name="Names")
    private String Name;
    
    @Column(name="Surnames")
    private String Surname;
    
    @Column(name="Genre")
    private String Genre;
    
    @Temporal(TemporalType.DATE)
    @Column(name="BirthDate")
    private Date BirthDate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codeP;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.codeP != other.codeP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "codeP=" + codeP + '}';
    }


    }

