package org.bluesoft.api.v1.produccion;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.errors.AppMessageError;
import org.bluesoft.models.produccion.Bitacora;
import org.bluesoft.services.produccion.BitacoraService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Path("bitacora")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Bitacora", description="Api para la bitacora de operadores")
public class BitacoraApi {
    
    @Inject
    BitacoraService bService;

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getPaginateBitacora(
        @QueryParam(value = "page_index") int index,
        @QueryParam(value = "page_size") int size){
        return Response.ok(bService.getBitacoraAllPaginate(index, size)).build();
    }
    @POST
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response createBitacora(Bitacora bitacora){
        return Response.ok(bService.createBitacora(bitacora)).build();
    }
    @GET
    @Path("date")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getBitacoraByDate(@QueryParam String date){
        return Response.ok(bService.getBitacoraByDate(LocalDate.parse(date))).build();
    }
    @GET
    @Path("{bitacoraId}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora.class)
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
    public Response getBitacoraById(@PathParam Long bitacoraId){
        return Response.ok(bService.getBitacoraById(bitacoraId)).build();
    }
    @GET
    @Path("turn/{turn}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getBitacoraByTurn(@PathParam long turn){
        return Response.ok(bService.getBitacoraByTurn(turn)).build();
    }
    @GET
    @Path("o")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getBitacoraByOperatorAndDate(
        @QueryParam(value = "date") String date,
        @QueryParam(value = "operator") String operator){
        return Response.ok(bService.getBitacoraByOperatorAndDate(LocalDate.parse(date), operator)).build();
    }
    @GET
    @Path("t")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getBitacoraByTurnAndDate(
        @QueryParam(value = "date") String date,
        @QueryParam(value = "turn") Long turn){
        return Response.ok(bService.getBitacoraByTurnAndDate(LocalDate.parse(date), turn)).build();
    }
    @GET
    @Path("month")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Bitacora[].class)
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
    public Response getBitacoraByMonth(@QueryParam int number){
        return Response.ok(bService.getBitacoraByMonth(number)).build();
    }
}
