package org.example.exception;

public class ScriptRunErorr extends Exception{
    public ScriptRunErorr(String message){
        super("ScriptRunErorr" + message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
