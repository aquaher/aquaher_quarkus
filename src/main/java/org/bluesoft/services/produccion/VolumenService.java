package org.bluesoft.services.produccion;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.Volumen;
import org.jboss.logging.Logger;

@ApplicationScoped
public class VolumenService {
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    @Transactional
    public Volumen setVolumenRegister(Volumen volumen){
        try{
            volumen.persist();
            return volumen;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear el registro de voluemenes");
        }
    }
    @Transactional
    public Volumen putVolumenRegister(Volumen volumen){
        try{
            Volumen volumenEdit = Volumen.findById(volumen.id);
            volumenEdit.vol = volumen.vol;
            return volumenEdit;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos editar el registro");
        }
    }
    public List<Volumen> getVolByTurnAndMonth(int month,int turn,String name){
        try{
            List<Volumen> volumens = Volumen.find("MONTH(turn.start_date) = ?1 AND turn.turn = ?2 AND tank.name = ?3", month,turn,name).list();
            return volumens;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos Obtener la lista de volumenes");
        }
    }
    public Volumen getVolumenById(long id){
        try{
            return Volumen.findById(id);
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos obtener el volumen");
        }
    }

    public Volumen getVolByTurnAndTank(long turn,long tank){

        try{
            Volumen volumen = Volumen.find("turn.id = ?1 AND tank.id = ?2", turn,tank).firstResult();
            return volumen;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    public List<Volumen> getVolByTurnAndRangueDate(String start_date,String end_date){
        try{
            LocalDateTime p = LocalDateTime.parse(start_date);
            LocalDateTime s = LocalDateTime.parse(end_date);
            List<Volumen> volumens = Volumen.find("turn.start_date BETWEEN ?1 AND ?2 ORDER BY id", p,s).list();
            return volumens;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }

    public List<Volumen> getVolByTurnAndRangueDateAndTurn(String start_date,String end_date,int turn){
        try{
            LocalDateTime p = LocalDateTime.parse(start_date);
            LocalDateTime s = LocalDateTime.parse(end_date);
            List<Volumen> volumens = Volumen.find("turn.turn = ?1 AND turn.start_date BETWEEN ?2 AND ?3 ORDER BY id", turn,p,s).list();
            return volumens;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }

    public List<Volumen> getVolByTurnAndRangueDateAndTurnAndTank(String start_date,String end_date,int turn,long tank){
        try{
            LocalDateTime p = LocalDateTime.parse(start_date);
            LocalDateTime s = LocalDateTime.parse(end_date);
            List<Volumen> volumens = Volumen.find("turn.turn = ?1 AND tank.id = ?2 AND turn.start_date BETWEEN ?3 AND ?4 ORDER BY id", turn,tank,p,s).list();
            return volumens;
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
}
