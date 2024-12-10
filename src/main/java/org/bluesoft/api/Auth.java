package org.bluesoft.api;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bluesoft.errors.AppMessageError;
import org.bluesoft.models.session.UserCredentials;
import org.bluesoft.services.AuthService;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name="Auth", description="Api para obtener token")
@ApplicationScoped
public class Auth {

    @Inject
    AuthService authService;

    @POST
    @Path("/token")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Response.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response generateJwt(UserCredentials credentials){
        return Response.ok(authService.generateJwt(credentials)).build();
    }

    @GET
    @Path("/userinfo")
    @APIResponse(
            responseCode = "200",
            description = "Token válido",
            content = @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Response.class)
            )
    )
    @APIResponse(
            responseCode = "401",
            description = "Token no válido",
            content= @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response validateToken(@HeaderParam("Authorization") String authorizationHeader) {
        return Response.ok(authService.generateUserInfo(authorizationHeader)).build();
    }

    @POST
    @Path("/logout")
    @APIResponse(
            responseCode = "200",
            description = "Respuesta ok ",
            content = @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Response.class)
            )
    )
    @APIResponse(
            responseCode = "404",
            description = "Respuesta de error",
            content= @Content(
                    schema = @Schema(type = SchemaType.OBJECT, implementation = AppMessageError.class)
            )
    )
    public Response logoutJwt(@QueryParam("id_token_hint") String token){
        if (token == null || token.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("El token no puede estar vacío.")
                    .build();
        }
        return Response.ok().build();
    }


}
