package org.example.exception;

public class ScriptExecutionError extends Exception{
    public ScriptExecutionError(String message){
        super("ScriptExecutionError: " + message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
