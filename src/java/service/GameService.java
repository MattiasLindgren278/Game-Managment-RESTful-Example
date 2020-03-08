package service;

import domain.Game;
import java.util.List;

public interface GameService {

    public Game createGame(Game newGame);

    public Game removeGame(int id);

    public Game updateGame(Game updateGame);

    public Game findGameByID(int id);

    public List<Game> getAllGames();
}
