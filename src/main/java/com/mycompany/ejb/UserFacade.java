/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "PrimerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User IniciarSesion(User us) {
        User user = null;
        String consulta;
        try {
        consulta="FROM  User u WHERE u.user= ?1 and u.pass= ?2";
            Query query=em.createQuery(consulta);
            query.setParameter(1, us.getUser());
            query.setParameter(2, us.getPass());
            
            List<User> lista =query.getResultList();
            user=lista.get(0);
            
        } catch (Exception e) {
            throw e;
         
        }
        return user;
    }
}
