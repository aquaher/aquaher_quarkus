package org.bluesoft.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.session.BlUser;
import org.bluesoft.services.BlUserService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Usuarios", description="Operaciones para usuarios")
public class BlUserApi {

    @Inject
    BlUserService uServices;

    @GET
    public List<BlUser> getAlUsers(){
        return uServices.getAllUser();
    }

    @POST
    public BlUser createUser(BlUser blUser){
        return uServices.createUser(blUser);
    }

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam String id){
        return Response.ok(uServices.getById(id)).build();
    }

    @GET
    @Path("/operador")
    public Response getUserByOperador(){
        return Response.ok(uServices.getUserByOperador()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id){
        return Response.ok(uServices.deleteUser(id)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") String id, BlUser user){
        return Response.ok(uServices.updateUser(id,user)).build();
    }

    @PUT
    @Path("/pw/{id}")
    public Response updateUserPw(@PathParam("id") String id, BlUser pw){
        return Response.ok(uServices.updateUserPw(id,pw)).build();
    }
}
