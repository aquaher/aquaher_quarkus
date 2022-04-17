package org.bluesoft.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.Unit;
import org.bluesoft.models.produccion.Tank;
import org.bluesoft.models.produccion.calidad.Method;
import org.bluesoft.models.produccion.calidad.Parameter;
import org.bluesoft.models.produccion.calidad.Quality;
import org.bluesoft.models.produccion.calidad.dto.ParameterDto;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CalidadService {
    @Inject
    Logger logger;
    @Inject
    EntityManager entityManager;
    /**
     * 
     * @return
     * List object method created
     */
    public List<Method> getAllMethods(){
            List<Method> methods = Method.listAll();
            if (methods.isEmpty()) {
                throw new AppException("No existen Métodos agregados");
            }
            return methods;
    }

    /**
     * 
     * @return
     * List of Unit created
     */
    public List<Unit> getAllUnit(){
        List<Unit> units = Unit.listAll();
        if (units.isEmpty()) {
            throw new AppException("No existen unidades de medidas agregadas");
        }
        return units;
    }

    /**
     * 
     * @param method
     * @return
     * object Method create
     */

    @Transactional
    public Method createMethod(Method method){
        try {
            method.persist();
            return method;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
    /**
     * 
     * @param unit
     * @return
     * object Unit create
     */
    @Transactional
    public Unit createUnit(Unit unit){
        try {
            unit.persist();
            return unit;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * 
     * @param qualityId
     * @return 
     * all parameters by quality id
     */

    public List<Parameter> getParameterBy(Long qualityId){
        try {
            return Parameter.find("quality.id", qualityId).list();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * method for created parameter
     * @param parameter
     * @return
     * a object parameter create
     */
    @Transactional
    public Parameter createParameter(Parameter parameter){
        try {
            parameter.persist();
            return parameter;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * method for created parameter for list
     * @param parameter
     * @return
     * a object parameter create
     */
    @Transactional
    public List<ParameterDto> createParameter(List<Parameter> parameter){
        try {
            // NO otengo los resultados pero si guarda
            List<ParameterDto> list = new ArrayList<>();
            parameter.forEach(el->{
                StoredProcedureQuery result = entityManager.createStoredProcedureQuery("stp_parameter",Parameter.class);
                result.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN);
                result.registerStoredProcedureParameter("_method_id", Long.class, ParameterMode.IN);
                result.registerStoredProcedureParameter("_quality_id", Long.class, ParameterMode.IN);
                result.registerStoredProcedureParameter("_unit_id", Long.class, ParameterMode.IN);
                result.setParameter("_name" ,el.name);
                result.setParameter("_method_id", el.method.id);
                result.setParameter("_quality_id", el.quality.id);
                result.setParameter("_unit_id", el.unit.id);
                Parameter par = (Parameter) result.getSingleResult();
                list.add(new ParameterDto(par.id, par.name, par.method, par.unit) );
            });
            
            return list;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * a method create element in Quality table
     * @param quality
     * @return 
     * Quality
     */
    @Transactional
    public Quality createQuality(Quality quality){
        try {
            quality.persist();
            return quality;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
    /**
     * 
     * @param id
     * @return
     */
    public Quality getQualityById(Long id){
        try {
            return Quality.findById(id);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * 
     * @param id
     * @return
     */
    public Quality getQualityByTankId(Long tankId){
        try {
            return Quality.find("active = ?1 AND tank.id = ?2", true ,tankId).firstResult();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    /**
     * Method create tank
     * @param tank
     * @return
     */
    @Transactional
    public Tank createTank(Tank tank){
        try {
            tank.persist();
            return tank;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
