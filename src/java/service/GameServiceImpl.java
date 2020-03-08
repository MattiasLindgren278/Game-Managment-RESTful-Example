package service;

import dataaccess.GameDao;
import domain.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GameServiceImpl implements GameService {
    
    @Inject
    private GameDao gameDao;

    @Override
    public Game createGame(Game newGame) {
       return gameDao.createGame(newGame);
    }

    @Override
    public Game removeGame(int id) {
       return gameDao.removeGame(id);
    }

    @Override
    public Game updateGame(Game updateGame) {
        return gameDao.updateGame(updateGame);
    }

    @Override
    public Game findGameByID(int id) {
        return gameDao.findGameByID(id);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

}
