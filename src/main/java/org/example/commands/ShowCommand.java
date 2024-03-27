package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.model.Product;
import org.example.service.Request;

public class ShowCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            if (collectionManager.getSize() == 0) {
                ReqWriter.write("Коллекция пустая");
            } else {
                for (Product p : collectionManager.getProducts()) {
                    ReqWriter.write(p.toString());
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}
