package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandManager;
import org.example.controller.ConsoleManager;
import org.example.service.AppContainer;

public class HelpCommand extends Command {


    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            AppContainer app = AppContainer.getInstance();
            CommandManager commandManager = app.getCommandManager();
            System.out.println("Список команд:");
            for (Command c : commandManager.getCommands().values()) {
                System.out.println(c.getName() + ": " + c.getDescription());
            }
        }

    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }
}
