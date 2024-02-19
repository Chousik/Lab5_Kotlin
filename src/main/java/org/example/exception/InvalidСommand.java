package org.example.exception;

public class InvalidСommand extends Exception {
    private String Command;
    public InvalidСommand(String command){
        super("InvalidСommand");
        this.Command = command;

    }

    @Override
    public String toString() {
        return this.getMessage()+": команда " + Command + " не найдена.";
    }
}
