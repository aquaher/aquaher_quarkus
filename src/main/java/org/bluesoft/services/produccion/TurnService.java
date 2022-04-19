package org.bluesoft.services.produccion;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.operador.Turn;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TurnService {
    
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    @Transactional
    public Turn updateTurn(Turn turn){
        try{
            turn.persist();
            return turn;
        }catch(Exception e){
            throw new AppException("Hubo un error en actualizar");
        } 
    }
    public Turn getTurnByLast(){
        try{
            Turn turno = eManager.createQuery("SELECT * FROM p_turn WHERE id = (SELECT MAX(id) FROM p_turn)",Turn.class).getSingleResult();
            return turno;
        }catch(Exception e){
            throw new AppException("Hubo un error en actualizar");
        } 
    }
    public Turn getLastTurn(Turn turn){
        try{
            StoredProcedureQuery query = eManager.createStoredProcedureQuery("stp_turn_access",Turn.class);
            query.registerStoredProcedureParameter("_date", LocalDateTime.class, ParameterMode.IN);
            query.setParameter("_date", turn.start_date);
            Turn newTurn = (Turn) query.getSingleResult();
            return newTurn;
        }catch(Exception e){
            throw new AppException("Hubo un error en crear el turno");
        }
    }
}
