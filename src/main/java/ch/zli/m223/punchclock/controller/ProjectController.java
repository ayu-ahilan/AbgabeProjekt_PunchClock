package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.ProjectService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Class:
 *
 * @Author: Ayushan Ahilan
 * @Version:
 */

@Path("/projects")
@Tag(name = "Project", description = "Handling of Projects")
public class ProjectController {
    @Inject
    ProjectService projectService;

    //gibt alle Einträge zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Projects", description = "It will return all Projects")
    public List<Project> list() {
        return projectService.findAll();
    }

    // gibt einen Category zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Get a Project", description = "The Project with the right Id will be returned")
    public Project getProject(@PathParam("id") Long id) {
        return projectService.getProject(id);
    }

    // fügt einen Category hinzu
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Project", description = "The newly created Project is returned. The id may not be passed.")
    public Project add(Project project) {
        return projectService.createProject(project);
    }

    //Löschen eines Categories anhand von der ID
    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete a Project", description = "The Project with the right Id will be deleted")
    public void delete(@PathParam("id") Long id) {
        projectService.deleteProject(id);
    }
}
