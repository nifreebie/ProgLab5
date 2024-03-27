package org.example.commands;

import org.example.command_support.Command;
import org.example.command_support.CommandWithIdArgument;
import org.example.controller.ConsoleManager;
import org.example.controller.ReqWriter;
import org.example.dao.CollectionManager;
import org.example.model.ProductDTO;
import org.example.service.Request;

public class UpdateCommand extends Command implements CommandWithIdArgument {
    @Override
    public void execute() {
        if (!Request.isCommandArg()) {
            ReqWriter.write("У команды должен быть аргумент!");
        } else {
            CollectionManager collectionManager = this.app.getCollectionManager();
            if (collectionManager.getSize() == 0) {
                ReqWriter.write("Коллекция пустая");
            } else {
                try {
                    long updateid = Request.getArgId();
                    if (collectionManager.isIdExists(updateid)) {
                        ReqWriter.write("Такого id не существует!");
                    } else {
                        ProductCreator productCreator = new ProductCreator();
                        ProductDTO productDTO = productCreator.createNewProduct();
                        collectionManager.updateById(updateid, productDTO);
                        ReqWriter.write("✓Продукт с id: " + updateid + " был обновлен");
                    }
                } catch (NumberFormatException e) {
                    ReqWriter.write("Неверный формат ввола аргумента!");
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}
