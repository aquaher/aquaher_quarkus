package org.bluesoft.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.BlUser;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@ApplicationScoped
public class BlServices {

    @Inject
    Logger log;

    @Inject
    EntityManager entityManager;

    @Transactional
    public BlUser createUser(BlUser user){
        user.persist();
        return user;
    }

    public List<BlUser> getAllUser(){return BlUser.listAll();} 

    public BlUser getById(String id){
        try {
            return BlUser.findById(id);
        } catch (NoResultException e) {
            throw new AppException(e.getMessage());
        }

    };

    public List<BlUser> getUserByOperador(){
        try {
            return BlUser.find("type", "operador").list();
        } catch (NoResultException e) {
            throw new AppException(e.getMessage());
        }
    }
}
