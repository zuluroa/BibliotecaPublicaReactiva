package co.com.sofka.Biblioteca.router;

import co.com.sofka.Biblioteca.dtos.RespuestaRecursoDTO;
import co.com.sofka.Biblioteca.usecase.ConsultarDisponibilidadUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarDisponibilidadRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> disponibilidadRecursos(ConsultarDisponibilidadUseCase useCase) {
        return route(GET("/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.apply(request.pathVariable("id")), RespuestaRecursoDTO.class));
    }
}
