package org.bluesoft.services.produccion;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.produccion.Tank;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TankService {
    @Inject
    Logger log;

    @Inject
    EntityManager eManager;

    /**
     * creacion de un elemento tanque en la base de datos
     * @param tank
     * @return
     */
    @Transactional
    public Tank createTank(Tank tank){
        try{
            tank.persist();
            return tank;
        }catch(Exception e){
            throw new AppException("Hubo un error en crear un tanque");
        }
    }
    /**
     * Obtener un tanque con el ID del tanque
     * @param tankId
     * @return
     */
    public Tank getTankById(Long tankId){
        try{
            return Tank.findById(tankId);            
        }catch(Exception e){
            throw new AppException("No existe el tanque");
        }
    }
    /**
     * Obtener el tanque con nombre 
     * @param name
     * @return
     */
    public Tank getTankByName(String name){
        try{
            return Tank.find("name", name).firstResult();           
        }catch(Exception e){
            throw new AppException("No existe el tanque con nombre ".concat(name));
        }
    }
    /**
     * Obtener el tanque con typo de agua
     * @param name
     * @return
     */
    public List<Tank> getTankByWater(String name){
        try{
            String find = "%"+name+"%";
            return Tank.find("water LIKE ?1", find).list();           
        }catch(Exception e){
            throw new AppException("No existe el tanque con nombre ".concat(name));
        }
    }
    /**
     * Retorna todos los elementos en la tabla Tank
     * @return
     */
    public List<Tank> getAllTank(){
        try{
            List<Tank> listOfTank = Tank.listAll(); 
            if(listOfTank.isEmpty()) throw new AppException("No existen Elementos guardados");  
            return listOfTank;      
        }catch(AppException e){
            throw new AppException(e.getMessage());
        }
    }
}
