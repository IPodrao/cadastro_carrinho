package com.br.ipodrao.app.repository;

import com.br.ipodrao.app.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

    Optional<CarrinhoEntity> findByNome(String nome);

    Optional<CarrinhoEntity> findByLatitudeAndLongitude(Double latitude, Double longitude);

}
