package org.bluesoft.api.v1.calidad;



import javax.inject.Inject;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bluesoft.services.calidad.CalidadService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("calidad")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Calidad API", description="Operaciones para el area de producción")
public class CalidadApi {

    @Inject
    CalidadService pService;

   
}
