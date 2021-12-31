package co.com.sofka.Biblioteca.usecase.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.model.Recurso;
import co.com.sofka.Biblioteca.repositorios.RepositorioRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrearRecursoUseCaseTest {
    @SpyBean
    private CrearRecursoUseCase useCase;

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Test
    public void crearRecurso() {

        Recurso recurso = new Recurso();
        recurso.setId("1");
        recurso.setNombreRecurso("LA LEYENDA DE HAN");
        recurso.setTipoRecursoId("1");
        recurso.setDisponible(true);
        recurso.setFecha("2021-12-31");
        recurso.setCategoriaId("1");

        var RecursoDTO = new RecursoDTO(recurso.getId(),
                recurso.getDisponible(),recurso.getFecha(),
                recurso.getNombreRecurso(),recurso.getCategoriaId(),
                recurso.getTipoRecursoId());


        Mockito.when(repositorioRecurso.save(Mockito.any(Recurso.class))).thenReturn(Mono.just(recurso));

        var result = useCase.apply(RecursoDTO);
        Assertions.assertEquals(result.block().getId(), "1");
    }
}