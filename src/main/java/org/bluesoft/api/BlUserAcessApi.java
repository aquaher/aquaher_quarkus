package org.bluesoft.api;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.session.BlAccess;
import org.bluesoft.services.BlUserAcessService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("users_access")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Accesos", description="Operaciones para usuarios y accesos")
public class BlUserAcessApi {

    @Inject
    BlUserAcessService userAcessService;

    @GET
    public Response getAccess(@QueryParam String id){
        return Response.ok(userAcessService.getAccessMenuUser(id)).build();
    }
    @GET
    @Path("normal")
    public Response getAccessNormal(@QueryParam String id){
        return Response.ok(userAcessService.getAccesos(id)).build();
    }
    @POST
    public Response postAccess(BlAccess access){
        userAcessService.postAccess(access);
        return Response.ok().build();
    }
    @DELETE
    public Response deleteAccess(@QueryParam long id){
        userAcessService.deleteAccess(id);
        return Response.ok().build();
    }
}
