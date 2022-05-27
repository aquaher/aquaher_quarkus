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
import org.bluesoft.models.produccion.Measure;

@ApplicationScoped
public class MeasureService {
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    /**
     * Crear un registro en la tabla de los medidores
     * @param measure
     * @return
     */
    @Transactional
    public Measure createMeasure(Measure measure){
        try{
            measure.persist();
            return measure;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro en la bitacora");
        }
    }
    @Transactional
    public Measure editMeasure(Measure measure){
        try{
            Measure editMeasure = Measure.findById(measure.id);
            editMeasure.measurement_channel = measure.measurement_channel;
            editMeasure.measurement_time = measure.measurement_time;
            editMeasure.reading_kvarh_14 = measure.reading_kvarh_14;
            editMeasure.reading_kvarh_8 = measure.reading_kvarh_8;
            editMeasure.reading_kwh_1 = measure.reading_kwh_1;
            editMeasure.reading_kwh_13 = measure.reading_kwh_13;
            return measure;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos editar un registro en la bitacora");
        }
    }
    /**
     * obten el registro del medidos por el id
     * @param measureId
     * @return
     */
    public Measure getMeasureById(Long measureId){
        try{
            return Measure.findById(measureId);            
        }catch(Exception e){
            throw new AppException("No existe el registro de medidas");
        }
    }
    /**
     * Obtener el registro de medidores por fecha
     * @param date
     * @return
     */
    public List<Measure> getMeasureByDate(LocalDate date){
        try{
            return Measure.find("date", date).list();            
        }catch(Exception e){
            throw new AppException("No existe el registro de medidas");
        }
    }
    /**
     * Todos los registros paginado con un inicio y el tamaño
     * @param index
     * @param size
     * @return
     */    
    public List<Measure> getMeasurePaginate(int index,int size){
        try{
            PanacheQuery<Measure> query = Measure.findAll();
            query.page(index, size);
            List<Measure> measure = query.list();
            if(measure.isEmpty()) throw new AppException("No existen registros en los medidores");
            return measure;          
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }

    public Measure getMeasureByTurn(long turn_id){
        try{
            Measure measure = Measure.find("turn.id", turn_id).firstResult();
            return measure;            
        }catch(Exception e){
            throw new AppException("No existe el registro de medidas");
        }
    }

    public List<Measure> getMeasureByMonth(int month){
        try{
            List<Measure> measure = Measure.find("MONTH(turn.start_date)", month).list();
            return measure;            
        }catch(Exception e){
            throw new AppException("No existe el registro de medidores");
        }
    }
    public List<Measure> getMeasureByRangueDay(){
        try{
            LocalDateTime s = LocalDateTime.parse(LocalDate.now().minusDays(1).toString()+"T07:00:00");
            LocalDateTime e = LocalDateTime.parse(LocalDate.now().plusDays(1).toString()+"T07:00:00");
            List<Measure> measure = Measure.find("turn.start_date BETWEEN ?1 AND ?2",s,e).list();
            return measure;            
        }catch(Exception e){
            throw new AppException("No existe el registro de medidores");
        }
    }
}
