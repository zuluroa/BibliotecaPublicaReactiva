package co.com.sofka.Biblioteca.router.categoria;


import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.usecase.categoria.ActualizarCategoriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarCategoriaRouter {

    @Bean
    public RouterFunction<ServerResponse> actualizarCategoriaId(ActualizarCategoriaUseCase useCase) {
        return route(PUT("/actualizarcategoria").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CategoriaDTO.class)
                        .flatMap(categoriaDTO -> useCase.save(categoriaDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }
}
