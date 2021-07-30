package com.br.ipodrao.app.service;

import com.br.ipodrao.app.dto.CarrinhoDTO;
import com.br.ipodrao.app.entity.CarrinhoEntity;
import com.br.ipodrao.app.exception.AlreadyExistsException;
import com.br.ipodrao.app.repository.CarrinhoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CarrinhoServiceTest {

    @InjectMocks
    private CarrinhoService service;

    @Mock
    private CarrinhoRepository repository;


    @DisplayName("Adiciona Carrinho")
    @Test
    void adicionaCarrinhoTest() {
        CarrinhoDTO dto = new CarrinhoDTO(0, "Carrinho do zé", 123123D, 13432453D);
        CarrinhoEntity entity = getCarrinhoEntity();

        doReturn(entity).when(repository).save(any(CarrinhoEntity.class));

        CarrinhoDTO result = service.adicionaCarrinho(dto);
        Assertions.assertEquals(result.getNome(), dto.getNome());
    }

    @DisplayName("Remove Carrinho")
    @Test
    void removeCarrinhoTest() {
        CarrinhoEntity entity = getCarrinhoEntity();

        doReturn(true).when(repository).existsById(1L);
        doReturn(entity).when(repository).getById(1L);

        service.removeCarrinho(1L);
    }

    @DisplayName("Busca Carrinho")
    @Test
    void buscaCarrinhoTest() {
        Optional<CarrinhoEntity> maybeCarrinho = Optional.of(getCarrinhoEntity());

        doReturn(maybeCarrinho).when(repository).findById(1L);

        CarrinhoDTO result = service.buscaCarrinho(1L);
        Assertions.assertEquals(result.getNome(), maybeCarrinho.get().getNome());
    }

    @DisplayName("Valida carrinho com mesmo nome")
    @Test
    void adicionaCarrinhoMesmoNomeTest() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            Optional<CarrinhoEntity> maybeCarrinho = Optional.of(getCarrinhoEntity());
            CarrinhoDTO dto = new CarrinhoDTO(0, "Carrinho do zé", 123123D, 13432453D);

            doReturn(maybeCarrinho).when(repository).findByNome(dto.getNome());
            CarrinhoDTO result = service.adicionaCarrinho(dto);
        });
    }

    @DisplayName("Valida carrinho com mesma latitude e longitude")
    @Test
    void adicionaCarrinhoMesmoLocalTest() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            Optional<CarrinhoEntity> maybeCarrinho = Optional.of(getCarrinhoEntity());
            CarrinhoDTO dto = new CarrinhoDTO(0, "Carrinho do zé", 123123D, 13432453D);

            doReturn(maybeCarrinho).when(repository).findByLatitudeAndLongitude(dto.getLatitude(), dto.getLongitude());
            CarrinhoDTO result = service.adicionaCarrinho(dto);
        });
    }

    private CarrinhoEntity getCarrinhoEntity() {
        CarrinhoEntity entity = new CarrinhoEntity();
        entity.setId(1L);
        entity.setNome("Carrinho do zé");
        entity.setLatitude(123123D);
        entity.setLongitude(13432453D);
        return entity;
    }


}