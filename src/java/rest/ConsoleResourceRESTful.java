package rest;

import domain.Console;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import service.ConsoleService;

@Path("/consoles")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ConsoleResourceRESTful {

    @Inject
    private ConsoleService service;

    @POST
    public Status createConsole(Console createConsole) {
        Console console = service.createConsole(createConsole);
        if (console != null) {
            return Response.Status.CREATED;
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

    }

    @DELETE
    @Path("{name}")
    public Console removeConsole(@PathParam("name") String name
    ) {
        Console console = service.removeConsole(name);
        if (console == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return console;
    }

    @PUT
    @Path("{name}")
    public Console updateConsole(Console updateConsole,
            @PathParam("name") String name
    ) {
        Console console = service.updateConsole(updateConsole);
        if (console == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return console;
    }

    @GET
    @Path("{name}")
    public Console findConsoleByName(@PathParam("name") String name
    ) {
        Console console = service.findConsoleByName(name);
        if (console == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return console;
    }

    @GET
    public List<Console> getAllConsoles() {
        List<Console> consoles = service.getAllConsoles();
        if (!consoles.isEmpty()) {
            return consoles;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}
