package co.com.sofka.Biblioteca.usecase.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
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
class EliminarRecursoUseCaseTest {
    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private EliminarRecursoUseCase useCase;

    @Test
    private void eliminarRecurso(){
        var recursoDTO = new RecursoDTO("1",true, "2021-12-31", "ALMAS", "1","1");

        Mockito.when(repositorioRecurso.deleteById("1")).thenReturn(Mono.empty());

        var result = useCase.deleteById("1").block();
        Assertions.assertEquals(result,null);
    }
}