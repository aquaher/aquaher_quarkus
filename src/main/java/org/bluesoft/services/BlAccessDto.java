package org.bluesoft.services;

import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class BlAccessDto {
    public Long id;
    public String path;
    public String title;
    public String module;
    public String icon;
    public Long orden;
    public BlAccessDto(Long id,@ProjectedFieldName("menu.path") String path,
    @ProjectedFieldName("menu.title") String title,@ProjectedFieldName("menu.module") String module, 
    @ProjectedFieldName("menu.icon") String icon,@ProjectedFieldName("menu.orden") Long orden) {
        this.id = id;
        this.path = path;
        this.title = title;
        this.module = module;
        this.icon = icon;
        this.orden = orden;
    }
    
    
}
