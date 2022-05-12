package org.bluesoft.api.v1.produccion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.services.produccion.TurnService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("turn")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Turnos", description="Api para el manejo de los turnos")
public class TurnApi {
    
    @Inject
    TurnService tService;

    @GET
    public Response getTurnByUserId(@QueryParam String id){
        return Response.ok(tService.getTurnByUserId(id)).build();
    }

    @GET
    @Path("finalize")
    public Response endTurnAndCreate(@QueryParam long turn_id,@QueryParam String user_id){
        return Response.ok(tService.endTurnAndCreate(turn_id, user_id)).build();
    }

    @GET
    @Path("register")
    public Response registerTurn(@QueryParam long turn_id,@QueryParam String user_id){
        return Response.ok(tService.registerTurn(turn_id, user_id)).build();
    }

    
}

/*@PUT
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Turn.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    @Parameters
    public Response updateTurn(Turn turn){
        return Response.ok(tService.updateTurn(turn)).build();
    }

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Messaje.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response getTurnLast(){
        return Response.ok(tService.getVerifyTurn()).build();
    }

    @GET
    @Path("/create")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Turn.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response getTurnCreate(){
        return Response.ok(tService.getLastTurn()).build();
    }
    @GET
    @Path("/last")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Turn.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response getTurn(){
        return Response.ok(tService.getTurn()).build();
    }*/