package org.example.exception;

/**
 * Класс ошибки неверной команды
 */
public class InvalidCommandError extends Exception {
    private String command;

    public InvalidCommandError(String command) {
        super("InvalidCommandError");
        this.command = command;

    }

    @Override
    public String toString() {
        return this.getMessage() + ": команда " + command + " не найдена.";
    }
}
