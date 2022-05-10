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
import org.bluesoft.models.produccion.Water;
import org.bluesoft.schemas.produccion.dto.WaterDto;

@ApplicationScoped
public class WaterService {

    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    /**
     * Crea un registro del tipo de agua purificada
     * 
     * @param water
     * @return
     *         Water
     * @exception
     * AppException
     */
    @Transactional
    public Water createWater(Water water) {
        try {
            water.persist();
            return water;
        } catch (Exception e) {
            throw new AppException("Lo sentimos no pudimos crear un registro del tipo de agua purificada");
        }
    }
    @Transactional
    public Water editWater(Water water){
        try {
            Water waterUp = Water.findById(water.id);
            waterUp.backwash = water.backwash;
            waterUp.dispatch = water.dispatch;
            waterUp.end_vol = water.end_vol;
            waterUp.start_vol = water.start_vol;
            waterUp.total_produced = water.total_produced;
            return waterUp;
        } catch (Exception e) {
            throw new AppException("Lo sentimos no pudimos crear un registro del tipo de agua purificada");
        }
    }

    /**
     * Retorna el registro con id
     * 
     * @param waterId
     * @return
     */
    public Water getWaterById(Long waterId) {
        try {
            return Water.findById(waterId);
        } catch (Exception e) {
            throw new AppException("No existe el registro de agua purificada");
        }
    }

    /**
     * Retorna una lista de registro de agua purificada por fecha
     * 
     * @param date
     * @return
     */
    public List<Water> getWaterByDate(LocalDate date) {
        try {
            List<Water> water = Water.find("date", date).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Retorna una lista de registro de agua purificada por fecha
     * 
     * @param turn
     * @return
     */
    public List<Water> getWaterByTurn(Long turn) {
        try {
            List<Water> water = Water.find("turn.turn", turn).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Retorna una lista de registro de agua purificada por tankId
     * 
     * @param tankId
     * @return
     */
    public List<Water> getWaterByTankId(Long tankId) {
        try {
            List<Water> water = Water.find("tank.id", tankId).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Retorna un mensaje para saber si ya hay registro en el turno
     * 
     * @param tankId
     * @return
     */
    public WaterDto getWaterVerifyRegister(long tank_id, long turn) {
        try {
            WaterDto water = Water.find("tank.id = ?1 AND turn.id = ?2", tank_id, turn).project(WaterDto.class).firstResult();
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Retorna una lista de registro de agua purificada por fecha
     * 
     * @param date
     * @return
     */
    public List<Water> getWaterByDateAndOperator(LocalDate date, String operator) {
        try {
            String like_op = "%" + operator + "%";
            List<Water> water = Water.find("date = ?1 AND operator LIKE ?2", date, like_op).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Retorna una lista de registro de agua purificada por paginacion
     * 
     * @param date
     * @return
     */
    public List<Water> getWaterByPaginate(int index, int size) {
        try {
            PanacheQuery<Water> query = Water.findAll();
            List<Water> water = query.page(index, size).list();
            if (water.isEmpty())
                throw new AppException("No existen un registro en el tipo de agua purificada");
            return water;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    public List<Water> getWaterByTankAndMonth(String tankName, int month) {
        try {
            PanacheQuery<Water> query = Water.find("tank.name = ?1 AND MONTH(turn.start_date) = ?2", tankName, month);
            return query.list();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
