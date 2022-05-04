package org.bluesoft.services;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bluesoft.errors.AppException;

import org.bluesoft.models.BlAccess;
import org.jboss.logging.Logger;

@ApplicationScoped
public class BlUserAcessService {
    @Inject
    Logger log;

    @Inject
    EntityManager entityManager;

    public List<BlAccessDto> getAccessMenuUser(String id){
        try {

            List<BlAccessDto> accesos = BlAccess.find("user.id", id).project(BlAccessDto.class).list();
            return accesos;
            //return createList(accesos);
        } catch (Exception e) {
            throw new AppException(e.getMessage());
        }
    }
    /*
    private List<AccessSchema> createList(List<BlAccessDto> accesos){
        List<AccessSchema> data = new ArrayList<>();
        accesos.forEach(el->{
            String[] menu_s = el.path.split("\\.");
            for (int i = 0; i < menu_s.length; i++) {
                String path = menu_s[i];
                if(i==0){
                    AccessSchema exist = data.stream().filter(e->e.path.equals(path)).findFirst().orElse(null);
                    if(exist==null){
                        data.add(new AccessSchema(el.icon, path, el.title, new ArrayList<>()));
                    }
                }
                if(i>=1){
                    String pathAnt = menu_s[i-1];
                    AccessSchema anterior = data.stream().filter(e->e.path.equals(pathAnt)).findFirst().orElse(null);
                    int indexAnte = data.indexOf(anterior);
                    AccessSchema nuevo = anterior.items.stream().filter(e->e.path.equals(path)).findFirst().orElse(null); 
                    if(nuevo==null){
                        anterior.items.add(new AccessSchema(el.icon, path, el.title, new ArrayList<>()));
                        data.set(indexAnte, anterior);
                    }
                }
            }
        });
        return data;
    }*/
}
