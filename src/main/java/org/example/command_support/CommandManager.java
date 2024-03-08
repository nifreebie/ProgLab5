package org.example.command_support;

import lombok.Getter;
import org.example.commands.*;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager() {
        commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("help", new HelpCommand());
        commands.put("remove_by_id", new RemoveByIDCommand());
        commands.put("show", new ShowCommand());
        commands.put("info", new InfoCommand());
        commands.put("update", new UpdateCommand());
        commands.put("clear", new ClearCommand());
        commands.put("exit", new ExitCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("remove_lower", new RemoveLowerCommand());
        commands.put("print_descending", new PrintDescendingCommand());
        commands.put("print_field_descending_part_number", new PrintDescendingPartNumberCommand());

    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        command.execute();
    }

}
