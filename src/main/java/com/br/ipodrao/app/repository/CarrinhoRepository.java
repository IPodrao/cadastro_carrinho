package com.br.ipodrao.app.repository;

import com.br.ipodrao.app.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    Optional<CarrinhoEntity> findByNome(String nome);

    Optional<CarrinhoEntity> findByLocal(String local);

}
