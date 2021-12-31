package co.com.sofka.Biblioteca.router.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.dtos.RespuestaRecursoDTO;
import co.com.sofka.Biblioteca.router.ConsultarDisponibilidadRecursoRouter;
import co.com.sofka.Biblioteca.usecase.ConsultarDisponibilidadUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConsultarDisponibilidadRecursoRouter.class, ConsultarDisponibilidadUseCase.class})
class ConsultarDisponibilidadRecursoRouterTest {

    @MockBean
    private ConsultarDisponibilidadUseCase useCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    private void consultar(){
        var rescursoDTO = new RecursoDTO("1",true, "2021-12-31", "ALMAS", "1","1");
        var repuestaRecursoDTO = new RespuestaRecursoDTO();
        repuestaRecursoDTO.setFecha("2021-11-25");
        repuestaRecursoDTO.setDisponible(true);
        repuestaRecursoDTO.setDescripcion("El recurso esta disponible");

        Mockito.when(useCase.apply(rescursoDTO.getId()).thenReturn(Mono.just(repuestaRecursoDTO)));

        webTestClient.get().uri("/disponibilidad/{id}","1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecursoDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.getId().compareTo(rescursoDTO.getId()));
                });
    }

}