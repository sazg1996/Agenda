/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.controller;

import com.mycompany.ejb.CategoryFacadeLocal;
import com.mycompany.model.Category;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author PC
 */
@Named
@ViewScoped
public class CategoryController implements Serializable{
    @EJB
    private CategoryFacadeLocal categoriaEJB;
    private Category Category;
        public Category getCategory() {
        return Category;
    }

    public void setCategory(Category Category) {
        this.Category = Category;
    }
    
           @PostConstruct
            public void  init()
            {
                Category=new Category();
            }
            public void registrar()
            {
                try {
                        categoriaEJB.create(Category);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }


}
