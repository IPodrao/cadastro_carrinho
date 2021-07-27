package com.br.ipodrao.app.exception;

import com.br.ipodrao.app.error.ErrorMessage;

public class AlreadyExistsException extends RuntimeException {

    private String message;

    public AlreadyExistsException(ErrorMessage msg) {
        super(msg.getMessage());
        this.message = msg.getMessage();
    }
}
