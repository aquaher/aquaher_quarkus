package org.bluesoft.api.v1.produccion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.produccion.Volumen;
import org.bluesoft.services.produccion.VolumenService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("volumen")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Volumen", description="Api para los Volumenes")
public class VolumenApi {

    @Inject
    VolumenService vService;
    @GET
    public Response obtenerVolumenId(@QueryParam int id){
        return Response.ok(vService.getVolumenById(id)).build();
    }
    @POST
    public Response crearVolumen(Volumen volumen){
        return Response.ok(vService.setVolumenRegister(volumen)).build();
    }
    @PUT
    public Response crearVolumen(@QueryParam int id,@QueryParam int vol){
        return Response.ok(vService.putVolumenRegister(id, vol)).build();
    }
    @GET
    @Path("informe")
    public Response getVolumensByMonthAndTurn(@QueryParam int month,@QueryParam int turn, @QueryParam String name){
        return Response.ok(vService.getVolByTurnAndMonth(month, turn,name)).build();
    }
}
