package org.bluesoft.services.produccion;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.Event;

@ApplicationScoped
public class EventService {
    
    public List<Event> getAllEvent(){
        try{
            List<Event> event = Event.listAll();
            if(event.isEmpty()) throw new AppException("No existen Los eventos guardados");
            return event;            
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
}
