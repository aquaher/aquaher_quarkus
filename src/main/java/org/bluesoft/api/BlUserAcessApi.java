package org.bluesoft.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
