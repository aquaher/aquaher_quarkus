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
import javax.persistence.StoredProcedureQuery;

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

    @SuppressWarnings("unchecked")
    public List<BlUser> prueba(){
        try {
            StoredProcedureQuery result = entityManager.createStoredProcedureQuery("prueba",BlUser.class);
            List<BlUser> blUser = result.getResultList();
            return blUser;
        } catch (NoResultException e) {
            throw new AppException(e.getMessage());
        }
        
    }

    public BlUser prueba2(){
        try {
            StoredProcedureQuery result = entityManager.createStoredProcedureQuery("pruebaf",BlUser.class);
            BlUser blUser = (BlUser) result.getSingleResult();
            return blUser;
        } catch(NoResultException e){
            throw new AppException(e.getMessage());
        }
        
    }
    public BlUser prueba3(){
        StoredProcedureQuery result = entityManager.createStoredProcedureQuery("pruebag");
        Object blUser = result.getSingleResult();
        return new BlUser(blUser.toString());
    }
    public Object prueba4(){
        try{
            StoredProcedureQuery result = entityManager.createStoredProcedureQuery("pruebaq");
            return result.getSingleResult();
        }catch(NoResultException e){
            throw new AppException(e.getMessage());
        }
        
    }
}
