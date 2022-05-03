package org.bluesoft.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.BlAccess;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BlUserAcessService {
    @Inject
    Logger log;

    @Inject
    EntityManager entityManager;

    public List<BlAccessDto> getAccessMenuUser(String id){
        try {
            /*String like_op = "%" + operator + "%";
            List<Water> water = Water.find("date = ?1 AND operator LIKE ?2", date, like_op).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;*/
            List<BlAccessDto> accesos = BlAccess.find("user.id", id).project(BlAccessDto.class).list();
            return accesos;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
