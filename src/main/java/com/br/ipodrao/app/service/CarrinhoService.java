package com.br.ipodrao.app.service;

import com.br.ipodrao.app.entity.CarrinhoEntity;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.exception.NotFoundException;
import com.br.ipodrao.app.mapper.CarrinhoMapper;
import com.br.ipodrao.app.repository.CarrinhoRepository;
import com.br.ipodrao.app.dto.CarrinhoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    @Autowired
    private CarrinhoMapper mapper;

    public CarrinhoEntity buscaCarrinho(Long id) throws NotFoundException {
         Optional<CarrinhoEntity> maybeCarrinho = repository.findById(id.longValue());
         if(maybeCarrinho.isPresent()){
             return maybeCarrinho.get();
        }
         else{
             throw new NotFoundException("Carrinho não encontrado");
         }

    }

    public CarrinhoEntity adicionaCarrinho(CarrinhoDTO dto) throws AlreadyExistsException{
        if (validaCarrinho(dto)) {
            CarrinhoEntity entity = repository.save(mapper.toEntity(dto));
            return entity;
        }
        return null;
    }

    public void removeCarrinho(Long id) throws NotFoundException {
        if (repository.existsById(id.longValue())) {
            CarrinhoEntity entity = repository.getById(id.longValue());
            repository.delete(entity);
        } else {
            throw new NotFoundException("Carrinho não existe");
        }

    }

    private boolean validaCarrinho(CarrinhoDTO dto) throws AlreadyExistsException {
        if (repository.findByNome(dto.getNome()).isPresent()) {
            throw new AlreadyExistsException("O carrinho já cadastrado");
        }

        if (repository.findByLocal(dto.getLocal()).isPresent()) {
            throw new AlreadyExistsException("Local já cadastrado");
        }
        return true;
    }
}
