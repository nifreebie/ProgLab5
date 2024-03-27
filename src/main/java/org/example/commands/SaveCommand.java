package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.ProductComparator;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.service.Request;

public class SaveCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            ProductComparator productComparator = new ProductComparator();
            collectionManager.sort(productComparator);
            collectionManager.save();
            ReqWriter.write("✓Коллекция сохранена");
        }

    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public String getName() {
        return "save";
    }
}
