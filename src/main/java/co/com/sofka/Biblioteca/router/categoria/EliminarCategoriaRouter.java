package co.com.sofka.Biblioteca.router.categoria;


import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.usecase.categoria.EliminarCategoriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class EliminarCategoriaRouter {
    @Bean
    public RouterFunction<ServerResponse> eliminarCategorias(EliminarCategoriaUseCase useCase) {
        return RouterFunctions.route(DELETE("/eliminarcategoria/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(useCase.deleteByIdCategoria(request.pathVariable("id")), CategoriaDTO.class));
    }
}
