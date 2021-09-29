package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Class:
 *
 * @Author: Ayushan Ahilan
 * @Version:
 */

@Path("/users")
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Entries", description = "")
    public List<User> list() {
        return userService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getEntry(@PathParam("id") Long id) {
        return userService.getUserById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public User add(User user) {
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        userService.deleteUser(id);
    }

}
