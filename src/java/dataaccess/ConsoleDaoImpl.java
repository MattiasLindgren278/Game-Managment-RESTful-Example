package dataaccess;

import domain.Console;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ConsoleDaoImpl implements ConsoleDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public Console createConsole(Console createConsole) {
        if (findConsoleByName(createConsole.getName()) == null) {
            em.persist(createConsole);
            return createConsole;
        } else {
            return null;
        }

    }

    @Override
    public Console removeConsole(String name) {
        try {
            Console console = em.find(Console.class, name);
            em.remove(console);
            return console;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Console updateConsole(Console updateConsole) {
        try {
            findConsoleByName(updateConsole.getName());
            em.merge(updateConsole);
            return updateConsole;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Console findConsoleByName(String name) {
        try {
            Query q = em.createQuery("select c from Console c where c.name like :name");
            q.setParameter("name", name);
            return (Console) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Console> getAllConsoles() {
        Query q = em.createQuery("Select c from Console c");
        return q.getResultList();
    }

}
