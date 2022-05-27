package org.bluesoft.services.produccion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.Bitacora;

@ApplicationScoped
public class BitacoraService {
    
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;
    
    /**
     * Crea un registro en la bitácora 
     * @param bitacora
     * @return 
     * Bitacora
     */
    @Transactional
    public Bitacora createBitacora(Bitacora bitacora){
        try{
            bitacora.persist();
            return bitacora;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro en la bitacora");
        }
    }
    /**
     * Obten el registro de la bitacora con bitacoraId
     * @param bitacoraId
     * @return
     * Bitacora
     */
    public Bitacora getBitacoraById(Long bitacoraId){
        try{
            return Bitacora.findById(bitacoraId);            
        }catch(Exception e){
            throw new AppException("No existe el registro en la bitacora");
        }
    }
    /**
     * Obtener los registro con el turno
     * @param turn
     * @return
     * Retorna una lista de registros
     */
    public List<Bitacora> getBitacoraByTurn(Long turn){
        try{
            List<Bitacora> bitacora = Bitacora.find("turn", turn).list();
            if(bitacora.isEmpty()) throw new AppException("No existen un registro en la bitacora con el turno ".concat(turn.toString()));
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Obtener un alista de registros en la bitacora con fecha
     * @param date
     * @return
     * registros con fecha
     */
    public List<Bitacora> getBitacoraByDate(LocalDate date){
        try{
            List<Bitacora> bitacora = Bitacora.find("date", date).list();
            if(bitacora.isEmpty()) throw new AppException("No existen un registro en la bitacora con fecha ".concat(date.toString()));
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Obtener lista de registros de la bitacora por los parametros
     * @param date
     * @param operator
     * @return
     */
    public List<Bitacora> getBitacoraByOperatorAndDate(LocalDate date, String operator){
        try{
            List<Bitacora> bitacora = Bitacora.find("date = ?1 AND operator LIKE ?2%", date,operator).list();
            if(bitacora.isEmpty()) throw new AppException("No existen un registro en la bitacora con fecha ".concat(date.toString()));
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * obtener una lista de registros por Turno y fecha
     * @param date
     * @param turn
     * @return
     */
    public List<Bitacora> getBitacoraByTurnAndDate(LocalDate date, Long turn){
        try{
            List<Bitacora> bitacora = Bitacora.find("date = ?1 AND turn = ?2", date,turn).list();
            if(bitacora.isEmpty()) throw new AppException("No existen un registro en la bitacora con fecha ".concat(date.toString()));
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    } 
    /**
     * Obten los registros de la bitacora paginados
     * @param index
     * @param size
     * @return
     */
    public List<Bitacora> getBitacoraAllPaginate(int index, int size){
        try{
            PanacheQuery<Bitacora> query = Bitacora.findAll(); 
            List<Bitacora> bitacora = query.page(index, size).list();
            if(bitacora.isEmpty()) throw new AppException("No existen registros en la bitácora");
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }

    public List<Bitacora> getBitacoraByMonth(int month){
        try{
            List<Bitacora> bitacora = Bitacora.find("MONTH(turn.start_date)", month).list();
            if(bitacora.isEmpty()) throw new AppException("No existen datos ");
            return bitacora;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }

    public List<Bitacora> getBitacoraRangue(){
        try {
            LocalDateTime startDate = LocalDateTime.parse(LocalDate.now().minusDays(1).toString()+"T07:00:00");
            LocalDateTime endDate = LocalDateTime.parse(LocalDate.now().plusDays(1).toString()+"T07:00:00");
            List<Bitacora> elements = Bitacora.list("turn.start_date BETWEEN ?2 AND ?3 ORDER BY id", startDate,endDate);
            return elements;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
