package co.com.sofka.Biblioteca.router.recurso;


import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.usecase.recurso.ConsultarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarRecursos(ConsultarRecursoUseCase useCase) {
        return route(GET("consultar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(useCase.findById(request.pathVariable("id")), RecursoDTO.class));
    }
}
