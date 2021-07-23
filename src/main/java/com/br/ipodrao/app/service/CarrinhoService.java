package com.br.ipodrao.app.service;

import com.br.ipodrao.app.entity.CarrinhoEntity;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.mapper.CarrinhoMapper;
import com.br.ipodrao.app.repository.CarrinhoRepository;
import com.br.ipodrao.app.dto.CarrinhoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private CarrinhoMapper mapper;

    public CarrinhoEntity addCarrinho(CarrinhoDTO dto) throws AlreadyExistsException {
        if (validateCarrinho(dto)) {
            CarrinhoEntity entity = repository.save(mapper.toEntity(dto));
            return entity;
        }
        return null;
    }

    private boolean validateCarrinho(CarrinhoDTO dto) throws AlreadyExistsException {
        if (repository.findByNome(dto.getNome()).isPresent()) {
            throw new AlreadyExistsException("O carrinho já cadastrado");
        }

        if (repository.findByLocal(dto.getLocal()).isPresent()) {
            throw new AlreadyExistsException("Local já cadastrado");
        }
        return true;
    }
}
