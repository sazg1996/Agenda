/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="UserA")
public class User implements Serializable {
   
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="CodeU", nullable = false)
    private Person codeU;
     @Column(name="UserN")
    private String user;
      @Column(name="Pass")
    private String pass;
       @Column(name="TypeU")
    private String type;
        @Column(name="StateU")
    private short state=1;

    public Person getCodeU() {
        return codeU;
    }

    public void setCodeU(Person codeU) {
        this.codeU = codeU;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codeU);
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
        final User other = (User) obj;
        if (this.codeU != other.codeU) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "codeU=" + codeU + '}';
    }
    
}
