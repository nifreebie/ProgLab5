package org.example.command_support;

import org.example.service.AppContainer;

abstract public class Command {
    protected final AppContainer app;

    public Command() {
        this.app = AppContainer.getInstance();
    }

    public abstract void execute();

    public abstract String getDescription();

    public abstract String getName();
}
