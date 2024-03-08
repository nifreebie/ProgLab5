package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.ProductComparator;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.Product;
import org.example.model.ProductDTO;

import java.io.Console;

public class AddIfMinCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента");
        } else {
            ProductCreator productCreator = new ProductCreator();
            ProductDTO productDTO = productCreator.createNewProduct();
            CollectionManager collectionManager = this.app.getCollectionManager();
            if (collectionManager.checkIfMin(productDTO)) {
                collectionManager.add(productDTO);
                System.out.println("✓Продукт добавлен в коллекцию");
                ProductComparator productComparator = new ProductComparator();
                collectionManager.sort(productComparator);
            } else {
                System.out.println("Введенный продукт больше наименьшего в коллекции!");
            }


        }

    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
