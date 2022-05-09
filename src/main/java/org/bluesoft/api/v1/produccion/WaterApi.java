package org.bluesoft.api.v1.produccion;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.errors.AppMessageError;
import org.bluesoft.models.produccion.Water;
import org.bluesoft.services.produccion.WaterService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Path("agua")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Agua", description="Api para los tipo de agua con su tanque")
public class WaterApi {
    
    @Inject
    WaterService wService;
    
    @GET
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water[].class)
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
    public Response getWaterPagination(
        @QueryParam(value = "page_index") int index,
        @QueryParam(value = "page_size") int size){
        return Response.ok(wService.getWaterByPaginate(index, size)).build();
    }
    @POST
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water.class)
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
    public Response createWater(Water water){
        return Response.ok(wService.createWater(water)).build();
    }
    @PUT
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response editWater(Water water){
        return Response.ok(wService.editWater(water)).build();
    }
    @GET
    @Path("date/{date}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water[].class)
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
    public Response getWaterByDate(@PathParam String date){
        return Response.ok(wService.getWaterByDate(LocalDate.parse(date))).build();
    }
    @GET
    @Path("tank/{tankId}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water[].class)
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
    public Response getWaterByTankId(@PathParam long tankId){
        return Response.ok(wService.getWaterByTankId(tankId)).build();
    }
    @GET
    @Path("turn/{turn}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water[].class)
            )
    )
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water.class)
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
    public Response getWaterByTurn(@PathParam long turn){
        return Response.ok(wService.getWaterByTurn(turn)).build();
    }
    @GET
    @Path("{id}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water.class)
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
    public Response getWaterById(@PathParam long id){
        return Response.ok(wService.getWaterById(id)).build();
    }

    @GET
    @Path("p_verify")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water.class)
            )
    )
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Water[].class)
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
    public Response getWaterByTankWater(@QueryParam long tank_id,@QueryParam long turn_id){
        return Response.ok(wService.getWaterVerifyRegister(tank_id,turn_id)).build();
    }
    @GET
    @Path("tank_month")
    @Parameters
    public Response getWaterByWater(@QueryParam String tankName,@QueryParam int month){
        return Response.ok(wService.getWaterByTankAndMonth(tankName, month)).build();
    }
}
