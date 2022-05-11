package org.bluesoft.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.session.BlUser;
import org.bluesoft.services.BlServices;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


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
    @Path("{id}")
    public Response getUserById(@PathParam String id){
        return Response.ok(uServices.getById(id)).build();
    }
    @GET
    @Path("/operador")
    public Response getUserByOperador(){
        return Response.ok(uServices.getUserByOperador()).build();
    }
}
