package co.com.sofka.Biblioteca.router;

import co.com.sofka.Biblioteca.dtos.RespuestaCategoriaDTO;
import co.com.sofka.Biblioteca.usecase.FiltrarCategoriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FiltrarCategoriaRouter {

    @Bean
    public RouterFunction<ServerResponse> filtarCategorias(FiltrarCategoriaUseCase useCase) {
        return route(GET("/filtrarcategoria/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.filtrarCategoria(request.pathVariable("id")), RespuestaCategoriaDTO.class));

    }
}
