package org.bluesoft.services.calidad;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.calidad.Parameter;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ParameterService {
    @Inject
    Logger logger;
    @Inject
    EntityManager entityManager;

    public List<Parameter> getParametersByDateQualityAndTank(LocalDate date,long tank_id){
        try {
            return Parameter.find("quality.date = ?1 AND tank.id = ?2", date,tank_id).list();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
    /**
     * @param _tank_id int
     * @param _lote Strgin
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Parameter> generateParameters(long tank_id, String lote){
        try {
            StoredProcedureQuery query = entityManager.
            createNamedStoredProcedureQuery("stp_create_parameter")
            .setParameter("_tank_id", tank_id)
            .setParameter("_lote", lote);
            return query.getResultList();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    @Transactional
    public List<Parameter> putParameters(List<Parameter> parameters){
        try {
            parameters.forEach(element->{
                Parameter edit = Parameter.findById(element.id);
                edit.result = element.result;
            });
            return parameters;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
}
