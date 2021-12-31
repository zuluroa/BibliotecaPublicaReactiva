package co.com.sofka.Biblioteca.router.tiporecurso;


import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.usecase.tiporecurso.ConsultarTipoRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarListaTipoRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarListTipoRecursos(ConsultarTipoRecursoUseCase useCase) {
        return route(GET("/tiporecursos").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), TipoRecursoDTO.class))
        );
    }
}
