package com.br.ipodrao.app.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlreadyExistsException extends RuntimeException {
    private String errorMessage;

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}