package org.bluesoft.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.services.BlMenuService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("menu")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Menu", description="Opciones para el menu")
public class BlMenuApi {

    @Inject
    BlMenuService blMenuService;
    
    @GET
    public Response getAllMenu(){
        return Response.ok(blMenuService.getMenuList()).build();
    }
}
