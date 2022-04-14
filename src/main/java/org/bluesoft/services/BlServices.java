package org.bluesoft.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.bluesoft.models.BlUser;
import org.bluesoft.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

//import javax.persistence.Procedure;
@ApplicationScoped

public class BlServices {

    @Inject
    UserRepository uRepository;
    @Inject
    EntityManager entityManager;

    @Transactional
    public BlUser createUser(BlUser user){
        uRepository.persist(user);
        //StoredProcedureQuery uwu = entityManager.createQuery(qlString)
        return user;
    }

    public List<BlUser> getAllUser(){return uRepository.listAll();} 

    public List<BlUser> prueba(){
        StoredProcedureQuery result = entityManager.createStoredProcedureQuery("prueba",BlUser.class);

        @SuppressWarnings("unchecked")
        List<BlUser> blUser = result.getResultList();
        return blUser;
    }

    public BlUser prueba2(){
        StoredProcedureQuery result = entityManager.createStoredProcedureQuery("pruebaf",BlUser.class);
        //@SuppressWarnings("unchecked")
        BlUser blUser = (BlUser) result.getSingleResult();
        return blUser;
    }
    public Object prueba3(){
        StoredProcedureQuery result = entityManager.createStoredProcedureQuery("pruebaf",Object.class);
        //@SuppressWarnings("unchecked")
        Object blUser = result.getSingleResult();
        return blUser;
    }
}
