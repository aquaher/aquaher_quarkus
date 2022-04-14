package org.bluesoft.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.models.BlUser;
import org.bluesoft.services.BlServices;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
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
}
/*
CREATE DEFINER=`root`@`%` PROCEDURE `prueba`()
BEGIN
SELECT * FROM BlUser;
END


CREATE DEFINER=`root`@`%` PROCEDURE `pruebaf`()
BEGIN
	SELECT id,periodo FROM BlUser WHERE periodo="2022";
END

CREATE DEFINER=`root`@`%` PROCEDURE `pruebag`()
BEGIN
	SELECT id FROM BlUser WHERE periodo="2022";
END
*/