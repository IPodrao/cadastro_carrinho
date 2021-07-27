package com.br.ipodrao.app.exception;

import com.br.ipodrao.app.error.ErrorMessage;

public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(ErrorMessage msg) {
        super(msg.getMessage());
        this.message = msg.getMessage();
    }
}
