package org.bluesoft.api.v1.produccion;

import org.bluesoft.models.produccion.Ablandada;
import org.bluesoft.services.produccion.AblandadaService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ablandada")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Ablandada", description="Api para el agua ablandada")
public class AblandadaApi {
    @Inject
    AblandadaService aService;

    @GET
    public Response obtenerAblandadaId(@QueryParam int id){
        return Response.ok(aService.getAblandadaById(id)).build();
    }
    @POST
    public Response crearAblandada(Ablandada ablandada){
        return Response.ok(aService.setAblandadaRegister(ablandada)).build();
    }
    @GET
    @Path("range")
    public Response getVolByTurnAndRangueDate(@QueryParam String start_date,@QueryParam String end_date){
        return Response.ok(aService.getVolByTurnAndRangueDate(start_date, end_date)).build();
    }
}
