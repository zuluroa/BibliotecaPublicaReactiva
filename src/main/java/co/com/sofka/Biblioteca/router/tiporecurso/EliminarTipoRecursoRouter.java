package co.com.sofka.Biblioteca.router.tiporecurso;

import co.com.sofka.Biblioteca.dtos.TipoRecursoDTO;
import co.com.sofka.Biblioteca.usecase.tiporecurso.EliminarTipoRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EliminarTipoRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarTipoRecursos(EliminarTipoRecursoUseCase useCase) {
        return RouterFunctions.route(DELETE("/eliminartiporecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.deleteByIdTipoRecurso(request.pathVariable("id")), TipoRecursoDTO.class));
    }
}
