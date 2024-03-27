package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandManager;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.service.AppContainer;
import org.example.service.Request;

public class HelpCommand extends Command {


    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумента!");
        } else {
            AppContainer app = AppContainer.getInstance();
            CommandManager commandManager = app.getCommandManager();
            ReqWriter.write("Список команд:");
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
