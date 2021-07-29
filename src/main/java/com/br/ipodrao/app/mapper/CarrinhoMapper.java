package com.br.ipodrao.app.mapper;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.entity.CarrinhoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper {

    CarrinhoEntity carrinhoDTOtoCarrinhoEntity(CarrinhoDTO dto);

    List<CarrinhoDTO> listCarrinhoEntitytoListCarrinhoDTO(List<CarrinhoEntity> entity);

    CarrinhoDTO carrinhoEntityToCarrinhoDTO(CarrinhoEntity entity);

}
