package service;

import dataaccess.ConsoleDao;
import domain.Console;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ConsoleServiceImpl implements ConsoleService {

    @Inject
    ConsoleDao consoleDao;

    @Override
    public Console createConsole(Console createConsole) {
        return consoleDao.createConsole(createConsole);
    }

    @Override
    public Console removeConsole(String name) {
        return consoleDao.removeConsole(name);
    }

    @Override
    public Console updateConsole(Console updateConsole) {
        return consoleDao.updateConsole(updateConsole);
    }

    @Override
    public Console findConsoleByName(String name) {
        return consoleDao.findConsoleByName(name);
    }

    @Override
    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

}
