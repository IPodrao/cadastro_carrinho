package com.br.ipodrao.app.controller;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.entity.CarrinhoEntity;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.mapper.CarrinhoMapper;
import com.br.ipodrao.app.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService service;

    @Autowired
    private CarrinhoMapper mapper;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CarrinhoEntity addCarrinho(@RequestBody CarrinhoDTO dto) {
        try {
            return service.addCarrinho(dto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Carrinho já cadastrado");

        }

    }

}
