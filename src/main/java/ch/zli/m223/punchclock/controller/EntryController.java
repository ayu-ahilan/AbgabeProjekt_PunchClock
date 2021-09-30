package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/entries")
@Tag(name = "Entries", description = "Handling of entries")
public class EntryController {

    @Inject
    EntryService entryService;

    //gibt alle Einträge zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all Entries", description = "All Entries will be returned")
    public List<Entry> list() {
        return entryService.findAll();
    }

    // gibt einen Eintrag zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Get the Entry", description = "The one Entry will returned")
    public Entry getEntry(@PathParam("id") Long id) {
        return entryService.getEntry(id);
    }

    // fügt einen Eintrag hinzu
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add an new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    //Löschen eines Eintrages anhand von der ID
    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete an Entry", description = "The Entriy with the right Id will be deleted")
    public void delete(@PathParam("id") Long id) {
        entryService.deleteEntry(id);
    }

    //Updatet einen Eintrag
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Update an Entry", description = "The Entriy with the right Id will be updated")
    public Entry updateEntry(Entry entry) {
        return entryService.update(entry);
    }

}
