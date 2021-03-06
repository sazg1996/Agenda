/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 * 
 */
@Entity
@Table(name="Note")
public class Note {
     
      @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Cod_Note")
    private int code;
      @ManyToOne
     @JoinColumn(name="Cod_Person",nullable=false)
    private Person person;
      @ManyToOne
      @JoinColumn(name="Cod_Category",nullable=false)
    private Category category;
      
    @Column(name="Header")
    private String header;
        
    @Column(name="Body")
    private String body;
    
         @Temporal(TemporalType.TIMESTAMP)   
     @Column(name="DateN",insertable = false)
        
    private Date dates;
        
    @Column(name="Commentary")
    private String commentary;
    
    @Column(name="Rating")
    private Integer rating;
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Category getCategoria() {
        return category;
    }

    public void setCategoria(Category categoria) {
        this.category = categoria;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return dates;
    }

    public void setDate(Date date) {
        this.dates = date;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.code;
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
        final Note other = (Note) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Note{" + "code=" + code + '}';
    }
    

}
