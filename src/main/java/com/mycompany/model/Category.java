/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.omg.PortableInterceptor.ACTIVE;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Category ")
public class Category implements Serializable {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private int code;
    @Column(name = "Name")
    private String name;
    @Column(name = "StateC")
    private boolean state = true;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.code;
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
        final Category other = (Category) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "code=" + code + '}';
    }

}
