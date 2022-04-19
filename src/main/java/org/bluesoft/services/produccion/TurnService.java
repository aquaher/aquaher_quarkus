package org.bluesoft.services.produccion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
            /**stp_verify_access_turn */
            StoredProcedureQuery query = eManager.createStoredProcedureQuery("stp_verify_access_turn",Turn.class);
            
            Turn turno = (Turn) query.getSingleResult();

            return turno;
        }catch(Exception e){
            log.info(e.getMessage());
            throw new AppException(e.getCause().getCause().getMessage());
        }
    }
    public Turn getLastTurn(){
        try{
            StoredProcedureQuery query = eManager.createStoredProcedureQuery("stp_turn_access",Turn.class);
            Turn newTurn = (Turn) query.getSingleResult();
            return newTurn;
        }catch(Exception e){
            throw new AppException("Hubo un error en crear el turno");
        }
    }
}
