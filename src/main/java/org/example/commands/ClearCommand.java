package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;

public class ClearCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            collectionManager.clear();
            System.out.println("✓Коллекция очищена");
        }

    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public String getName() {
        return "clear";
    }
}

