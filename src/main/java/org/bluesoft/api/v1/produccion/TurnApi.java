package org.bluesoft.api.v1.produccion;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.errors.AppMessageError;
import org.bluesoft.models.produccion.operador.Turn;
import org.bluesoft.services.produccion.TurnService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Path("turn")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Turnos", description="Api para el manejo de los turnos")
public class TurnApi {
    
    @Inject
    TurnService tService;
    
    @POST
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
    public Response getTurnLast(){
        return Response.ok(tService.getTurnByLast()).build();
    }

    @GET
    @Path("/date")
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
    
}
