package org.bluesoft.services.produccion;

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
    public Volumen putVolumenRegister(int id, int vol){
        try{
            Volumen volumenEdit = Volumen.findById(id);
            volumenEdit.vol = vol;
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
    public Volumen getVolumenById(int id){
        try{
            return Volumen.findById(id);
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos obtener el volumen");
        }
    }
}
