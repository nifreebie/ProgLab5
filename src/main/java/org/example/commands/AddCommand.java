package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.ProductComparator;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.ProductDTO;

public class AddCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не доджно быть аргумента!");
        } else {
            ProductCreator productCreator = new ProductCreator();
            ProductDTO productDTO = productCreator.createNewProduct();
            CollectionManager collectionManager = this.app.getCollectionManager();
            collectionManager.add(productDTO);
            System.out.println("✓Продукт добавлен в коллекцию");
            ProductComparator productComparator = new ProductComparator();
            collectionManager.sort(productComparator);
        }

    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "add";
    }
}
