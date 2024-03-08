package org.example.commands;

import org.example.command_support.Command;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.Product;

public class ShowCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            if (collectionManager.getSize() == 0) {
                System.out.println("Коллекция пустая");
            } else {
                for (Product p : collectionManager.getProducts()) {
                    System.out.println(p.toString());
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
