package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Class:
 *
 * @Author: Ayushan Ahilan
 * @Version:
 */


public class UserController {

    private String username;
    private String password;

    public UserController(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @POST
    @Path("/sign-up")
    public void signUp(User user){
        user.setUsername(username);
        user.setPassword(password);
        applicationUserRepository.save(user);
    }
}
