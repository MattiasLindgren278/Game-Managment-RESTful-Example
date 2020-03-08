package service;

import domain.Console;
import java.util.List;


public interface ConsoleService {

    public Console createConsole(Console createConsole);

    public Console removeConsole(String name);

    public Console updateConsole(Console updateConsole);

    public Console findConsoleByName(String name);

    public List<Console> getAllConsoles();
}