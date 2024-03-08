package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.Product;

import java.io.Console;

public class InfoCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумета!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            System.out.println("Информация о коллекции:");
            System.out.println("Тип коллекции: " + collectionManager.getProducts().getClass().getSimpleName());
            System.out.println("Тип элементов коллекции: " + Product.class.getSimpleName());
            System.out.println("Количество элементов: " + collectionManager.getSize());


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
