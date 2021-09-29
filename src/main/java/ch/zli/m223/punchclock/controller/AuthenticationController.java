package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Class:
 *
 * @Author: Ayushan Ahilan
 * @Version:
 */
@Path("/auth")
public class AuthenticationController {

    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/User")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(User user) {
        if (authenticationService.checkifUserExists(user)) {
            return authenticationService.GenerateValidJwtToken(user.getUsername());
        } else {
            throw new NotAuthorizedException("User ["+user.getUsername()+"]");
        }
    }
}
