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
    @Operation(summary = "List all Entries", description = "")
    public List<Entry> list() {
        return entryService.findAll();
    }

    // gibt einen Eintrag zurück
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Entry getEntry(@PathParam("id") Long id) {
        return entryService.getEntry(id);
    }

    // fügt einen Eintrag hinzu
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Entry", description = "The newly created entry is returned. The id may not be passed.")
    public Entry add(Entry entry) {
       return entryService.createEntry(entry);
    }

    //Löschen eines Eintrages anhand von der ID
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        entryService.deleteEntry(id);
    }

    //Updatet einen Eintrag
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entry updateEntry(Entry entry) {
        return entryService.update(entry);
    }

}
