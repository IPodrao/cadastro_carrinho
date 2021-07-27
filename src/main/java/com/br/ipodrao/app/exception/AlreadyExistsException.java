package com.br.ipodrao.app.exception;


public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
