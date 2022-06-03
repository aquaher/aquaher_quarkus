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
import org.bluesoft.models.produccion.Measure;
import org.bluesoft.services.produccion.MeasureService;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameters;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;

@Path("measure")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Medidores", description="Api para los medidores de energia")
public class MeasureApi {

    @Inject
    MeasureService mService;
    
    @GET
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure[].class)
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
    public Response getPaginateMeasure(
        @QueryParam(value = "page_index") int index,
        @QueryParam(value = "page_size") int size){
        return Response.ok(mService.getMeasurePaginate(index, size)).build();
    }
    @POST
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure.class)
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
    public Response createMeasure(Measure measure){
        return Response.ok(mService.createMeasure(measure)).build();
    }
    @PUT
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response editMeasure(Measure measure){
        return Response.ok(mService.editMeasure(measure)).build();
    }
    @GET
    @Path("date/{date}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure[].class)
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
    public Response getPaginateByDate(@PathParam String date){
        return Response.ok(mService.getMeasureByDate(LocalDate.parse(date))).build();
    }
    @GET
    @Path("{measureId}")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure.class)
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
    public Response getMeasureById(@PathParam Long measureId){
        return Response.ok(mService.getMeasureById(measureId)).build();
    }
    @GET
    @Path("/turn")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = Measure.class)
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
    public Response getMeasureByTurnId(@QueryParam Long turn_id){
        return Response.ok(mService.getMeasureByTurn(turn_id)).build();
    }

    @GET
    @Path("month")
    public Response getMeasureByMonth(@QueryParam int number){
        return Response.ok(mService.getMeasureByMonth(number)).build();
    }

    @GET
    @Path("day")
    public Response getMeasureByDay(){
        return Response.ok(mService.getMeasureByRangueDay()).build();
    }

    @GET
    @Path("rangue")
    public Response getMeasureByRnague(@QueryParam String startDate,@QueryParam String endDate){
        return Response.ok(mService.getMeasureByRangueDefined(startDate,endDate)).build();
    }
}
