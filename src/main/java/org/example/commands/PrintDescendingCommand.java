package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.ProductComparator;
import org.example.command_support.ReverseProductComparator;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.Product;

public class PrintDescendingCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            ReverseProductComparator reverseProductComparator = new ReverseProductComparator();
            collectionManager.sort(reverseProductComparator);
            for (Product p : collectionManager.getProducts()) {
                System.out.println(p.toString());
            }
            ProductComparator productComparator = new ProductComparator();
            collectionManager.sort(productComparator);

        }
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке убывания";
    }

    @Override
    public String getName() {
        return "print_descending";
    }
}
