package org.example.exception;
/**
 * Класс ошибки выполнения скрипта
 */
public class ScriptExecutionError extends Exception{
    public ScriptExecutionError(String message){
        super("ScriptExecutionError: " + message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
