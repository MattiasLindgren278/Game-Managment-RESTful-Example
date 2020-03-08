package dataaccess;

import domain.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GameDaoImpl implements GameDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Game createGame(Game newGame) {
        em.persist(newGame);
        return newGame;
    }

    @Override
    public Game removeGame(int id) {
        try {
            Game game = em.find(Game.class, id);
            em.remove(game);
            return game;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Game updateGame(Game updateGame) {
        try {
           return em.merge(updateGame);
        } catch (NoResultException e) {
            return null;
        }
        
    }

    @Override
    public Game findGameByID(int id) {
        try {
            return em.find(Game.class, id);
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Game> getAllGames() {
        Query query = em.createQuery("SELECT g From Game g");
        return query.getResultList();
    }

}
