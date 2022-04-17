package org.bluesoft.models.produccion.calidad.dto;

import org.bluesoft.models.Unit;
import org.bluesoft.models.produccion.calidad.Method;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ParameterDto {
    public Long id;
    public String name;
    public Method method;
    public Unit unit;
    public ParameterDto(Long id, String name, Method method, Unit unit) {
        this.id = id;
        this.name = name;
        this.method = method;
        this.unit = unit;
    }
}
