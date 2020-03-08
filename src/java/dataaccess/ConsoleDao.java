package dataaccess;

import domain.Console;
import java.util.List;

public interface ConsoleDao {

    public Console createConsole(Console  newConsole);

    public Console removeConsole(String name);

    public Console updateConsole(Console updateConsole);

    public Console findConsoleByName(String name);

    public List<Console> getAllConsoles();
}
