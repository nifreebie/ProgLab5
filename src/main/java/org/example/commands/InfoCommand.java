package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.model.Product;
import org.example.service.Request;

import java.io.Console;

public class InfoCommand extends Command {
    @Override
    public void execute() {
        if (Request.isCommandArg()) {
            ReqWriter.write("У команды не должно быть аргумета!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            ReqWriter.write("Информация о коллекции:");
            ReqWriter.write("Тип коллекции: " + collectionManager.getProducts().getClass().getSimpleName());
            ReqWriter.write("Тип элементов коллекции: " + Product.class.getSimpleName());
            ReqWriter.write("Количество элементов: " + collectionManager.getSize());


        }

    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

    @Override
    public String getName() {
        return "info";
    }
}
