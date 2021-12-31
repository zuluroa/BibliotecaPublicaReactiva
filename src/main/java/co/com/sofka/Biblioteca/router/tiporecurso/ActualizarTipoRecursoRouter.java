package co.com.sofka.Biblioteca.router.tiporecurso;


import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.usecase.tiporecurso.ActualizarTipoRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarTipoRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> actualizarTipoRecursos(ActualizarTipoRecursoUseCase useCase) {
        return route(PUT("/actualizartiporecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TipoRecursoDTO.class)
                        .flatMap(tipoRecursoDTO -> useCase.save(tipoRecursoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }
}
