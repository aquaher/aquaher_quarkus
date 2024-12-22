package org.bluesoft.services.produccion;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.Ablandada;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class AblandadaService {
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    @Transactional
    public Ablandada setAblandadaRegister(Ablandada ablandada){
        try{
            ablandada.persist();
            return ablandada;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear el registro de agua ablandada");
        }
    }


    public Ablandada getAblandadaById(long id) {
        try{
            return Ablandada.findById(id);
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos obtener el registro de agua ablandada");
        }
    }

    public List<Ablandada> getVolByTurnAndRangueDate(String start_date, String end_date) {
        try{
            LocalDateTime p = LocalDateTime.parse(start_date);
            LocalDateTime s = LocalDateTime.parse(end_date);
            List<Ablandada> ablandadaList = Ablandada.find("dateTime BETWEEN ?1 AND ?2 ORDER BY dateTime", p,s).list();
            return ablandadaList;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
}
