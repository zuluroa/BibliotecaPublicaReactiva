package co.com.sofka.Biblioteca.router.tiporecurso;


import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.usecase.tiporecurso.CrearTipoRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearTipoRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> crearTipoRecursos(CrearTipoRecursoUseCase useCase) {
        return route(POST("/creartiporecurso").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TipoRecursoDTO.class)
                        .flatMap(questionDTO -> useCase.save(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))

        );
    }
}
