package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.model.ProductDTO;
import org.example.service.Request;

public class RemoveGreaterCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумента!");
        } else {
            ProductCreator productCreator = new ProductCreator();
            ProductDTO productDTO = productCreator.createNewProduct();
            CollectionManager collectionManager = this.app.getCollectionManager();
            collectionManager.removeGreater(productDTO);
            ReqWriter.write("✓Все продукты, превышаюие введенный были удалены");

        }
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public String getName() {
        return "remove_greater";
    }
}
