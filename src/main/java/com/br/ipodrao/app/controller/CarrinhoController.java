package com.br.ipodrao.app.controller;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.exception.NotFoundException;
import com.br.ipodrao.app.mapper.CarrinhoMapper;
import com.br.ipodrao.app.service.CarrinhoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Carrinho")
@Slf4j
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @Autowired
    private CarrinhoMapper mapper;

    @ApiOperation("Adiciona um novo carrinho")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    CarrinhoDTO adicionaCarrinho(@RequestBody CarrinhoDTO dto) throws AlreadyExistsException {
        log.debug("adicionaCarrinho: %s", dto.toString());
        return service.adicionaCarrinho(dto);
    }

    @ApiOperation("Remove um determinado carrinho")
    @DeleteMapping("/{id}")
    ResponseEntity removeCarrinho(@PathVariable Long id) throws NotFoundException {
        log.debug("removeCarrinho: %s", id);
        service.removeCarrinho(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @ApiOperation("Busca um determinado carrinho")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    CarrinhoDTO buscaCarrinho(@PathVariable Long id) throws NotFoundException {
        log.debug("buscaCarrinho: %s", id);
        return service.buscaCarrinho(id);
    }

    @ApiOperation("Busca todos os carrinhos")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<CarrinhoDTO> buscaTodosCarrinhos() throws NotFoundException {
        log.debug("buscaTodosCarrinhos: ");
        return service.buscaTodosCarrinhos();
    }

}
