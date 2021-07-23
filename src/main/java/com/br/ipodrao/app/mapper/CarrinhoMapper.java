package com.br.ipodrao.app.mapper;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.entity.CarrinhoEntity;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoMapper {

    public CarrinhoEntity toEntity(CarrinhoDTO dto) {
        return new CarrinhoEntity(dto.getNome(), dto.getLocal());
    }
}
