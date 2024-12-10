package org.bluesoft.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.elytron.security.common.BcryptUtil;
import org.bluesoft.errors.AppException;
import org.bluesoft.models.session.BlUser;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


@ApplicationScoped
public class BlUserService {

    @Inject
    Logger log;

    @Inject
    EntityManager entityManager;

    @Transactional
    public BlUser createUser(BlUser user) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getType().isEmpty()) {
            throw new AppException("Campos requeridos vacios");
        } else if (!getByUsername(user.getUsername()).isEmpty()) {
            throw new AppException("El usuario con username: " + user.getUsername() + " ya existe");
        }
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.persist();
        return user;
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BcryptUtil.matches(plainPassword, hashedPassword);
    }

    public List<BlUser> getAllUser() {
        return BlUser.listAll();
    }

    public BlUser getById(String id) {
        try {
            return BlUser.findById(id);
        } catch (NoResultException e) {
            throw new AppException(e.getMessage());
        }

    }

    ;

    public static List<BlUser> getByUsername(String username) {
        return BlUser.find("username", username).list();

    }

    public List<BlUser> getUserByOperador() {
        try {
            return BlUser.find("type", "operador").list();
        } catch (NoResultException e) {
            throw new AppException(e.getMessage());
        }
    }

    @Transactional
    public BlUser deleteUser(String id) {
        BlUser user = getById(id);
        user.delete();
        return user;
    }

    @Transactional
    public BlUser updateUser(String id,BlUser user) {
        BlUser userToUpdate = getById(id);
        if(user.getUsername()!=null || getByUsername(user.getUsername()).isEmpty()){
            if(!user.getUsername().isEmpty()){
                userToUpdate.setUsername(user.getUsername());
            }
        } else {
            throw new AppException("El usuario con username: " + user.getUsername() + " ya existe");
        }
        if(user.getFirstname()!=null){
            userToUpdate.setFirstname(user.getFirstname());
        }
        if(user.getLastname()!=null){
            userToUpdate.setLastname(user.getLastname());
        }
        if(user.getEmail()!=null){
            if(!user.getEmail().isEmpty()){
                userToUpdate.setEmail(user.getEmail());
            }
        }
        if(user.getType()!=null){
            if(!user.getType().isEmpty()){
                userToUpdate.setType(user.getType());
            }
        }
        if(user.getPassword() !=null){
            if(!user.getPassword().isEmpty()){
                userToUpdate.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
            }
        }
        userToUpdate.persist();
        return userToUpdate;
    }

    @Transactional
    public BlUser updateUserPw(String id, BlUser pw) {
        BlUser userToUpdate = getById(id);
        if(pw.getPassword()==null){
            if(pw.getPassword().isEmpty()){
                throw new AppException("Contraseña vacia");
            }
        }
        userToUpdate.setPassword(BcryptUtil.bcryptHash(pw.getPassword()));
        userToUpdate.persist();
        return userToUpdate;
    }
}
