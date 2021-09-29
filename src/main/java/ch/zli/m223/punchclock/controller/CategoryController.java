package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.EntryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

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

@Path("/categories")
@Tag(name = "Categories", description = "Handling of entries")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    //gibt alle Einträge zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Categories", description = "")
    public List<Category> list() {
        return categoryService.findAll();
    }

    // gibt einen Category zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Category getCategory(@PathParam("id") Long id) {
        return categoryService.getCategory(id);
    }

    // fügt einen Category hinzu
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Category", description = "The newly created entry is returned. The id may not be passed.")
    public Category add(Category category) {
        return categoryService.createCategory(category);
    }

    //Löschen eines Categories anhand von der ID
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
