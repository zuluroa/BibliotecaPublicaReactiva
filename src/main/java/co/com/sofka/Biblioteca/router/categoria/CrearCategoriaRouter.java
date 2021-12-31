package co.com.sofka.Biblioteca.router.categoria;

import co.com.sofka.Biblioteca.dtos.CategoriaDTO;
import co.com.sofka.Biblioteca.usecase.categoria.CrearCategoriaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearCategoriaRouter {
    @Bean
    public RouterFunction<ServerResponse> createCategoria(CrearCategoriaUseCase useCase) {
        return route(POST("/crearcategoria").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CategoriaDTO.class)
                        .flatMap(questionDTO -> useCase.save(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
                        )
        );
    }
}
