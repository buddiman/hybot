package de.hoellriegl.commands;

// TODO documentation
public interface ICommand {
    void prepare();
    void execute();
    void cleanup();
}
