package de.stefan.progra.projects.homework9;

public class UnknownKeyException extends Exception{
    String error;
    public UnknownKeyException(String error) {
        this.error = error;
    }

    public UnknownKeyException() {
        this("Unknown key");
    }

    @Override
    public String toString() {
        return error;
    }
}
