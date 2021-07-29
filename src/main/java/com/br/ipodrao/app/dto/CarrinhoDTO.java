package com.br.ipodrao.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarrinhoDTO {

    private long id;
    private String nome;
    private Double latitude;
    private Double longitude;
}
