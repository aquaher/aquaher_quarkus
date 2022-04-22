package org.bluesoft.models.produccion.dto;

import io.quarkus.hibernate.orm.panache.common.ProjectedFieldName;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class WaterDto {
    public Long id;
    public Double start_vol;
    public Double end_vol;
    public Double dispatch;
    public Double backwash;
    public Double total_produced;
    public String name;

    public WaterDto(Long id, Double start_vol, Double end_vol, Double dispatch, Double backwash,
            Double total_produced, @ProjectedFieldName("tank.name") String name) {
        this.id = id;
        this.start_vol = start_vol;
        this.end_vol = end_vol;
        this.dispatch = dispatch;
        this.backwash = backwash;
        this.total_produced = total_produced;
        this.name = name;
    }
}
