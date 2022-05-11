package org.bluesoft.api.v1.calidad;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.produccion.calidad.Parameter;
import org.bluesoft.services.calidad.ParameterService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("parametro")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Parametros", description="Operaciones para el area de control de calidad")
public class ParameterApi {

    @Inject
    ParameterService pService;

    @GET
    public Response getParametersByDateAndTank(@QueryParam String date, @QueryParam long tank_id){
        return Response.ok(pService.getParametersByDateQualityAndTank(LocalDate.parse(date), tank_id)).build();
    }

    @POST
    public Response createParameters(@QueryParam long tank_id, @QueryParam String lote){
        return Response.ok(pService.generateParameters(tank_id, lote)).build();
    }

    @PUT
    public Response createParameters(List<Parameter> parameters){
        return Response.ok(pService.putParameters(parameters)).build();
    }
}
