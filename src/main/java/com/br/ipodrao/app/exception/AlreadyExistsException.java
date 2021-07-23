package com.br.ipodrao.app.exception;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
