package org.bluesoft.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.errors.AppMessageError;
import org.bluesoft.models.BlUser;
import org.bluesoft.services.BlServices;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Usuarios", description="Operaciones para usuarios")
public class BlUserApi {

    @Inject
    BlServices uServices;

    @GET
    public List<BlUser> getAlUsers(){
        return uServices.getAllUser();
    }

    @POST
    public BlUser createUser(BlUser blUser){
        return uServices.createUser(blUser);
    }
    
    @GET
    @Path("prueba")
    public Response prueba(){
        return Response.ok(uServices.prueba()).build();
    }
    @GET
    @Path("pruebaf")
    public Response pruebaf(){
        return Response.ok(uServices.prueba2()).build();
    }
    //not found
    @GET
    @Path("pruebag")
    public Response pruebaf3(){
        return Response.ok(uServices.prueba3()).build();
    }

    @GET
    @Path("pruebaq")
    @APIResponse(
            responseCode = "200",
            description = "Get Customer by customerId",
            content = @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = BlUser.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Customer does not exist for customerId",
            content= @Content(
                schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response pruebaq(){

        return Response.ok(uServices.prueba4()).build();
        /*try{
            Object u = uServices.prueba4();
            return Response.ok(u).build();
        }catch(ServiceException e){
            throw new AppMessageError(e.getMessage());
        }*/
    }
}
