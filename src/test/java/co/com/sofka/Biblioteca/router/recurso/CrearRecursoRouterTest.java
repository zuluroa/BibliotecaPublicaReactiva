package co.com.sofka.Biblioteca.router.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.mapper.RecursoMapper;
import co.com.sofka.Biblioteca.model.Recurso;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import co.com.sofka.Biblioteca.usecase.recurso.CrearRecursoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrearRecursoRouter.class, CrearRecursoUseCase.class, RecursoMapper.class})
class CrearRecursoRouterTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void crearRecurso() {

        Recurso recurso = new Recurso();
        recurso.setId("1");
        recurso.setNombreRecurso("LA LEYENDA DE HAN");
        recurso.setTipoRecursoId("1");
        recurso.setDisponible(true);
        recurso.setFecha("2021-12-31");
        recurso.setCategoriaId("1");


        RecursoDTO recursoDTO = new RecursoDTO(recurso.getId(),recurso.getDisponible(),recurso.getFecha(),recurso.getNombreRecurso(),recurso.getCategoriaId(),recurso.getTipoRecursoId());
        Mono<Recurso> mono = Mono.just(recurso);
        Mockito.when(repositorioRecurso.save(any())).thenReturn(mono);
        webTestClient.post()
                .uri("/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(recursoDTO), RecursoDTO.class)
                .exchange();
    }
}