package co.com.sofka.Biblioteca.mapper;

import co.com.sofka.Biblioteca.dtos.RecursoDTO;
import co.com.sofka.Biblioteca.dtos.RespuestaCategoriaDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class RespuestaCategoriaMapper {
    public Function<Flux<RecursoDTO>, RespuestaCategoriaDTO> recursoToRespuesta(Mono<String> nombre) {
        return recursoDTOFlux -> {
            RespuestaCategoriaDTO respuestaCategoriaDTO = new RespuestaCategoriaDTO();
            respuestaCategoriaDTO.setCategoria(nombre);
            respuestaCategoriaDTO.setRecursosCategoria(recursoDTOFlux);
            return respuestaCategoriaDTO;
        };
    }
}
