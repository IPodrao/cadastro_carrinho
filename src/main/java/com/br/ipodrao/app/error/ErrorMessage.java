package com.br.ipodrao.app.error;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    CARRINHO_NAO_ENCONTRADO("Carrinho não encontrado"),

    CARRINHO_JA_CADASTRADO("Carrinho já cadastrado"),

    LOCAL_JA_CADASTRADO("Local já cadastrado");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

}
