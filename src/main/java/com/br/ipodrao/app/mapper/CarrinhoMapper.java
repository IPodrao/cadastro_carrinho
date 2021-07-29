package com.br.ipodrao.app.mapper;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.entity.CarrinhoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper {

    CarrinhoEntity carrinhoDTOtoCarrinhoEntity(CarrinhoDTO dto);
    CarrinhoDTO carrinhoEntityToCarrinhoDTO(CarrinhoEntity entity);

}
