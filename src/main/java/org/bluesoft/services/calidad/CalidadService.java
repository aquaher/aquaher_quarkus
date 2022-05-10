package org.bluesoft.services.calidad;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.calidad.Quality;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CalidadService {
    @Inject
    Logger logger;
    @Inject
    EntityManager entityManager;

    public List<Quality> getQualitiesByDate(LocalDate date){
        try {
            return Quality.find("date", date).list();
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

    @Transactional
    public Quality setQuality(Quality quality){
        try {
            quality.persist();
            return quality;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        } 
    }

    @Transactional
    public Quality putQualityLote(Quality quality){
        try {
            Quality edit = Quality.findById(quality.id);
            edit.lote = quality.lote;
            return edit;
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }

}
