package com.br.ipodrao.app.exception;


public class AlreadyExistsException extends RuntimeException {

    private String message;

    public AlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
