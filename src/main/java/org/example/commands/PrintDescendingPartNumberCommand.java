package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.PartNumberProductComparator;
import org.example.command_support.ProductComparator;
import org.example.controller.ConsoleManager;
import org.example.dao.CollectionManager;
import org.example.model.Product;

public class PrintDescendingPartNumberCommand extends Command {
    @Override
    public void execute() {
        if (ConsoleManager.getIsCommandArg()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            PartNumberProductComparator comparator = new PartNumberProductComparator();
            collectionManager.sort(comparator);
            for (Product p : collectionManager.getProducts()) {
                System.out.println(p.getPartNumber());
            }
            ProductComparator productComparator = new ProductComparator();
            collectionManager.sort(productComparator);
        }
    }

    @Override
    public String getDescription() {
        return "вывести значения поля partNumber всех элементов в порядке убывания";
    }

    @Override
    public String getName() {
        return "print_field_descending_part_number";
    }
}
