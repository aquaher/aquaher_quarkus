package org.bluesoft.services.produccion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
    public Turn createTurn(Turn turn){
        try{
            turn.persist();
            return turn;
        }catch(Exception e){
            throw new AppException("Hubo un error en crear un tanque");
        } 
    }

    public Turn getByOperator(String operator){
        try{
            return Turn.find("operador LIKE ?1%", operator).firstResult();
        }catch(Exception e){
            throw new AppException("No existe el turno del operador");
        }
    }

    public Turn getById(Long id){
        try{
            return Turn.findById(id);
        }catch(Exception e){
            throw new AppException("No existe el turno");
        }
    }
}
