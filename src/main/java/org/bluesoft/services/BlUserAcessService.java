package org.bluesoft.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bluesoft.errors.AppException;
import org.bluesoft.models.session.BlAccess;
import org.bluesoft.schemas.AccessSchema;
import org.bluesoft.schemas.BlAccessDto;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BlUserAcessService {
    @Inject
    Logger log;

    @Inject
    EntityManager entityManager;

    public List<AccessSchema> getAccessMenuUser(String id){
        try {
            
            List<BlAccessDto> accesos = BlAccess.find("user.id = ?1 ORDER BY menu.orden", id).project(BlAccessDto.class).list();
            List<AccessSchema> menu = new ArrayList<>();
            accesos.forEach(data->{
                List<String> nav = new ArrayList<>(Arrays.asList(data.path.split("/")));
                MenuItem(menu, data, nav);
            });
            return menu;
            //return createList(accesos);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
    private Boolean hasChildren(List<String> nav){
        return !(nav.size()==1);
    }
    private void MenuItem(List<AccessSchema> data, BlAccessDto item, List<String> nav){
        if(hasChildren(nav)){
            MultiItem(
                data.stream()
                .filter(e->e.getIcon().equals(nav.get(0)))
                .findFirst()
                .get(), 
                item, 
                nav
            );
        }
        else{
            Item(data, item);
        }
    }

    private void Item(List<AccessSchema> data, BlAccessDto item){
        data.add(new AccessSchema(item.module, item.icon, "/"+item.path, item.title, new ArrayList<>()));
    }
    private void MultiItem(AccessSchema data, BlAccessDto item,List<String> nav){
        nav.remove(0);
        MenuItem(data.getItems(), item, nav);
    }
}
