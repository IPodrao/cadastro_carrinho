package com.br.ipodrao.app.exception;

public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
