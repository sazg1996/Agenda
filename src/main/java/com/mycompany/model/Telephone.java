/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="Telephone")
public class Telephone {

    public int getCodeT() {
        return codeT;
    }

    public void setCodeT(int codeT) {
        this.codeT = codeT;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getCode() {
        return code;
    }

    public void setCode(Person code) {
        this.code = code;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Code")
     private int codeT;
     @Column(name="Number")
     private String number;
     @ManyToOne
     @JoinColumn(name="Cod_Pers",nullable=false)
     private Person code;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codeT;
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
        final Telephone other = (Telephone) obj;
        if (this.codeT != other.codeT) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telephone{" + "codeT=" + codeT + '}';
    }
     
     
}
