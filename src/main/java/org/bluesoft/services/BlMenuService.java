package org.bluesoft.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.menu.BlMenu;
import org.jboss.logging.Logger;

import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class BlMenuService {
    @Inject
    Logger log;

    public List<BlMenu> getMenuList(){
        try{
            return BlMenu.listAll(Sort.by("orden"));
        }catch(Exception e){
            throw new AppException(e.getMessage());
        }
    }
}
