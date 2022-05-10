package org.bluesoft.schemas.produccion.calidad.dto;

import org.bluesoft.models.produccion.calidad.Method;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ParameterDto {
    public Long id;
    public String name;
    public Method method;
    public ParameterDto(Long id, String name, Method method) {
        this.id = id;
        this.name = name;
        this.method = method;
    }
}
