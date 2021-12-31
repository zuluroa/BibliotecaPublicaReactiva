package co.com.sofka.Biblioteca.router.recurso;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.usecase.recurso.EliminarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EliminarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarRecursos(EliminarRecursoUseCase useCase) {
        return RouterFunctions.route(DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(useCase.deleteById(request.pathVariable("id")), RecursoDTO.class));
    }


}
