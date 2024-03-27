package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.service.Request;

public class ClearCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            collectionManager.clear();
            ReqWriter.write("✓Коллекция очищена");
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

