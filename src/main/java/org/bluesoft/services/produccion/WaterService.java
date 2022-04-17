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
import org.bluesoft.models.produccion.Generic;
import org.bluesoft.models.produccion.Purified;
import org.bluesoft.models.produccion.Ultrafiltered;

@ApplicationScoped
public class WaterService {
    
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;
    /**
     * Crea un registro del tipo de agua purificada
     * @param purified
     * @return
     * Purified
     * @exception
     * AppException
     */
    @Transactional
    public Purified createPurified(Purified purified){
        try{
            purified.persist();
            return purified;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro del tipo de agua purificada");
        }
    }
    /**
     * Crea un registro del tipo de agua Ultrafiltrada
     * @param ultrafiltered
     * @return
     * Ultrafiltrada
     * @exception
     * AppException
     */
    @Transactional
    public Ultrafiltered createUltrafiltered(Ultrafiltered ultrafiltered){
        try{
            ultrafiltered.persist();
            return ultrafiltered;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro del tipo de agua ultrafiltrada");
        }
    }
    /**
     * Crea un registro de agua genérica
     * @param generic
     * @return
     * Generic
     * @exception
     * AppException
     */
    @Transactional
    public Generic createGeneric(Generic generic){
        try{
            generic.persist();
            return generic;
        }catch(Exception e){
            throw new AppException("Lo sentimos no pudimos crear un registro del tipo de agua genérica");
        }
    }
    /**
     * Retorna el registro con id
     * @param purifiedId
     * @return
     */
    public Purified getPurifiedById(Long purifiedId){
        try{
            return Purified.findById(purifiedId);
        }catch(Exception e){
            throw new AppException("No existe el registro de agua purificada");
        }
    }
    /**
     * Retorna el registro con id
     * @param ultrafilteredId
     * @return
     */
    public Ultrafiltered getUltrafilteredById(Long ultrafilteredId){
        try{
            return Ultrafiltered.findById(ultrafilteredId);
        }catch(Exception e){
            throw new AppException("No existe el registro de agua ultrafiltrada");
        }
    }
    /**
     * Retorna el registro con id
     * @param genericId
     * @return
     */
    public Generic getGenericById(Long genericId){
        try{
            return Generic.findById(genericId);
        }catch(Exception e){
            throw new AppException("No existe el registro de agua genérica");
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por fecha
     * @param date
     * @return
     */
    public List<Purified> getPurifiedByDate(LocalDate date){
        try{
            List<Purified> purified = Purified.find("date", date).list();
            if(purified.isEmpty()) throw new AppException("No existen un registro en el tipo de agua purificada");
            return purified;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua ultrafiltrada por fecha
     * @param date
     * @return
     */
    public List<Ultrafiltered> getUltrafilteredByDate(LocalDate date){
        try{
            List<Ultrafiltered> ultrafiltered = Purified.find("date", date).list();
            if(ultrafiltered.isEmpty()) throw new AppException("No existen un registro en el tipo de agua ultrafiltrada");
            return ultrafiltered;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por fecha
     * @param date
     * @return
     */
    public List<Generic> getGenericByDate(LocalDate date){
        try{
            List<Generic> generic = Generic.find("date", date).list();
            if(generic.isEmpty()) throw new AppException("No existen un registro en el tipo de agua Generica");
            return generic;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por fecha
     * @param turn
     * @return
     */
    public List<Purified> getPurifiedByTurn(Long turn){
        try{
            List<Purified> purified = Purified.find("turn", turn).list();
            if(purified.isEmpty()) throw new AppException("No existen un registro en el tipo de agua purificada");
            return purified;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua ultrafiltrada por fecha
     * @param turn
     * @return
     */
    public List<Ultrafiltered> getUltrafilteredByTurn(Long turn){
        try{
            List<Ultrafiltered> ultrafiltered = Purified.find("turn", turn).list();
            if(ultrafiltered.isEmpty()) throw new AppException("No existen un registro en el tipo de agua ultrafiltrada");
            return ultrafiltered;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por fecha
     * @param turn
     * @return
     */
    public List<Generic> getGenericByTurn(Long turn){
        try{
            List<Generic> generic = Generic.find("turn", turn).list();
            if(generic.isEmpty()) throw new AppException("No existen un registro en el tipo de agua Generica");
            return generic;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por tankId
     * @param tankId
     * @return
     */
    public List<Purified> getPurifiedByTankId(Long tankId){
        try{
            List<Purified> purified = Purified.find("tank.id", tankId).list();
            if(purified.isEmpty()) throw new AppException("No existen un registro en el tipo de agua purificada");
            return purified;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua ultrafiltrada por tankId
     * @param tankId
     * @return
     */
    public List<Ultrafiltered> getUltrafilteredByTankId(Long tankId){
        try{
            List<Ultrafiltered> ultrafiltered = Purified.find("tank.id", tankId).list();
            if(ultrafiltered.isEmpty()) throw new AppException("No existen un registro en el tipo de agua ultrafiltrada");
            return ultrafiltered;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por tankId
     * @param tankId
     * @return
     */
    public List<Generic> getGenericByTankId(Long tankId){
        try{
            List<Generic> generic = Generic.find("tank.id", tankId).list();
            if(generic.isEmpty()) throw new AppException("No existen un registro en el tipo de agua Generica");
            return generic;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por fecha
     * @param date
     * @return
     */
    public List<Purified> getPurifiedByDateAndOperator(LocalDate date,String operator){
        try{
            List<Purified> purified = Purified.find("date = ?1 AND operator LIKE ?2%", date,operator).list();
            if(purified.isEmpty()) throw new AppException("No existen un registro en el tipo de agua purificada");
            return purified;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por paginacion
     * @param date
     * @return
     */
    public List<Purified> getPurifiedByPaginate(int index,int size){
        try{
            PanacheQuery<Purified> query = Purified.findAll();
            List<Purified> purified = query.page(index, size).list();
            if(purified.isEmpty()) throw new AppException("No existen un registro en el tipo de agua purificada");
            return purified;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua ultrafiltrada por paginacion
     * @param date
     * @return
     */
    public List<Ultrafiltered> getUltrafilteredByPaginate(int index,int size){
        try{
            PanacheQuery<Ultrafiltered> query = Ultrafiltered.findAll();
            List<Ultrafiltered> ultrafiltered = query.page(index, size).list();
            if(ultrafiltered.isEmpty()) throw new AppException("No existen un registro en el tipo de agua ultrafiltrada");
            return ultrafiltered;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
    /**
     * Retorna una lista de registro de agua purificada por paginacion
     * @param date
     * @return
     */
    public List<Generic> getGenericByPaginate(int index,int size){
        try{
            PanacheQuery<Generic> query = Generic.findAll();
            List<Generic> generic = query.page(index, size).list();
            if(generic.isEmpty()) throw new AppException("No existen un registro en el tipo de agua Generica");
            return generic;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
}
