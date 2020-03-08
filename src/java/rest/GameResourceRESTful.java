package rest;

import domain.Game;
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
import service.GameService;

@Path("/games")
public class GameResourceRESTful {
    
    @Inject
    GameService gameService;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Status createGame(Game newGame) {
        gameService.createGame(newGame);
        return Response.Status.CREATED;
    }
    

    @DELETE
    @Path("{id}")
    public Game deleteGame(@PathParam("id")int id) {
        Game game = gameService.removeGame(id);
        if(game == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return game;
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Game updateGame(Game game) {
        if (game == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return gameService.updateGame(game);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Game findGameByID(@PathParam("id")int id) {
        Game game = gameService.findGameByID(id);
        if(game == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return game;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Game> getAllGames() {
        List<Game> games = gameService.getAllGames();
        if (!games.isEmpty()) {
            return games;
        }else{
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
         
    }

}
