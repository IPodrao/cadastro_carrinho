package com.br.ipodrao.app.service;

import com.br.ipodrao.app.entity.CarrinhoEntity;
import com.br.ipodrao.app.error.ErrorMessage;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.exception.NotFoundException;
import com.br.ipodrao.app.mapper.CarrinhoMapper;
import com.br.ipodrao.app.repository.CarrinhoRepository;
import com.br.ipodrao.app.dto.CarrinhoDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    private CarrinhoMapper mapper = Mappers.getMapper(CarrinhoMapper.class);

    public CarrinhoDTO buscaCarrinho(Long id) throws NotFoundException {
        Optional<CarrinhoEntity> maybeCarrinho = repository.findById(id.longValue());
        if (maybeCarrinho.isPresent()) {
            return mapper.carrinhoEntityToCarrinhoDTO(maybeCarrinho.get());
        } else {
            throw new NotFoundException(ErrorMessage.CARRINHO_NAO_ENCONTRADO);
        }

    }

    public CarrinhoDTO adicionaCarrinho(CarrinhoDTO dto) throws AlreadyExistsException {
        if (validaCarrinho(dto)) {
            CarrinhoEntity entity = repository.save(mapper.carrinhoDTOtoCarrinhoEntity(dto));
            return mapper.carrinhoEntityToCarrinhoDTO(entity);
        }
        return null;
    }

    public void removeCarrinho(Long id) throws NotFoundException {
        if (repository.existsById(id.longValue())) {
            CarrinhoEntity entity = repository.getById(id.longValue());
            repository.delete(entity);
        } else {
            throw new NotFoundException(ErrorMessage.CARRINHO_NAO_ENCONTRADO);
        }

    }

    private boolean validaCarrinho(CarrinhoDTO dto) throws AlreadyExistsException {
        if (repository.findByNome(dto.getNome()).isPresent()) {
            throw new AlreadyExistsException(ErrorMessage.CARRINHO_JA_CADASTRADO);
        }

        if (repository.findByLatitudeAndLongitude(dto.getLatitude(), dto.getLongitude()).isPresent()) {
            throw new AlreadyExistsException(ErrorMessage.LOCAL_JA_CADASTRADO);
        }
        return true;
    }
}
