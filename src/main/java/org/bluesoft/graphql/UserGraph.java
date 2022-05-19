package org.bluesoft.graphql;

import java.util.List;

import javax.inject.Inject;

import org.bluesoft.models.session.BlUser;
import org.bluesoft.services.BlUserService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import io.vertx.core.cli.annotations.Description;

@GraphQLApi
public class UserGraph {

    @Inject
    BlUserService blServices;

    @Query("allUsers") 
    @Description("Get all Users from") 
    public List<BlUser> getAllFilms() {
        return blServices.getAllUser();
    }
    
}
