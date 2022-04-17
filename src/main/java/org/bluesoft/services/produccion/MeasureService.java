package org.bluesoft.services.produccion;

import java.time.LocalDate;
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
    public Measure createBitacora(Measure measure){
        try{
            measure.persist();
            return measure;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro en la bitacora");
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
}
