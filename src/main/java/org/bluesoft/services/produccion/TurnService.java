package org.bluesoft.services.produccion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.helper.Messaje;
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
            Turn turno = Turn.findById(turn.id);
            turno.operador = turn.operador;
            return turno;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        } 
    }
    public Turn getTurn(){
        try{
            Query query = eManager.createQuery("SELECT p FROM Turn p WHERE id = (SELECT MAX(id) FROM Turn)",Turn.class);
            Turn turno = (Turn) query.getSingleResult();
            return turno;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    public Messaje getVerifyTurn(){
        try{
            /**stp_verify_access_turn */
            StoredProcedureQuery query = eManager.createStoredProcedureQuery("stp_verify_access_turn");
            Object turno =  query.getSingleResult();
            return new Messaje(turno.toString());
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
